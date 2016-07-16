package utils;

/**
 * @author kishorekalapala
 *
 * @project AutomationFramework
 * Aug 20, 2015
 */
@SuppressWarnings("serial")
public class TestcaseDetailObject implements java.io.Serializable {
	private String testSuite;
	private String testcasename;
	private String testScenario;
	private String testcaseStatus;
	private String cromeBrowserResult;
	private String firefoxBrowserResult;
	private String ieBrowserResult;
	public TestcaseDetailObject(){}

	public TestcaseDetailObject(String suite, String scenario, String testcasename, String status, String chrome_result, String firefox_result, String internetexplorer_result) {

		this.testSuite = suite;
		this.testcasename = testcasename;
		this.testScenario = scenario;
		this.testcaseStatus = status;
		this.cromeBrowserResult = chrome_result;
		this.firefoxBrowserResult = firefox_result;
		this.ieBrowserResult = internetexplorer_result;
	}

	public String getSuite() {
		return testSuite;
	}

	public String getTestcasename() {
		return testcasename;
	}

	public String getScenario() {
		return testScenario;
	}

	public String getStatus() {
		return testcaseStatus;
	}
	
	public String getChromeResult() {
		return cromeBrowserResult;
	}

	public String getFirefoxResult() {
		return firefoxBrowserResult;
	}

	public String getInternetexplorerResult() {
		return ieBrowserResult;
	}
	

}
