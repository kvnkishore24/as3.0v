package myPortfolios;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Obj;
import utils.ReusableMethods;

/**
 * @author kishorekalapala
 * @project alphastreet-testing Dec 3, 2015
 */
public class UpdatePortfolio extends ReusableMethods {
	Logger log = Logger.getLogger(UpdatePortfolio.class.getName());
	WebElement AddPortfolio_Btn;
	WebElement CreatePortfolio_Btn;
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
	public void addPortfolioForm_Display_Check() {

		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			AddPortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("AddPortfolio_Btn"), Obj.getLocation("AddPortfolio_Btn"), "AddPortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn"), "\"AddPortfolio_Btn\" not presented in \"Homepage_Left_Bar\"");
			CreatePortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("CreatePortfolio_Btn"), Obj.getLocation("CreatePortfolio_Btn"), "CreatePortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn"), "\"CreatePortfolio_Btn\" not presented in \"CreatePortfolio_Btn\"");
			if (checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn")) {
				if (checkElementIsEnabled(AddPortfolio_Btn, "AddPortfolio_Btn")) {
					click(AddPortfolio_Btn);

					Add_Portfolio_Form = getElementWithFluentWait(Obj.getIdentify("Add_Portfolio_Form"), Obj.getLocation("Add_Portfolio_Form"), "Add_Portfolio_Form");
					Assert.assertFalse(!checkElementIsDisplayed(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");
					log.info("In Add_Portfolio_Form,Expected all elements are displyed successfully");
				}
			}
			else if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
				if (checkElementIsEnabled(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
					click(CreatePortfolio_Btn);

					Add_Portfolio_Form = getElementWithFluentWait(Obj.getIdentify("Add_Portfolio_Form"), Obj.getLocation("Add_Portfolio_Form"), "Add_Portfolio_Form");
					Assert.assertFalse(!checkElementIsDisplayed(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");

					log.info("In Add_Portfolio_Form,Expected all elements are displyed successfully");
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

	@Test(priority = 2, dependsOnMethods = "addPortfolioForm_Display_Check", dependsOnGroups = "Is_portfoliopage", description = "Verify login form elements displying or not.")
	public void addPortfolioFormElemenents_Display_Check() {

		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			AddPortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("AddPortfolio_Btn"), Obj.getLocation("AddPortfolio_Btn"), "AddPortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn"), "\"AddPortfolio_Btn\" not presented in \"Homepage_Left_Bar\"");
			CreatePortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("CreatePortfolio_Btn"), Obj.getLocation("CreatePortfolio_Btn"), "CreatePortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn"), "\"CreatePortfolio_Btn\" not presented in \"CreatePortfolio_Btn\"");
			if (checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn")) {
				if (checkElementIsEnabled(AddPortfolio_Btn, "AddPortfolio_Btn")) {
					click(AddPortfolio_Btn);

					Add_Portfolio_Form = getElementWithFluentWait(Obj.getIdentify("Add_Portfolio_Form"), Obj.getLocation("Add_Portfolio_Form"), "Add_Portfolio_Form");
					Assert.assertFalse(!checkElementIsDisplayed(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");

					Add_PortfolioForm_PortfolioName_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_PortfolioName_TBox"), Obj.getLocation("Add_PortfolioForm_PortfolioName_TBox"), "Add_PortfolioForm_PortfolioName_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_PortfolioName_TBox, "Add_PortfolioForm_PortfolioName_TBox"), "\"Add_PortfolioForm_PortfolioName_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_PortfolioName_TBox, "Add_PortfolioForm_PortfolioName_TBox"), "\"Add_PortfolioForm_PortfolioName_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_Ticker_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_Ticker_TBox"), Obj.getLocation("Add_PortfolioForm_Ticker_TBox"), "Add_PortfolioForm_Ticker_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_Ticker_TBox, "Add_PortfolioForm_Ticker_TBox"), "\"Add_PortfolioForm_Ticker_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_Ticker_TBox, "Add_PortfolioForm_Ticker_TBox"), "\"Add_PortfolioForm_Ticker_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_purchaseDate_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_purchaseDate_TBox"), Obj.getLocation("Add_PortfolioForm_purchaseDate_TBox"), "Add_PortfolioForm_purchaseDate_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_purchaseDate_TBox, "Add_PortfolioForm_purchaseDate_TBox"), "\"Add_PortfolioForm_purchaseDate_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_purchaseDate_TBox, "Add_PortfolioForm_purchaseDate_TBox"), "\"Add_PortfolioForm_purchaseDate_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_Quantity_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_Quantity_TBox"), Obj.getLocation("Add_PortfolioForm_Quantity_TBox"), "Add_PortfolioForm_Quantity_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_Quantity_TBox, "Add_PortfolioForm_Quantity_TBox"), "\"Add_PortfolioForm_Quantity_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_Quantity_TBox, "Add_PortfolioForm_Quantity_TBox"), "\"Add_PortfolioForm_Quantity_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_PurchasePrice_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_PurchasePrice_TBox"), Obj.getLocation("Add_PortfolioForm_PurchasePrice_TBox"), "Add_PortfolioForm_PurchasePrice_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_PurchasePrice_TBox, "Add_PortfolioForm_PurchasePrice_TBox"), "\"Add_PortfolioForm_PurchasePrice_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_PurchasePrice_TBox, "Add_PortfolioForm_PurchasePrice_TBox"), "\"Add_PortfolioForm_PurchasePrice_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_Save_Btn = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_Save_Btn"), Obj.getLocation("Add_PortfolioForm_Save_Btn"), "Add_PortfolioForm_Save_Btn");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn"), "\"Add_PortfolioForm_Save_Btn\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn"), "\"Add_PortfolioForm_Save_Btn\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_CancelBtn = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_CancelBtn"), Obj.getLocation("Add_PortfolioForm_CancelBtn"), "Add_PortfolioForm_CancelBtn");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_CancelBtn, "Add_PortfolioForm_CancelBtn"), "\"Add_PortfolioForm_CancelBtn\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_CancelBtn, "Add_PortfolioForm_CancelBtn"), "\"Add_PortfolioForm_CancelBtn\" not presented in \"In_Add_Portfolio_Form\"");
					click(Add_PortfolioForm_CancelBtn, "Cancel Button");
					log.info("In Add_Portfolio_Form,Expected all elements are displyed successfully");
				}
			}
			else if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
				if (checkElementIsEnabled(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
					click(CreatePortfolio_Btn);

					Add_Portfolio_Form = getElementWithFluentWait(Obj.getIdentify("Add_Portfolio_Form"), Obj.getLocation("Add_Portfolio_Form"), "Add_Portfolio_Form");
					Assert.assertFalse(!checkElementIsDisplayed(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_Portfolio_Form, "Add_Portfolio_Form"), "\"Add_Portfolio_Form\" not presented in \"Portfolio_view_Point\"");

					Add_PortfolioForm_PortfolioName_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_PortfolioName_TBox"), Obj.getLocation("Add_PortfolioForm_PortfolioName_TBox"), "Add_PortfolioForm_PortfolioName_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_PortfolioName_TBox, "Add_PortfolioForm_PortfolioName_TBox"), "\"Add_PortfolioForm_PortfolioName_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_PortfolioName_TBox, "Add_PortfolioForm_PortfolioName_TBox"), "\"Add_PortfolioForm_PortfolioName_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_Ticker_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_Ticker_TBox"), Obj.getLocation("Add_PortfolioForm_Ticker_TBox"), "Add_PortfolioForm_Ticker_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_Ticker_TBox, "Add_PortfolioForm_Ticker_TBox"), "\"Add_PortfolioForm_Ticker_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_Ticker_TBox, "Add_PortfolioForm_Ticker_TBox"), "\"Add_PortfolioForm_Ticker_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_purchaseDate_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_purchaseDate_TBox"), Obj.getLocation("Add_PortfolioForm_purchaseDate_TBox"), "Add_PortfolioForm_purchaseDate_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_purchaseDate_TBox, "Add_PortfolioForm_purchaseDate_TBox"), "\"Add_PortfolioForm_purchaseDate_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_purchaseDate_TBox, "Add_PortfolioForm_purchaseDate_TBox"), "\"Add_PortfolioForm_purchaseDate_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_Quantity_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_Quantity_TBox"), Obj.getLocation("Add_PortfolioForm_Quantity_TBox"), "Add_PortfolioForm_Quantity_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_Quantity_TBox, "Add_PortfolioForm_Quantity_TBox"), "\"Add_PortfolioForm_Quantity_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_Quantity_TBox, "Add_PortfolioForm_Quantity_TBox"), "\"Add_PortfolioForm_Quantity_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_PurchasePrice_TBox = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_PurchasePrice_TBox"), Obj.getLocation("Add_PortfolioForm_PurchasePrice_TBox"), "Add_PortfolioForm_PurchasePrice_TBox");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_PurchasePrice_TBox, "Add_PortfolioForm_PurchasePrice_TBox"), "\"Add_PortfolioForm_PurchasePrice_TBox\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_PurchasePrice_TBox, "Add_PortfolioForm_PurchasePrice_TBox"), "\"Add_PortfolioForm_PurchasePrice_TBox\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_Save_Btn = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_Save_Btn"), Obj.getLocation("Add_PortfolioForm_Save_Btn"), "Add_PortfolioForm_Save_Btn");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn"), "\"Add_PortfolioForm_Save_Btn\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn"), "\"Add_PortfolioForm_Save_Btn\" not presented in \"In_Add_Portfolio_Form\"");

					Add_PortfolioForm_CancelBtn = getElementWithFluentWait(Obj.getIdentify("Add_PortfolioForm_CancelBtn"), Obj.getLocation("Add_PortfolioForm_CancelBtn"), "Add_PortfolioForm_CancelBtn");
					Assert.assertFalse(!checkElementIsDisplayed(Add_PortfolioForm_CancelBtn, "Add_PortfolioForm_CancelBtn"), "\"Add_PortfolioForm_CancelBtn\" not presented in \"In_Add_Portfolio_Form\"");
					Assert.assertFalse(!checkElementIsEnabled(Add_PortfolioForm_CancelBtn, "Add_PortfolioForm_CancelBtn"), "\"Add_PortfolioForm_CancelBtn\" not presented in \"In_Add_Portfolio_Form\"");
					click(Add_PortfolioForm_CancelBtn, "Cancel Button");
					log.info("In Add_Portfolio_Form,Expected all elements are displyed successfully");
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

	@Test(priority = 3, dependsOnMethods = "addPortfolioFormElemenents_Display_Check", dependsOnGroups = "Is_portfoliopage", description = "Verify login form elements displying or not.")
	public void addPortfolio_functionality_Check() {

		log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getMethodName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("TESTCASE::______________" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			AddPortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("AddPortfolio_Btn"), Obj.getLocation("AddPortfolio_Btn"), "AddPortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn"), "\"AddPortfolio_Btn\" not presented in \"Homepage_Left_Bar\"");
			CreatePortfolio_Btn = getElementWithFluentWait(Obj.getIdentify("CreatePortfolio_Btn"), Obj.getLocation("CreatePortfolio_Btn"), "CreatePortfolio_Btn");
			Assert.assertFalse(!checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn"), "\"CreatePortfolio_Btn\" not presented in \"CreatePortfolio_Btn\"");
			if (checkElementIsDisplayed(AddPortfolio_Btn, "AddPortfolio_Btn")) {
				if (checkElementIsEnabled(AddPortfolio_Btn, "AddPortfolio_Btn")) {
					click(AddPortfolio_Btn);
					addText(Add_PortfolioForm_PortfolioName_TBox, "Test01");
					Thread.sleep(2000);
					try {
						try {
							WebElement Add_PortfolioForm_Ticker_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/input[3]"));
							addText(Add_PortfolioForm_Ticker_TBox, "GOOG");

							List<WebElement> searchList = driver.findElements(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/ul"));
							for (WebElement webElement : searchList) {
								System.out.println(webElement.getText());
							}
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_Ticker_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/input[3]"));
							addText(Add_PortfolioForm_Ticker_TBox, "GOOG", "Add_PortfolioForm_Ticker_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_Ticker_TBox", new Throwable(e.getMessage()));
					}

					try {
						try {
							WebElement Add_PortfolioForm_purchaseDate_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_purchaseDate_TBox, "2015-12-01 ");
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_purchaseDate_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_purchaseDate_TBox, "2015-12-01 ", "Add_PortfolioForm_purchaseDate_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_purchaseDate_TBox", new Throwable(e.getMessage()));
					}

					// addText(Add_PortfolioForm_purchaseDate_TBox,
					// "2015-12-01");
					try {
						try {
							WebElement Add_PortfolioForm_Quantity_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_Quantity_TBox, "2");
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_Quantity_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_Quantity_TBox, "2015-12-01 ", "Add_PortfolioForm_Quantity_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_Quantity_TBox", new Throwable(e.getMessage()));
					}

					try {
						try {
							WebElement Add_PortfolioForm_PurchasePrice_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_PurchasePrice_TBox, "22.00");
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_PurchasePrice_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_PurchasePrice_TBox, "2015-12-01 ", "Add_PortfolioForm_PurchasePrice_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_Quantity_TBox", new Throwable(e.getMessage()));
					}
					// addText(Add_PortfolioForm_Quantity_TBox, "2");
					// log.info(Add_PortfolioForm_PurchasePrice_TBox.getText());
					// addText(Add_PortfolioForm_PurchasePrice_TBox, "22.00");
					click(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn");
				}
			}
			else if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
				if (checkElementIsEnabled(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
					click(CreatePortfolio_Btn);
					/*
					 * addText(Add_PortfolioForm_PortfolioName_TBox, "Test01");
					 * addText(Add_PortfolioForm_Ticker_TBox, "goog");
					 * addText(Add_PortfolioForm_purchaseDate_TBox,
					 * "2015-12-01"); addText(Add_PortfolioForm_Quantity_TBox,
					 * "2");
					 * log.info(Add_PortfolioForm_PurchasePrice_TBox.getText());
					 * addText(Add_PortfolioForm_PurchasePrice_TBox, "22.00");
					 * click(Add_PortfolioForm_Save_Btn,
					 * "Add_PortfolioForm_Save_Btn");
					 */

					try {
						try {
							WebElement Add_PortfolioForm_Ticker_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/input[3]"));
							addText(Add_PortfolioForm_Ticker_TBox, "GOOG");

						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Ticker = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/input[3]"));
							addText(Ticker, "GOOG", "Add_PortfolioForm_Ticker_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_Ticker_TBox", new Throwable(e.getMessage()));
					}

					try {
						try {
							WebElement Add_PortfolioForm_purchaseDate_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_purchaseDate_TBox, "2015-12-01 ");
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_purchaseDate_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_purchaseDate_TBox, "2015-12-01 ", "Add_PortfolioForm_purchaseDate_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_purchaseDate_TBox", new Throwable(e.getMessage()));
					}
					/*
					 * List<WebElement> searchList =
					 * driver.findElements(By.xpath
					 * ("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/ul"
					 * )); searchList.
					 */

					// addText(Add_PortfolioForm_purchaseDate_TBox,
					// "2015-12-01");
					try {
						try {
							WebElement Add_PortfolioForm_Quantity_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_Quantity_TBox, "2");
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_Quantity_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_Quantity_TBox, "2015-12-01 ", "Add_PortfolioForm_Quantity_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_Quantity_TBox", new Throwable(e.getMessage()));
					}

					try {
						try {
							WebElement Add_PortfolioForm_PurchasePrice_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_PurchasePrice_TBox, "22.00");
						}
						catch (org.openqa.selenium.StaleElementReferenceException ex) {
							log.error("Exception in finding date");
							log.error(ex);
							WebElement Add_PortfolioForm_PurchasePrice_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
							addText(Add_PortfolioForm_PurchasePrice_TBox, "2015-12-01 ", "Add_PortfolioForm_PurchasePrice_TBox");
						}
					}
					catch (Exception e) {
						log.error("Unable to add to Add_PortfolioForm_Quantity_TBox", new Throwable(e.getMessage()));
					}
					try {
						click(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn");
					}
					catch (Exception ex) {
						log.error("@Add_PortfolioForm_Save_Btn", ex);
					}
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

}
