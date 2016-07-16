package welcomePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Obj;
import utils.ReusableMethods;

public class LaunchAlhpastreetwebsite extends ReusableMethods {
	private String baseURL = config.getProperty("BaseURL");
	Logger log = Logger.getLogger(LaunchAlhpastreetwebsite.class.getName());

	@Test(groups = { "Alphastreet_Welcome_PAGE" }, description = "Verifing \"alphastreet.co\" url")
	public void opening_AlhpastreetWebsite() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::__________________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		log.info("Navigating to open::[ " + baseURL + " ]");
		try {
			driver.get(baseURL);
			log.info("Navigated to::[ " + baseURL + " ]");
			String currentURL = driver.getCurrentUrl();
			if (currentURL.equals(config.getProperty("alphastreetPageURL"))) {
				Assert.assertTrue(true);
				log.info("Actual:-" + currentURL);
				log.info("Expected:-" + config.getProperty("alphastreetPageURL"));
				log.info("alphaStreet_baseUrl matched with expected");
			}
			else if (currentURL.equals(config.getProperty("welcomePageURL"))) {
				Assert.assertTrue(true);
				log.info("Actual:-" + currentURL);
				log.info("Expected:-" + config.getProperty("welcomePageURL"));
				log.info("alphaStreet_baseUrl matched with expected");
			}
			else {
				Assert.assertTrue(false,"\""+currentURL+"\""+"Not matched with exptected URL's  i.e:"+"\n \""+config.getProperty("welcomePageURL")+"\""+"\n \""+config.getProperty("alphastreetPageURL")+"\"");
				log.error("alphaStreet_baseUrl Not matched with expected");
			}
			if (!checkElementIsDisplayed(getElementWithFluentWait(Obj.getIdentify("betalogin_Btn"), Obj.getLocation("betalogin_Btn")))) {
				Assert.assertTrue(false);
				log.error("\"betalogin_BtnIn\" is missing in Welcome-Page");
			}
			else {
				Assert.assertTrue(true, "\"betalogin_Btn\" in presented on Welcompage");
				log.info("\"betalogin_Btn\" in presented on Welcompage");
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}
}
