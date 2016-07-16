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

import base.BaseTest;

/**
 * @author kishorekalapala
 *
 * @project AutomationFramework
 * Aug 20, 2015
 */
public class DataBaseCustomReporter implements IReporter {
	Connection conn;
	private ArrayList<String> chromePassedArray = new ArrayList<String>();
	private ArrayList<String> chromeSkippedArray = new ArrayList<String>();
	private ArrayList<String> chromeFailedArray = new ArrayList<String>();
	private ArrayList<String> firefoxPassedArray = new ArrayList<String>();
	private ArrayList<String> firefoxSkippedArray = new ArrayList<String>();
	private ArrayList<String> firefoxFailedArray = new ArrayList<String>();
	private ArrayList<String> iePassedArray = new ArrayList<String>();
	private ArrayList<String> ieFailedArray = new ArrayList<String>();
	private ArrayList<String> ieSkippedArray = new ArrayList<String>();
	private ArrayList<TestcaseDetailObject> detailResult;
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
			detailResult = new ArrayList<TestcaseDetailObject>();
			for (String testName : suiteResults.keySet()) {
				if (testName.equalsIgnoreCase("Chrome")) {
					System.out.println("Browser::" + testName);
					ISuiteResult suiteResult = suiteResults.get(testName);
					ITestContext testContext = suiteResult.getTestContext();
					ITestNGMethod[] x = testContext.getAllTestMethods();
					for (ITestNGMethod iTestNGMethod : x) {
						allMethods.add(iTestNGMethod.getMethodName() + "."
								+ StringUtils.chop(StringUtils.deleteWhitespace((iTestNGMethod.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap failedResult = testContext.getFailedTests();
					Set<ITestResult> testsFailed = failedResult.getAllResults();
					for (ITestResult testResult : testsFailed) {
						chromeFailedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap passResult = testContext.getPassedTests();
					Set<ITestResult> testsPassed = passResult.getAllResults();
					for (ITestResult testResult : testsPassed) {
						if (testName.equalsIgnoreCase("Chrome")) {
							chromePassedArray.add(testResult.getName() + "."
									+ StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
						}
					}
					IResultMap skippedResult = testContext.getSkippedTests();
					Set<ITestResult> testsSkipped = skippedResult.getAllResults();
					for (ITestResult testResult : testsSkipped) {
						if (testName.equalsIgnoreCase("Chrome")) {
							chromeSkippedArray.add(testResult.getName() + "."
									+ StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
						}
					}
				} else if (testName.equalsIgnoreCase("Firefox")) {
					System.out.println("Browser::" + testName);
					ISuiteResult suiteResult = suiteResults.get(testName);
					ITestContext testContext = suiteResult.getTestContext();
					ITestNGMethod[] x = testContext.getAllTestMethods();
					for (ITestNGMethod iTestNGMethod : x) {
						allMethods.add(iTestNGMethod.getMethodName() + "."
								+ StringUtils.chop(StringUtils.deleteWhitespace((iTestNGMethod.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap failedResult = testContext.getFailedTests();
					Set<ITestResult> testsFailed = failedResult.getAllResults();
					for (ITestResult testResult : testsFailed) {
						firefoxFailedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
						System.out.println("ff-failed");
						System.out.println(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap passResult = testContext.getPassedTests();
					Set<ITestResult> testsPassed = passResult.getAllResults();
					for (ITestResult testResult : testsPassed) {
						if (testName.equalsIgnoreCase("Firefox")) {
							firefoxPassedArray.add(testResult.getName() + "."
									+ StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));

						}
					}
					IResultMap skippedResult = testContext.getSkippedTests();
					Set<ITestResult> testsSkipped = skippedResult.getAllResults();
					for (ITestResult testResult : testsSkipped) {
						if (testName.equalsIgnoreCase("Firefox")) {
							firefoxSkippedArray.add(testResult.getName() + "."
									+ StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
						}
					}
				} else if (testName.equalsIgnoreCase("IE")) {
					System.out.println("Browser::" + testName);
					ISuiteResult suiteResult = suiteResults.get(testName);
					ITestContext testContext = suiteResult.getTestContext();
					ITestNGMethod[] x = testContext.getAllTestMethods();
					for (ITestNGMethod iTestNGMethod : x) {
						allMethods.add(iTestNGMethod.getMethodName() + "."
								+ StringUtils.chop(StringUtils.deleteWhitespace((iTestNGMethod.getTestClass().toString())).split("\\.")[1]));
					}
					IResultMap failedResult = testContext.getFailedTests();
					Set<ITestResult> testsFailed = failedResult.getAllResults();
					for (ITestResult testResult : testsFailed) {
						ieFailedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));

					}
					IResultMap passResult = testContext.getPassedTests();
					Set<ITestResult> testsPassed = passResult.getAllResults();

					for (ITestResult testResult : testsPassed) {
						if (testName.equalsIgnoreCase("IE")) {
							iePassedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
						}
					}
					IResultMap skippedResult = testContext.getSkippedTests();
					Set<ITestResult> testsSkipped = skippedResult.getAllResults();

					for (ITestResult testResult : testsSkipped) {
						if (testName.equalsIgnoreCase("IE")) {
							ieSkippedArray.add(testResult.getName() + "." + StringUtils.chop(StringUtils.deleteWhitespace((testResult.getTestClass().toString())).split("\\.")[1]));
						}
					}
				}
			}
			testCases = removeDuplicates(allMethods);
			System.out.println("all methods-------Started--");
			for (String tc : testCases) {
				System.out.println(tc);
				String CH_STATUS = null;
				String FF_STATUS = null;
				String IE_STATUS = null;
				String FINAL_STATUS = null;

				if (!(chromePassedArray.size() == 0) | !(chromeFailedArray.size() == 0) | !(chromeSkippedArray.size() == 0)) {
					if (chromePassedArray.contains(tc)) {
						CH_STATUS = "PASS";
					} else if (chromeFailedArray.contains(tc)) {
						CH_STATUS = "FAIL";
					} else if (chromeSkippedArray.contains(tc)) {
						CH_STATUS = "SKIP";
					} else {
						CH_STATUS = "NOT_TESTED";
					}
				} else if ((chromePassedArray.size() == 0) && (chromeFailedArray.size() == 0) && (chromeSkippedArray.size() == 0)) {
					
						CH_STATUS = "NOT_TESTED";
				}
				if (!(firefoxPassedArray.size() == 0) | !(firefoxFailedArray.size() == 0) | !(firefoxSkippedArray.size() == 0)) {
					if (firefoxPassedArray.contains(tc)) {
						FF_STATUS = "PASS";
					} else if (firefoxFailedArray.contains(tc)) {
						FF_STATUS = "FAIL";
					} else if (firefoxSkippedArray.contains(tc)) {
						FF_STATUS = "SKIP";
					} else {
						FF_STATUS = "NOT_TESTED";
					}
				} else if ((firefoxPassedArray.size() == 0) && (firefoxFailedArray.size() == 0) && (firefoxSkippedArray.size() == 0)) {
						
						FF_STATUS = "NOT_TESTED";
				}
				if (!(iePassedArray.size() == 0) | !(ieFailedArray.size() == 0) | !(ieSkippedArray.size() == 0)) {
					if (iePassedArray.contains(tc)) {
						IE_STATUS = "PASS";
					} else if (ieFailedArray.contains(tc)) {
						IE_STATUS = "FAIL";
					} else if (ieSkippedArray.contains(tc)) {
						IE_STATUS = "SKIP";
					} else {
						IE_STATUS = "NOT_TESTED";
					}
				} else if ((iePassedArray.size() == 0) && (ieFailedArray.size() == 0) && (ieSkippedArray.size() == 0)) {
						
						IE_STATUS = "NOT_TESTED";
				}

				if (((CH_STATUS == "PASS") | (CH_STATUS == "NOT_TESTED")) && ((FF_STATUS == "PASS") | (FF_STATUS == "NOT_TESTED"))
						&& ((IE_STATUS == "PASS") | (IE_STATUS == "NOT_TESTED"))) {
					FINAL_STATUS = "PASS";
					detailResult.add(new TestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace(
							(tc.toString())).split("\\.")[0], FINAL_STATUS, CH_STATUS, FF_STATUS, IE_STATUS));
				} else if ((CH_STATUS == "FAIL") | (FF_STATUS == "FAIL") | (IE_STATUS == "FAIL")) {
					FINAL_STATUS = "FAIL";
					detailResult.add(new TestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace(
							(tc.toString())).split("\\.")[0], FINAL_STATUS, CH_STATUS, FF_STATUS, IE_STATUS));
				} else if ((CH_STATUS == "SKIP") | (FF_STATUS == "SKIP") | (IE_STATUS == "SKIP")) {
					FINAL_STATUS = "SKIP";
					detailResult.add(new TestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace(
							(tc.toString())).split("\\.")[0], FINAL_STATUS, CH_STATUS, FF_STATUS, IE_STATUS));
				} else {
					FINAL_STATUS = "NOT_TESTED";
					detailResult.add(new TestcaseDetailObject(suite.getName(), StringUtils.deleteWhitespace((tc.toString())).split("\\.")[1], StringUtils.deleteWhitespace(
							(tc.toString())).split("\\.")[0], FINAL_STATUS, CH_STATUS, FF_STATUS, IE_STATUS));
				}
			}
			System.out.println("all methods------closed");
			testCaseResultMap.put("num_of_testcases", allMethods.size());
			testCaseResultMap.put("passed", chromePassedArray.size() + firefoxPassedArray.size() + iePassedArray.size());
			testCaseResultMap.put("failed", chromeFailedArray.size() + firefoxFailedArray.size() + ieFailedArray.size());
			testCaseResultMap.put("skipped", chromeSkippedArray.size() + firefoxSkippedArray.size() + ieSkippedArray.size());

			if (testCaseResultMap.get("failed") == 0 && testCaseResultMap.get("skipped") == 0) {
				testSuiteResultMap.put(suite.getName(), "PASS");
			} else {
				testSuiteResultMap.put(suite.getName(), "FAIL");
			}
			try {
				uploadToTestsuiteTable(ConfiguratorSupport.getProperty("reportMasterTable","project.properties"), BaseTest.jiraTicket, BaseTest.userName, suite.getName(), testSuiteResultMap.get(suite.getName()),
						testCaseResultMap.get("num_of_testcases"), testCaseResultMap.get("passed"), testCaseResultMap.get("failed"), testCaseResultMap.get("skipped"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.err.println("while uploading to suite table");
			} finally {
				Reporter.log("uploading to" + ConfiguratorSupport.getProperty("reportMasterTable","project.properties") + "........." + "over");
			}
			try {
				if (detailResult.size() == 0) {
					System.out.println("Detail_Result_List Null");
					throw new EmptyStackException();
				} else {
					for (TestcaseDetailObject result : detailResult) {
						try {
							uploadToTestcaseTable(ConfiguratorSupport.getProperty("reportDetailTable","project.properties"), getSuiteRunId(ConfiguratorSupport.getProperty("reportMasterTable","project.properties")), result.getScenario(),
									result.getTestcasename(), result.getStatus(), result.getChromeResult(), result.getFirefoxResult(), result.getInternetexplorerResult());
							System.out.println("Trying to insert Record:" + ConfiguratorSupport.getProperty("reportDetailTable","project.properties"));
							Reporter.log("one row inserted to::" + ConfiguratorSupport.getProperty("reportDetailTable","project.properties"));
						} catch (Exception e) {
							e.getMessage();
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Reporter.log("uploading to" + ConfiguratorSupport.getProperty("reportDetailTable","project.properties") + "........." + "over");
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

	public void uploadToTestcaseTable(String tablename, Integer test_run_id, String scenario, String testcase, String finalResult, String chromeResult, String firefoxResult,
			String ieResult) {
		try {
			String query = "INSERT INTO " + tablename + "(`test_run_id`, `scenario`, `testcase`, `result`, `chrome`, `firefox`, `ie`) " + " VALUES (?,?,?,?,?,?,?)";
			conn = setMysqlDBConnection(ConfiguratorSupport.getProperty("dbUser","project.properties"), ConfiguratorSupport.getProperty("dbPassword","project.properties"), ConfiguratorSupport.getProperty("db","project.properties"));
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, test_run_id);
			preparedStmt.setString(2, scenario);
			preparedStmt.setString(3, testcase);
			preparedStmt.setString(4, finalResult);
			preparedStmt.setString(5, chromeResult);
			preparedStmt.setString(6, firefoxResult);
			preparedStmt.setString(7, ieResult);
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! @uploadToTestcaseTable()");
			System.err.println(e.getMessage());
		}
	}

	public Integer getSuiteRunId(String tablename) {
		int id = 0;
		try {
			conn = setMysqlDBConnection(ConfiguratorSupport.getProperty("dbUser","project.properties"), ConfiguratorSupport.getProperty("dbPassword","project.properties"), ConfiguratorSupport.getProperty("db","project.properties"));
			PreparedStatement preparedStmt = conn.prepareStatement("SELECT run_id FROM "+ ConfiguratorSupport.getProperty("reportMasterTable","project.properties") +" ORDER BY run_id DESC LIMIT 1");
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("run_id");
			}
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			print("Looking for Run id from table: " + tablename);
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return id;

	}

	public void uploadToTestsuiteTable(String tablename, String ticket, String user, String suite, String result, Integer num_of_testcases, Integer passed, Integer failed,
			Integer skipped) {
		try {

			Timestamp tcExecutionTime = new java.sql.Timestamp(new java.util.Date().getTime());
			String query = "INSERT INTO " + tablename + "( `ticket`, `user`, `datetime`, `suite`, `result`, `num_of_testcases`, `passed`, `failed`, `skipped`) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			conn = setMysqlDBConnection(ConfiguratorSupport.getProperty("dbUser","project.properties"), ConfiguratorSupport.getProperty("dbPassword","project.properties"), ConfiguratorSupport.getProperty("db","project.properties"));
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, ticket);
			preparedStmt.setString(2, user);
			preparedStmt.setTimestamp(3, tcExecutionTime);
			preparedStmt.setString(4, suite);
			preparedStmt.setString(5, result);
			preparedStmt.setInt(6, num_of_testcases);
			preparedStmt.setInt(7, passed);
			preparedStmt.setInt(8, failed);
			preparedStmt.setInt(9, skipped);
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			Reporter.log("Test Results uploading to:: " + tablename);
		} catch (Exception e) {
			System.err.println("uploadToTestsuiteTable() - Got an exception!");
			System.err.println(e.getMessage());
		}

	}
}
