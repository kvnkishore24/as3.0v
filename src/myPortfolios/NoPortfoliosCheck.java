package myPortfolios;

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
public class NoPortfoliosCheck extends ReusableMethods {

	Logger log = Logger.getLogger(NoPortfoliosCheck.class.getName());
	WebElement AddPortfolio_Btn;
	WebElement CreatePortfolio_Btn;
	WebElement No_Portfolios_Status;
	WebElement Add_Portfolio_Form;
	WebElement Add_PortfolioForm_PortfolioName_TBox;
	WebElement Add_PortfolioForm_Ticker_TBox;
	WebElement Add_PortfolioForm_purchaseDate_TBox;
	WebElement Add_PortfolioForm_Quantity_TBox;
	WebElement Add_PortfolioForm_PurchasePrice_TBox;
	WebElement Add_PortfolioForm_Save_Btn;
	WebElement Add_PortfolioForm_CancelBtn;

	@Test(priority = 0, groups = "Is_portfoliopage", dependsOnGroups = "Is_homepage", description = "Verify login form elements displying or not.")
	public void myPortfolio_PageConformation_Check() {

		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			WebElement myportfolios_Lnk = getElementWithFluentWait(Obj.getIdentify("myportfolios_Lnk"), Obj.getLocation("myportfolios_Lnk"), "myportfolios_Lnk");
			Assert.assertFalse(!checkElementIsDisplayed(myportfolios_Lnk, "myportfolios_Lnk"), "\"myportfolios_Lnk\" not presented in \"Homepage_Left_Bar\"");
			click(myportfolios_Lnk, "myportfolios_Lnk");
			AddPortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("AddPortfolio_Btn"), Obj.getLocation("AddPortfolio_Btn"), "AddPortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn"), "\"AddPortfolio_Btn\" not presented in \"Homepage_Left_Bar\"");
			CreatePortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("CreatePortfolio_Btn"), Obj.getLocation("CreatePortfolio_Btn"), "CreatePortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn"), "\"CreatePortfolio_Btn\" not presented in \"CreatePortfolio_Btn\"");
			if (checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn")) {
				if (checkElementIsEnabled(AddPortfolio_Btn, "AddPortfolio_Btn")) {
					log.info("In Portfolio_Page,\"AddPortfolio_Btn\" are displyed successfully");
					log.info("From Home_Page,\"myportfolios_Lnk\" Navigated to Portfolos page successfully");
				}
			}
			else if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
				WebElement No_portfolio_Msg = getElementWithFluentWait(Obj.getIdentify("No_portfolio_Msg"), Obj.getLocation("No_portfolio_Msg"), "No_portfolio_Msg");
				log.info(No_portfolio_Msg.getText());
				Assert.assertEquals(No_portfolio_Msg.getText(), "You have no portfolios.");
				if (checkElementIsEnabled(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
					log.info("In Portfolio_Page, \"CreatePortfolio_Btn\" are displyed successfully");
					log.info("From Home_Page,\"myportfolios_Lnk\" Navigated to Portfolos page successfully");
				}
			}
			else {
				Assert.assertTrue(false, "Portfolio link navigates to unexpected page or exptected elements are not preseted in portfolios page");
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	@Test(priority = 1, dependsOnMethods = "myPortfolio_PageConformation_Check", dependsOnGroups = "Is_portfoliopage", description = "Verify login form elements displying or not.")
	public void noPortfolios_StatusPresence_Check() {

		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());

		try {
			CreatePortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("CreatePortfolio_Btn"), Obj.getLocation("CreatePortfolio_Btn"), "CreatePortfolio_Btn");
			No_Portfolios_Status = getElementWithFluentWait(Obj.getIdentify("No_portfolio_Msg"), Obj.getIdentify("No_portfolio_Msg"), "No_portfolio_Msg");
			Assert.assertFalse(!checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn"), "\"CreatePortfolio_Btn\" not presented in \"CreatePortfolio_Btn\"");

			if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn") == false && checkElementIsDisplayed(No_Portfolios_Status, "No_Portfolios_Status") == false) {
				Assert.assertTrue(false, "\"CreatePortfolio_Btn\" and \"No_Portfolios_Status\" are not displyed..");
			}
			else if (checkElementIsDisplayed(No_Portfolios_Status, "No_Portfolios_Status") == false) {
				Assert.assertTrue(false, "\"No_Portfolios_Status\" not displyed..");
			}
			else if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn") == false) {
				Assert.assertTrue(false, "\"CreatePortfolio_Btn\" not displyed..");
			}
			if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn") == true && checkElementIsDisplayed(No_Portfolios_Status, "No_Portfolios_Status") == true) {
				Assert.assertTrue(true, "\"CreatePortfolio_Btn\" and \"No_Portfolios_Status\" are sucessfully displayed.");
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

}
