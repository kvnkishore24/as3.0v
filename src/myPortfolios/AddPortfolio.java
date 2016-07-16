package myPortfolios;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Obj;
import utils.ReusableMethods;

/**
 * @author kishorekalapala
 * @project alphastreet-testing Dec 3, 2015
 */
public class AddPortfolio extends ReusableMethods {
	Logger log = Logger.getLogger(AddPortfolio.class.getName());
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
	public void addPortfolioForm_Presence_Check() {

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

	@Test(priority = 2, dependsOnMethods = "addPortfolioForm_Presence_Check", dependsOnGroups = "Is_portfoliopage", description = "Verify login form elements displying or not.")
	public void addPortfolioFormElements_Presence_Check() {

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

	@Test(priority = 3, dependsOnMethods = "addPortfolioFormElements_Presence_Check", dependsOnGroups = "Is_portfoliopage", description = "Verify login form elements displying or not.")
	public void createPortfolio() {
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
					addText(Add_PortfolioForm_PortfolioName_TBox, "Aut_Test_" + getRandomString(3));
					Thread.sleep(2000);
					String portfolioData = config.getProperty("Portfolio_Add_" + getRandomValueOf(1, 5));
					List<String> portfoliosList = Arrays.asList(portfolioData.split(","));
					try {

						Add_PortfolioForm_Ticker_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/input[3]"));
						addText(Add_PortfolioForm_Ticker_TBox, portfoliosList.get(0));
						log.info(portfoliosList.get(0) + "-added to PortfolioForm_Ticker_TBox");
						driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
						WebElement elementOne = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/ul/li[1]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", elementOne);
						log.info("Element selected From Drop down");
					}
					catch (org.openqa.selenium.StaleElementReferenceException ex) {
						log.error("StaleElementReferenceException-Exception in Ticker Search Table", ex);
					}
					Add_PortfolioForm_purchaseDate_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
					Add_PortfolioForm_purchaseDate_TBox.sendKeys(Keys.BACK_SPACE, portfoliosList.get(1), Keys.BACK_SPACE, portfoliosList.get(2), Keys.TAB, Keys.BACK_SPACE, portfoliosList.get(3));
					log.info("\"" + portfoliosList.get(1) + "-" + portfoliosList.get(2) + "-" + portfoliosList.get(3) + "\"-added to Add_PortfolioForm_purchaseDate_TBox");
					Add_PortfolioForm_Quantity_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[3]/input"));
					Add_PortfolioForm_Quantity_TBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(portfoliosList.get(4)));
					log.info("\"" + portfoliosList.get(4) + "\"-added to Add_PortfolioForm_Quantity_TBox");
					Add_PortfolioForm_PurchasePrice_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[4]/input"));
					Add_PortfolioForm_PurchasePrice_TBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(portfoliosList.get(5)));
					log.info("\"" + portfoliosList.get(5) + "\"-added to Add_PortfolioForm_PurchasePrice_TBox");
					Thread.sleep(2000);
					click(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn");
				}
				else if (checkElementIsDisplayed(CreatePortfolio_Btn, "CreatePortfolio_Btn")) {
					click(CreatePortfolio_Btn);
					log.info("No portfolios avialable,Clicked on Proftfolios button");
					addText(Add_PortfolioForm_PortfolioName_TBox, "Aut_Test_" + getRandomString(3));
					Thread.sleep(2000);
					String portfolioData = config.getProperty("Portfolio_Add_" + getRandomValueOf(1, 5));
					List<String> portfoliosList = Arrays.asList(portfolioData.split(","));
					try {
						Add_PortfolioForm_Ticker_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/input[3]"));
						addText(Add_PortfolioForm_Ticker_TBox, portfoliosList.get(0));
						log.info(portfoliosList.get(0) + "-added to PortfolioForm_Ticker_TBox");
						driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
						WebElement elementOne = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td/ul/li[1]"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", elementOne);
						log.info("Element selected From Drop down");
					}
					catch (org.openqa.selenium.StaleElementReferenceException ex) {
						log.error("StaleElementReferenceException-Exception in Ticker Search Table", ex);
					}
					Add_PortfolioForm_purchaseDate_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[2]/input"));
					Add_PortfolioForm_purchaseDate_TBox.sendKeys(Keys.BACK_SPACE, portfoliosList.get(1), Keys.BACK_SPACE, portfoliosList.get(2), Keys.TAB, Keys.BACK_SPACE, portfoliosList.get(3));
					log.info("\"" + portfoliosList.get(1) + "-" + portfoliosList.get(2) + "-" + portfoliosList.get(3) + "\"-added to Add_PortfolioForm_purchaseDate_TBox");
					Add_PortfolioForm_Quantity_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[3]/input"));
					Add_PortfolioForm_Quantity_TBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(portfoliosList.get(4)));
					log.info("\"" + portfoliosList.get(4) + "\"-added to Add_PortfolioForm_Quantity_TBox");
					Add_PortfolioForm_PurchasePrice_TBox = driver.findElement(By.xpath("//form[@id='portfolioUpdateForm']/table/tbody/tr[2]/td[4]/input"));
					Add_PortfolioForm_PurchasePrice_TBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), String.valueOf(portfoliosList.get(5)));
					log.info("\"" + portfoliosList.get(5) + "\"-added to Add_PortfolioForm_PurchasePrice_TBox");
					Thread.sleep(2000);
					click(Add_PortfolioForm_Save_Btn, "Add_PortfolioForm_Save_Btn");
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		log.info("---------------TESTCASE COMPLETED----------------");
	}

	public String getAlphastreetFormXpathRow(String formID, String rowNumber, String colNumber) {
		String row = "//form[@id='" + formID + "']/table/tbody/tr[" + rowNumber + "]/td[" + colNumber + "]/input[3]";
		return row;
	}
}
