package utils;

@SuppressWarnings("serial")
public class WebAPITestcaseDetailObject implements java.io.Serializable {
	private String testSuite;
	private String testcasename;
	private String testScenario;
	private String testcaseStatus;

	public WebAPITestcaseDetailObject(String suite, String scenario, String testcasename, String status) {
		this.testSuite = suite;
		this.testcasename = testcasename;
		this.testScenario = scenario;
		this.testcaseStatus = status;
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

}
