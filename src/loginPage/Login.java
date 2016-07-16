package loginPage;

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
public class Login extends ReusableMethods {
	Logger log = Logger.getLogger(Login.class.getName());

	@Test(priority = 0,groups = { "LOGIN" }, dependsOnGroups = {"BETA_LOGIN"},  description = "Verify login form elements displying or not.")
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

	@Test(groups = { "ValidLoginTo_homepage" }, dependsOnGroups = {"BETA_LOGIN"},dependsOnMethods = "loginFormElementsPresence_check", description = "Testing login Functionality.")
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
