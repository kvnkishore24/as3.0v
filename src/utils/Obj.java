package utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import base.BaseTest;

/**
 * @author kishorekalapala
 *
 * @project AutomationFramework Aug 20, 2015
 */
public class Obj {
	static DocumentBuilderFactory docBuilderFactory = null;
	static DocumentBuilder docBuilder = null;
	static Document doc = null;

	public static String getIdentify(String objectName) throws Exception {
		String identification = null;
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File(ConfiguratorSupport.getProperty("objectRepositoryFilePath", BaseTest.ProjectPropertiesFilePath)));

			boolean flag = false;
			NodeList listOfObject = doc.getElementsByTagName("object");
			for (int s = 0; s < listOfObject.getLength(); s++) {

				Node firstOjectNode = listOfObject.item(s);
				if (firstOjectNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstObjectElement = (Element) firstOjectNode;
					NodeList firstNameList = firstObjectElement.getElementsByTagName("name");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					String name = ((Node) textFNList.item(0)).getNodeValue().trim();

					if (name.equals(objectName)) {
						flag = true;
						NodeList lastNameList = firstObjectElement.getElementsByTagName("identifyby");
						Element lastNameElement = (Element) lastNameList.item(0);
						NodeList textLNList = lastNameElement.getChildNodes();
						identification = ((Node) textLNList.item(0)).getNodeValue().trim();
						if (identification == "") {
							System.out.println("idenfication null");
							System.out.println("The Object does not have a \"IdentifyBy\" attribute value for the Object" + objectName);
						}
						return identification;
					}
					else {
						continue;
					}
				}
			}
			if (!flag) {
				System.out.println("Given Object-" + objectName + "not created in object.xml");
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in getIdentify() Method");
			System.err.println("Given \"" + objectName + "\" Object not listed in objectrepository.xml File (OR) \"" + objectName + "\" IDENTIFY tag got NULL ");
			throw (e);
		}
		return "";
	}

	public static String getLocation(String objectName) throws Exception {
		String identification = null;
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File(ConfiguratorSupport.getProperty("objectRepositoryFilePath", BaseTest.ProjectPropertiesFilePath)));
			// doc = docBuilder.parse(new
			// File("ConfigFiles/objectrepository.xml"));
			NodeList listOfObject = doc.getElementsByTagName("object");
			boolean flag = false;
			for (int s = 0; s < listOfObject.getLength(); s++) {
				Node firstOjectNode = listOfObject.item(s);
				if (firstOjectNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstObjectElement = (Element) firstOjectNode;
					NodeList firstNameList = firstObjectElement.getElementsByTagName("name");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					String name = ((Node) textFNList.item(0)).getNodeValue().trim();
					if (name.equals(objectName)) {
						flag = true;
						NodeList lastNameList = firstObjectElement.getElementsByTagName("value");
						Element lastNameElement = (Element) lastNameList.item(0);
						NodeList textLNList = lastNameElement.getChildNodes();
						identification = ((Node) textLNList.item(0)).getNodeValue().trim();
						if (identification == "") {
							System.out.println("idenfication null");
							System.out.println("The Object does not have a \"Value\" attribute value for the Object" + objectName);
						}
						return identification;
					}
					else {
						continue;
					}
				}
			}
			if (!flag) {
				System.out.println("Given Object-" + objectName + "not added to object.xml file");
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error in getLocation() Method");
			System.err.println("Given \"" + objectName + "\" Object not listed in objectrepository.xml File (OR) \"" + objectName + "\"  VALUE tag got NULL ");
		}
		return identification;
	}
}