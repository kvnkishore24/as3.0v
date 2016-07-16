package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import base.BaseTest;

/**
 * @author kishorekalapala
 *
 * @project AutomationFramework Aug 20, 2015
 */
public class ConfiguratorSupport {
	private static Logger log = Logger.getLogger(ConfiguratorSupport.class);
	static Properties prop;
	static String stringValue;
	static String fileName;
	static InputStream input = null;

	public static void checkfileExistence(String filePath) {
		if (filePath != null) {
			try {
				prop = new Properties();
				input = new FileInputStream(filePath);
				prop.load(input);
				if (input == null) {
					System.err.println("Unable to find Configfile i.e \"" + filePath + "\"");
					log.error("Unable to find Configfile i.e \"" + filePath + "\"");
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				log.error("*Issue while loading Configfile @checkfileExistence");
			}
			finally {
				if (input != null) {
					try {
						input.close();
					}
					catch (Exception e) {
						System.err.println(e.getMessage());
						log.error("*Issue while closing Configfile @checkfileExistence");
					}
				}
			}
		}
		else {
			log.error(filePath + "not found");
		}
	}

	// Specified "FilePath" properties File
	public static String getProperty(String StringKey, String filePath) {
		try {
			checkfileExistence(filePath);
			fileName = filePath;
			File propertyFile = new File(filePath);
			if (propertyFile.exists()) {
				FileInputStream in = new FileInputStream(propertyFile);
				prop.load(in);
				if (!(prop.containsKey(StringKey))) {
					System.err.println("Error:- No such string available in \"" + filePath + "\" Properties file");
					log.error("Error:- No such string available in \"" + filePath + "\" Properties file");
					Reporter.log("Error:- No such string available in \"" + filePath + "\" Properties file");
				}
				else {
					stringValue = prop.getProperty(StringKey);
				}
				in.close();
			}
			else {
				System.err.println(filePath + "File not found!");
				log.error(filePath + "File not found!");
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error In \"" + filePath + "\" file");
			log.error(e.getMessage());
			log.error("Error In \"" + filePath + "\" file");
			Reporter.log("Error In \"" + filePath + "\"  file");
		}
		return stringValue;
	}

	// Test Properties File
	public String getProperty(String TestingPropertiesStringKey) {
		try {
			checkfileExistence(BaseTest.testPropertiesFilePath);
			File testPropertyFile = new File(BaseTest.testPropertiesFilePath);
			if (testPropertyFile.exists()) {
				FileInputStream in = new FileInputStream(testPropertyFile);
				prop.load(in);
				if (!(prop.containsKey(TestingPropertiesStringKey))) {
					System.err.println("Error:- No such string available in \"" + TestingPropertiesStringKey + "\"");
					log.error("Error:- No such string available in \"" + TestingPropertiesStringKey + "\"");
					Reporter.log("Error:- No such string available in \"" + TestingPropertiesStringKey + "\"");
				}
				else {
					stringValue = prop.getProperty(TestingPropertiesStringKey);
				}
				in.close();
			}
			else {
				System.err.println("File not found!");
				log.error("File not found!");
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error:- In \"" + TestingPropertiesStringKey + "\"");
			log.error(e.getMessage());
			log.error("Error:- In \"" + TestingPropertiesStringKey + "\"");
		}
		return stringValue;
	}
}