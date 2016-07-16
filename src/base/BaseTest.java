package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.ConfiguratorSupport;

/**
 * @author kishorekalapala
 * @project alphastreet Oct 14, 2015
 */
public class BaseTest {

	public static WebDriver driver;
	public static ConfiguratorSupport config = new ConfiguratorSupport();
	public static String jiraTicket = null;
	public static String userName = null;
	public static String testPropertiesFilePath = "config-files/test.properties";
	public static String ProjectPropertiesFilePath = "config-files/project.properties";
	Logger log = Logger.getLogger(BaseTest.class.getName());

	@Parameters("browser")
	@BeforeTest
	public void initialize(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.firefox.profile", "test");
			long BrowserStartTime = System.currentTimeMillis();
			driver = new FirefoxDriver();
			long BrowserLoadEndtime = System.currentTimeMillis();
			driver.manage().window().maximize();
			log.info(browser + " Browser Launch Time- " + (BrowserLoadEndtime - BrowserStartTime) / 1000 + " seconds");
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			ChromeOptions chromeOpitons = new ChromeOptions();
			chromeOpitons.addArguments("start-maximized");
			long BrowserStartTime = System.currentTimeMillis() / 1000;
			driver = new ChromeDriver(chromeOpitons);
			long BrowserLoadEndtime = System.currentTimeMillis() / 1000;
			log.info(browser + " Browser Launch Time- " + (BrowserLoadEndtime - BrowserStartTime) + " seconds");
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability("ignoreZoomSetting", true);
			long BrowserStartTime = System.currentTimeMillis();
			driver = new InternetExplorerDriver(caps);
			long BrowserLoadEndtime = System.currentTimeMillis();
			driver.manage().window().maximize();
			log.info(browser + " Browser Launch Time- " + (BrowserLoadEndtime - BrowserStartTime) / 1000 + " seconds");
		}
		else {
			System.err.println("ERROR:-Not valid Brower and please check an correct in testNG suite file");
			log.error("ERROR:-Not valid Brower and please check an correct in testNG suite file");
			throw new Exception("Browser Name not valid..(Info:Please check inf Suite_file)");
		}
		// File Existence Check
		ConfiguratorSupport.checkfileExistence(testPropertiesFilePath);
	}

	@Parameters({ "jiraTICKET", "jiraUSER" })
	@AfterTest(description = "Driver will close and Through Jenkins or Ant Passing jiraTICKET &jiraUSER for Reporting purpose")
	public void stopDriver(String ticketNumber, String user) {
		try {
			jiraTicket = ticketNumber;
			userName = user;
			System.out.println("Jira_Ticket_Number:\t" + jiraTicket + "\n" + "Script_Execute_By:\t" + userName);
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e1) {
			}
//			driver.close();
//			log.info("Browser Closed..!");
		}
		catch (Exception e) {
			log.error("@stopDriver " + e.getMessage());
		}

	}
}