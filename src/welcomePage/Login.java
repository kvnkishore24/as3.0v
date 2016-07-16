package welcomePage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Obj;
import utils.ReusableMethods;

public class Login extends ReusableMethods {
	Logger log = Logger.getLogger(Login.class.getName());

	@Test(groups={"Login_popup"},dependsOnGroups={"Alphastreet_Welcome_PAGE"},priority = 1, description = "Verifiing user navigated to login page by \"Beta Login\" button")
	public void signuploginButtonFucnctinality_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::________" + Thread.currentThread().getStackTrace()[1].getMethodName());

		try {
			WebElement betalogin_Btn = getElementWithFluentWait(Obj.getIdentify("betalogin_Btn"), Obj.getLocation("betalogin_Btn"));
			Assert.assertFalse(!checkElementIsDisplayed(betalogin_Btn, "betalogin_Btn"), "\"betalogin_Btn\" not presented on Welcompage");
			log.info("\"betalogin_Btn\" in presented on Welcompage");
			click(betalogin_Btn, "betalogin_Btn");

			WebElement loginsingup_popup = getElementWithFluentWait(Obj.getIdentify("signuplogin_Popup"), Obj.getLocation("signuplogin_Popup"));
			checkElementIsDisplayed(loginsingup_popup, "signup/login Popup");
			checkElementIsEnabled(loginsingup_popup, "signup/login Popup");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}
	
	@Test(priority = 0,groups = { "Popup_LOGIN_Elements" }, dependsOnGroups = {"Login_popup"},  description = "Verify login form elements displying or not.")
	public void loginFormElementsPresence_check() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement login_email_TBox = getElementWithFluentWait(Obj.getIdentify("login_email_TBox"), Obj.getLocation("login_email_TBox"), "emailBox");
			Assert.assertFalse(!checkElementIsDisplayed(login_email_TBox, "login_email_TBox"), "\"login_email_TBox\" not presented in \"Login-Form\"");

			WebElement login_password_TBox = getElementWithFluentWait(Obj.getIdentify("login_password_TBox"), Obj.getLocation("login_password_TBox"));
			Assert.assertFalse(!checkElementIsDisplayed(login_password_TBox, "login_password_TBox"), "\"login_password_TBox\" not presented in \"Login-Form\"");

			WebElement login_Btn = getElementWithFluentWait(Obj.getIdentify("login_Btn"), Obj.getLocation("login_Btn"));
			Assert.assertFalse(!checkElementIsDisplayed(login_Btn, "login_Btn"), "\"login_Btn\" not presented in \"Login-Form\"");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
	}

	@Test(groups = { "ValidLoginTo_homepage" }, dependsOnGroups = {"Popup_LOGIN_Elements"},dependsOnMethods = "loginFormElementsPresence_check", description = "Testing login Functionality.")
	public void loginWith_ValidDetails() {
		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement login_email_TBox = getElementWithFluentWait(Obj.getIdentify("login_email_TBox"), Obj.getLocation("login_email_TBox"), "emailBox");
			login_email_TBox.clear();
			addText(login_email_TBox, config.getProperty("valid_username"), "login_email_TBox");

			WebElement login_password_TBox = getElementWithFluentWait(Obj.getIdentify("login_password_TBox"), Obj.getLocation("login_password_TBox"));
			addText(login_password_TBox, config.getProperty("valid_password"), "login_password_TBox");

			WebElement login_Btn = getElementWithFluentWait(Obj.getIdentify("login_Btn"), Obj.getLocation("login_Btn"));
			click(login_Btn, "login_Btn");
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
}
