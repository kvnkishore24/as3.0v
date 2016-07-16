package homePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Obj;
import utils.ReusableMethods;

/**
 * @author kishorekalapala
 *
 * @project alphastreet-testing Dec 3, 2015
 */
public class HomepageConfirmation_Check extends ReusableMethods {
	Logger log = Logger.getLogger(HomepageConfirmation_Check.class.getName());

	@Test(groups = { "Is_homepage" }, dependsOnGroups = "ValidLoginTo_homepage", description = "Verify login form elements displying or not.")
	public void homepage_confirmation_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Thread.sleep(5000);
			String currentURL = driver.getCurrentUrl();
			log.info("Navigated to::[ " + currentURL + " ]");
			log.info("Actual:-" + currentURL);
			log.info("Expected:-" + config.getProperty("homePageURL"));
			Assert.assertEquals(currentURL, config.getProperty("homePageURL"));

			if (!checkElementIsDisplayed(getElement(Obj.getIdentify("user_profile_DD"), Obj.getLocation("user_profile_DD"), "user_profile_DD"))) {
				Assert.assertTrue(false);
				log.error("\"user_profile_DD\" is missing in Home-Page");
			}
			else {
				Assert.assertTrue(true, "\"betalogin_Btn\" in presented on Welcompage");
				log.info("\"user_profile_DD\" in presented on HomePage");

				log.info("homePageURL matched with expected");
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}
}
