package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class WebAPIDataBaseCustomReporter implements IReporter {

	Connection conn;
	private ArrayList<String> chromePassedArray = new ArrayList<String>();
	private ArrayList<String> chromeSkippedArray = new ArrayList<String>();
	private ArrayList<String> chromeFailedArray = new ArrayList<String>();
	private ArrayList<WebAPITestcaseDetailObject> detailResult;
	private HashMap<String, Integer> testCaseResultMap = new HashMap<String, Integer>();
	private HashMap<String, String> testSuiteResultMap = new HashMap<String, String>();
	private List<String> allMethods = new ArrayList<>();
	List<String> testCases;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String arg2) {

		print("Suites run: " + suites.size());
		for (ISuite suite : suites) {
			print("Suite>" + suite.getName());
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			detailResult = new ArrayList<WebAPITestcaseDetailObject>();
			for (String testName : suiteResults.keySet()) {
				if (testName.equalsIgnoreCase("API")) {
					System.out.println("Browser::" + testName);
					ISuiteResult suiteResult = suiteResults.get(testName);
					ITestContext testContext = suiteResult.getTestContext();
					ITestNGMethod[] x = testContext.getAllTestMethods();

					for (ITestNGMethod iTestNGMethod : x) {
						allMethods.add(iTestNGMethod.getMethodName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((iTestNGMethod.getTestClass().toString())).split("\\.")[1]));
						iTestNGMethod.getDescription();
					}
					IResultMap failedResult = testContext.getFailedTests();
					Set<ITestResult> testsFailed = failedResult.getAllResults();
					for (ITestResult testResult : testsFailed) {
						chromeFailedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap passResult = testContext.getPassedTests();
					Set<ITestResult> testsPassed = passResult.getAllResults();
					for (ITestResult testResult : testsPassed) {

						chromePassedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap skippedResult = testContext.getSkippedTests();
					Set<ITestResult> testsSkipped = skippedResult.getAllResults();
					for (ITestResult testResult : testsSkipped) {
						chromeSkippedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
					}
				}
			}
			testCases = removeDuplicates(allMethods);
			System.out.println("Following Testcases are Executed...!");
			for (String tc : testCases) {
				System.out.println(tc);
				String CH_STATUS = null;

				if (!(chromePassedArray.size() == 0) | !(chromeFailedArray.size() == 0) | !(chromeSkippedArray.size() == 0)) {
					if (chromePassedArray.contains(tc)) {
						CH_STATUS = "PASS";
					}
					else if (chromeFailedArray.contains(tc)) {
						CH_STATUS = "FAIL";
					}
					else if (chromeSkippedArray.contains(tc)) {
						CH_STATUS = "SKIP";
					}
					else {
						CH_STATUS = "NOT_TESTED";
					}
				}
				else if ((chromePassedArray.size() == 0) && (chromeFailedArray.size() == 0) && (chromeSkippedArray.size() == 0)) {
					CH_STATUS = "NOT_TESTED";
				}

				if (((CH_STATUS == "PASS") | (CH_STATUS == "NOT_TESTED"))) {
					detailResult.add(new WebAPITestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace((tc.toString())).split("\\.")[0], CH_STATUS));
				}
				else if ((CH_STATUS == "FAIL")) {
					detailResult.add(new WebAPITestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace((tc.toString())).split("\\.")[0], CH_STATUS));
				}
				else if ((CH_STATUS == "SKIP")) {
					detailResult.add(new WebAPITestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace((tc.toString())).split("\\.")[0], CH_STATUS));
				}
				else {
					detailResult.add(new WebAPITestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace((tc.toString())).split("\\.")[0], CH_STATUS));
				}
			}
		
			testCaseResultMap.put("num_of_testcases", allMethods.size());
			testCaseResultMap.put("passed", chromePassedArray.size());
			testCaseResultMap.put("failed", chromeFailedArray.size());
			testCaseResultMap.put("skipped", chromeSkippedArray.size());

			System.out.println("Total "+ allMethods.size()+"-Testcases Executed------End/");
		
			try {
				if (testCaseResultMap.get("failed") == 0 && testCaseResultMap.get("skipped") == 0) {
					testSuiteResultMap.put(suite.getName(), "PASS");
					System.out.println(suite.getName() + "-PASS");
				}
				else {
					testSuiteResultMap.put(suite.getName(), "FAIL");
					System.out.println(suite.getName() + "FAIL");
				}
			}
			catch (Exception e) {
				System.out.println("asdfasdfkjasdkfjalksdjflk");
				System.err.println(e.getMessage());
			}

			try {
				InsertResultsToReportSummaryTable("api_autresult_summary", "111", "kishore", suite.getName(), testSuiteResultMap.get(suite.getName()), testCaseResultMap.get("num_of_testcases"), testCaseResultMap.get("passed"),
						testCaseResultMap.get("failed"), testCaseResultMap.get("skipped"));
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				System.err.println("DB-Error: While Insertinginto InsertResultsToReportSummaryTable");
			}
			finally {
				Reporter.log("uploading to" + ConfiguratorSupport.getProperty("reportSummaryTable","config.properties")+ "........." + "over");
			}
			try {
				if (detailResult.size() == 0) {
					System.out.println("Detail_Result_List Null");
					throw new EmptyStackException();
				}
				else {
					for (WebAPITestcaseDetailObject result : detailResult) {
						try {
							InsertResultsToReportDetailTable(ConfiguratorSupport.getProperty("reportDetailTable","config.properties"), getSuiteRunId(ConfiguratorSupport.getProperty("reportSummaryTable","config.properties")), result.getScenario(), result.getTestcasename(), result.getStatus());
							System.out.println("Trying to insert Record:" + ConfiguratorSupport.getProperty("reportDetailTable","config.properties"));
							Reporter.log("one row inserted to::" + ConfiguratorSupport.getProperty("reportDetailTable","config.properties"));
						}
						catch (Exception e) {
							System.err.println("DB-Error: While Insertinginto InsertResultsToReportDetailTable");
							System.err.println(e.getMessage());
							Reporter.log(e.getMessage()+"\n DB-Error: While Insertinginto InsertResultsToReportDetailTable");
						}
					}
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				Reporter.log(e.getMessage());
			}
		}
		Reporter.log("uploading to" + ConfiguratorSupport.getProperty("reportSummaryTable","config.properties") + "........." + "over");
	}

	public void print(String text) {
		System.out.println(text);
	}

	public List<String> removeDuplicates(List<String> tempTestcases2) {
		ArrayList<String> result = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		for (String item : tempTestcases2) {
			if (!set.contains(item)) {
				result.add(item);
				set.add(item);
			}
		}
		return result;
	}

	public Connection setMysqlDBConnection(String USER_NAME, String PASSWORD, String DATA_BASE_NAME) throws ClassNotFoundException, SQLException {
		final String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/" + DATA_BASE_NAME;
		Class.forName(MYSQL_JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		return conn;
	}

	public void InsertResultsToReportDetailTable(String tablename, Integer test_run_id, String scenario, String testcase, String result) {
		try {
			String query = "INSERT INTO " + tablename + "(`test_run_id`, `scenario`, `testcase`, `result`) " + " VALUES (?,?,?,?)";
			conn = setMysqlDBConnection(ConfiguratorSupport.getProperty("dbUser","config.properties"), ConfiguratorSupport.getProperty("dbPassword","config.properties"), ConfiguratorSupport.getProperty("db","config.properties"));
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, test_run_id);
			preparedStmt.setString(2, scenario);
			preparedStmt.setString(3, testcase);
			preparedStmt.setString(4, result);
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.err.println("Got an exception!- InsertResultsToReportDetailTable()");
			Reporter.log(e.getMessage()+"\n Got an exception!- InsertResultsToReportDetailTable()");
			System.err.println(e.getMessage());
		}
	}

	public Integer getSuiteRunId(String tablename) {
		int id = 0;
		try {

			conn = setMysqlDBConnection(ConfiguratorSupport.getProperty("dbUser","config.properties"), ConfiguratorSupport.getProperty("dbPassword","config.properties"), ConfiguratorSupport.getProperty("db","config.properties"));
			PreparedStatement preparedStmt = conn.prepareStatement("SELECT run_id FROM " + ConfiguratorSupport.getProperty("reportSummaryTable","config.properties") + " ORDER BY run_id DESC LIMIT 1");
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("run_id");
			}
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			print("Looking for Run id form table: " + tablename);
		}
		catch (Exception e) {
			System.err.println("Got an exception!- getSuiteRunId()");
			Reporter.log(e.getMessage()+"\n Got an exception!- getSuiteRunId()");
			System.err.println(e.getMessage());
		}
		return id;
	}

	public void InsertResultsToReportSummaryTable(String tablename, String ticket, String user, String suite, String result, Integer tot_testcases, Integer passed, Integer failed, Integer skipped) {
		try {
			Timestamp tcExecutionTime = new java.sql.Timestamp(new java.util.Date().getTime());
			String query = "INSERT INTO " + tablename + "(`ticket`,`user`,`datetime`,`suite`,`result`,`tot_testcases`,`passed`,`failed`,`skipped`) " + " VALUES (?,?,?,?,?,?,?,?,?)";
			conn = setMysqlDBConnection(ConfiguratorSupport.getProperty("dbUser","config.properties"), ConfiguratorSupport.getProperty("dbPassword","config.properties"), ConfiguratorSupport.getProperty("db","config.properties"));
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, ticket);
			preparedStmt.setString(2, user);
			preparedStmt.setTimestamp(3, tcExecutionTime);
			preparedStmt.setString(4, suite);
			preparedStmt.setString(5, result);
			preparedStmt.setInt(6, tot_testcases);
			preparedStmt.setInt(7, passed);
			preparedStmt.setInt(8, failed);
			preparedStmt.setInt(9, skipped);
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			Reporter.log("Test Results uploading to:: " + tablename);
		}
		catch (Exception e) {
			System.err.println("Got an exception!- InsertResultsToReportSummaryTable()");
			Reporter.log(e.getMessage()+"\n Got an exception!- InsertResultsToReportSummaryTable()");
			System.err.println(e.getMessage());
		}
	}
}
