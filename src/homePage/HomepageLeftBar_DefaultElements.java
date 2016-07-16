package homePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Obj;
import utils.ReusableMethods;

/**
 * @author kishorekalapala
 *
 * @project alphastreet-testing Dec 3, 2015
 */
public class HomepageLeftBar_DefaultElements extends ReusableMethods {
	Logger log = Logger.getLogger(HomepageLeftBar_DefaultElements.class.getName());

	@Test(priority = 1, groups = { "HomepageLeftBar" }, dependsOnGroups = "Is_homepage", description = "Verify login form elements displying or not.")
	public void myportfolios_link_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement myportfolios_Lnk = getElementWithFluentWait(Obj.getIdentify("myportfolios_Lnk"), Obj.getLocation("myportfolios_Lnk"), "myportfolios_Lnk");
			Assert.assertFalse(!checkElementIsDisplayed(myportfolios_Lnk, "myportfolios_Lnk"), "\"myportfolios_Lnk\" not presented in \"Homepage_Left_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	@Test(priority = 2, groups = { "HomepageLeftBar" }, dependsOnGroups = "Is_homepage", description = "Verify login form elements displying or not.")
	public void mywatchlists_link_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement mywatchlists_Lnk = getElementWithFluentWait(Obj.getIdentify("mywatchlists_Lnk"), Obj.getLocation("mywatchlists_Lnk"), "mywatchlists_Lnk");
			Assert.assertFalse(!checkElementIsDisplayed(mywatchlists_Lnk, "mywatchlists_Lnk"), "\"mywatchlists_Lnk\" not presented in \"Homepage_Left_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	@Test(priority = 3, groups = { "LOGIN" }, dependsOnGroups = "Is_homepage", description = "Verify login form elements displying or not.")
	public void explore_link_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement explore_Lnk = getElementWithFluentWait(Obj.getIdentify("explore_Lnk"), Obj.getLocation("explore_Lnk"), "explore_Lnk");
			Assert.assertFalse(!checkElementIsDisplayed(explore_Lnk, "explore_Lnk"), "\"explore_Lnk\" not presented in \"Homepage_Left_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	@Test(priority = 4, groups = { "HomepageLeftBar" }, dependsOnGroups = "Is_homepage", description = "Verify login form elements displying or not.")
	public void events_link_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement events_Lnk = getElementWithFluentWait(Obj.getIdentify("events_Lnk"), Obj.getLocation("events_Lnk"), "events_Lnk");
			Assert.assertFalse(!checkElementIsDisplayed(events_Lnk, "events_Lnk"), "\"events_Lnk\" not presented in \"Homepage_Left_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	@Test(priority = 5, groups = { "HomepageLeftBar" }, dependsOnGroups = "Is_homepage", description = "Verify login form elements displying or not.")
	public void connections_link_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement connections_Lnk = getElementWithFluentWait(Obj.getIdentify("connections_Lnk"), Obj.getLocation("connections_Lnk"), "connections_Lnk");
			Assert.assertFalse(!checkElementIsDisplayed(connections_Lnk, "connections_Lnk"), "\"connections_Lnk\" not presented in \"Homepage_Left_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	@Test(priority = 6,groups = { "HomepageLeftBar"}, dependsOnGroups = "Is_homepage", description = "Testing login Functionality.")
	public void indexesWithValues_Presence_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {

		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}
}
