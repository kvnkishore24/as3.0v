package utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.BaseTest;

import com.google.common.base.Function;

/**
 * @author kishorekalapala
 *
 * @project AutomationFramework Aug 20, 2015
 */
public class ReusableMethods extends BaseTest {

	private static Logger logger = Logger.getLogger(ReusableMethods.class);

	public static void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 0.5px groove red; ");
			try {
				Thread.sleep(200);
			}
			catch (InterruptedException e) {
			}
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	public void waitForElementPresent(String identifyby, String locator, int timeInSeconds) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				logger.info("Diver will wait for element to be visible,TimeLimit-" + timeInSeconds);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] @waitForElementPresent ");
				throw (e);
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
	}

	public boolean checkElementIsDisplayed(WebElement element) {
		boolean falg;
		try {
			element.isDisplayed();
			highlightElement(element);
			falg = true;
			logger.info("Element Displayed Successfully ");
		}
		catch (Exception e) {
			falg = false;
			logger.error(element + " Not displayed");
			Reporter.log(element + " Not displayed");
			throw (e);
		}
		return falg;
	}

	public boolean checkElementIsDisplayed(WebElement element, String logText) {
		boolean falg;
		try {
			element.isDisplayed();
			highlightElement(element);
			falg = true;
			logger.info("Displayed Successfully " + logText);
		}
		catch (Exception e) {
			falg = false;
			System.err.println(e.getMessage());
			logger.error(logText + " Not displayed ");
			Reporter.log(logText + " Not displayed ");
			throw (e);
		}
		return falg;
	}

	public boolean checkElementIsEnabled(WebElement element) {
		boolean falg;
		try {
			element.isEnabled();
			highlightElement(element);
			falg = true;
			logger.info("Element is Enabled ");
		}
		catch (Exception e) {
			falg = false;
			System.err.println(e.getMessage());
			logger.error(element + " Not Enabled ");
			Reporter.log(element + " Not Enabled ");
			throw (e);
		}
		return falg;
	}

	public boolean checkElementIsEnabled(WebElement element, String logText) {
		boolean falg;
		try {
			element.isEnabled();
			highlightElement(element);
			falg = true;
			logger.info("Enabled Successfully " + logText);
		}
		catch (Exception e) {
			falg = false;
			System.err.println(e.getMessage());
			logger.error(logText + " Not Enabled ");
			Reporter.log(logText + " Not Enabled ");
			throw (e);
		}
		return falg;
	}

	public static void addText(WebElement element, String data) throws Exception {
		try {
			highlightElement(element);
			element.sendKeys(data);
			logger.info("[" + data + "] added succesfully ");
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("While adding  [" + data + "] into Element i.e " + element);
			Reporter.log("While adding  [" + data + "] into Element i.e " + element);
			throw (e);
		}
	}

	public static void addText(WebElement element, String data, String logText) throws Exception {
		try {
			highlightElement(element);
			element.sendKeys(data);
			logger.info("[" + data + "] added succesfully to " + logText);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("While adding [" + data + "] into Element i.e " + logText);
			Reporter.log("While adding [" + data + "] into Element i.e " + logText);
			throw (e);
		}
	}

	public static void click(WebElement element) throws Exception {
		try {
			highlightElement(element);
			element.click();
			logger.info("Successfully clicked on Element ");
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("While trying to click on  " + element);
			Reporter.log("While trying to click on  " + element);
			throw (e);
		}
	}

	public static void click(WebElement element, String logText) throws Exception {
		try {
			highlightElement(element);
			element.click();
			logger.info("Successfully clicked on " + logText);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			logger.error("While trying to click on " + logText);
			Reporter.log("While trying to click on " + logText);
			throw (e);
		}
	}

	public WebElement getElement(String identifyby, String locator) {
		WebElement element = null;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				element = driver.findElement(By.id(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				element = driver.findElement(By.xpath(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				element = driver.findElement(By.name(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				element = driver.findElement(By.className(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				element = driver.findElement(By.linkText(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				element = driver.findElement(By.cssSelector(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				element = driver.findElement(By.partialLinkText(locator));
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				element = driver.findElement(By.tagName(locator));

			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
		highlightElement(element);
		return element;
	}

	public WebElement getElement(String identifyby, String locator, String logText) {
		WebElement element = null;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				element = driver.findElement(By.id(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				element = driver.findElement(By.xpath(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				element = driver.findElement(By.name(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				element = driver.findElement(By.className(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				element = driver.findElement(By.linkText(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				element = driver.findElement(By.cssSelector(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				element = driver.findElement(By.partialLinkText(locator));
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				element = driver.findElement(By.tagName(locator));
				highlightElement(element);
				logger.info(logText + " Element found  ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " -Unable to find [" + locator + "] By [" + identifyby + "] ");
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
		highlightElement(element);
		return element;
	}

	public WebElement getElementWithFluentWait(String identifyby, String locator) {
		WebElement element = null;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.id(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.className(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.linkText(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.cssSelector(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.partialLinkText(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.info("Error:Element not presented or not displayed on WebPage. ");
						return new RuntimeException("Error:Element not presented or not displayed on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.tagName(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
		highlightElement(element);
		return element;
	}

	public WebElement getElementWithFluentWait(String identifyby, String locator, String logText) {
		WebElement element = null;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.id(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				logger.error(e.getMessage());
				logger.error(logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ", e);
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ", e);
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {

						return driver.findElement(By.className(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ", e);
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {

						return driver.findElement(By.linkText(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ", e);
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {

						return driver.findElement(By.cssSelector(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ", e);
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {

						return driver.findElement(By.partialLinkText(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("CustomError:- [" + logText + "] Element Not presented on WebPage. ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage. ");
					}
				};
				wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {

						return driver.findElement(By.tagName(locator));
					}
				});
				logger.info(logText + " Element found with default fluentWait(upto 30sec, polling 5sec) ");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*@" + logText + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
		highlightElement(element);
		return element;
	}

	public WebElement getElementWithFluentWait(String identifyby, String locator, int timeoutInSeconds, int pollingTimeInSeconds) {
		WebElement element = null;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.id(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.name(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.className(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.linkText(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.cssSelector(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.partialLinkText(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- Element not presented on WebPage" + "with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.tagName(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log("*Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
		highlightElement(element);
		return element;
	}

	public WebElement getElementWithFluentWait(String identifyby, String locator, int timeoutInSeconds, int pollingTimeInSeconds, String logText) {
		WebElement element = null;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.id(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.xpath(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.name(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("className")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.className(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.linkText(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.cssSelector(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.partialLinkText(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver) {
					@Override
					protected RuntimeException timeoutException(String Message, Throwable lastException) {
						logger.error("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
						return new RuntimeException("Error:- [" + logText + "] Element Not presented on WebPage with timeout+[" + timeoutInSeconds + "] and pollingTime [" + pollingTimeInSeconds + "] ");
					}
				};
				wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(pollingTimeInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {

						logger.info(logText + " Element found with fluentWait" + "(" + timeoutInSeconds + "," + pollingTimeInSeconds + ") ");
						return driver.findElement(By.tagName(locator));
					}
				});
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				Reporter.log(logText + "-[" + timeoutInSeconds + "] - [" + pollingTimeInSeconds + "]" + " Unable to find this [" + locator + "] By [" + identifyby + "] ");
				throw (e);
			}
		}
		else {
			System.err.println("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
			logger.error("\"" + identifyby + "\" -Given Identifyby is a legal string,Please add a Valid one (Eg:-Xpath,CssSelector,class,Name)");
		}
		highlightElement(element);
		return element;
	}

	public String getRandomString(int len) {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public String getRandomValueOf(int Low, int High) {
		Random rnd = new Random();
		int Result = rnd.nextInt(High - Low) + Low;
		return Integer.toString(Result);
	}

}
