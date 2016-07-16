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
 * @project alphastreet-testing Dec 3, 2015
 */
public class HomepageTopBar_DefaultElements extends ReusableMethods {
	Logger log = Logger.getLogger(HomepageTopBar_DefaultElements.class.getName());

	@Test(groups = { "HomepageTopBar" }, dependsOnGroups = "Is_homepage",  description = "Verify searchForStocks TextBox dispaly_check.")
	public void searchForStocksTextBox_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement search_TBox = getElementWithFluentWait(Obj.getIdentify("search_TBox"), Obj.getLocation("search_TBox"), "search_TBox");
			Assert.assertFalse(!checkElementIsDisplayed(search_TBox, "search_TBox"), "\"search_TBox\" not presented in \"Homepage_Top_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	@Test(groups = { "HomepageTopBar" }, dependsOnGroups = "Is_homepage",  description = "Verify explore_link_dispaly_check.")
	public void  userProfileDD_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement user_profile_DD = getElement(Obj.getIdentify("user_profile_DD"), Obj.getLocation("user_profile_DD"), "user_profile_DD");
			Assert.assertFalse(!checkElementIsDisplayed(user_profile_DD, "user_profile_DD"), "\"user_profile_DD\" not presented in \"Homepage_Top_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
	}

	@Test(groups = { "HomepageTopBar" }, dependsOnGroups = "Is_homepage",  description = "userNotificationsButton_dispaly_check")
	public void userNotificationsButton_dispaly_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement user_notifications_DD = getElementWithFluentWait(Obj.getIdentify("user_notifications_DD"), Obj.getLocation("user_notifications_DD"), "user_notifications_DD");
			Assert.assertFalse(!checkElementIsDisplayed(user_notifications_DD, "user_notifications_DD"), "\"user_notifications_DD\" not presented in \"Homepage_Top_Bar\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false,e.getMessage()+"@userNotificationsButton_dispaly_check"); 
		}
	}
}
