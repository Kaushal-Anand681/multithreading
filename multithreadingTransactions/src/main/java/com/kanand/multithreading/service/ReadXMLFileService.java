package com.kanand.multithreading.service;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.kanand.multithreading.dto.User;

@Service
public class ReadXMLFileService {

	public List<User> readXMLFile() {
		String filePath = "src/main/resources/user-mock-data.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		List<User> userList = new ArrayList<>();
		try {
			dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("record");
			for (int i = 0; i < nodeList.getLength(); i++) {
				userList.add(getUser(nodeList.item(i)));
//				userList.add(getUserTest(nodeList.item(i)));
			}
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}

		return userList;

	}

	private User getUserTest(Node node) {
		if(node.hasChildNodes()) {
			String nodeName = node.getNodeName();
			if(node.hasAttributes()) {
				Node namedNode = node.getAttributes().item(0);
			}
			int childNodes = node.getChildNodes().getLength();
			if(node.getChildNodes().getLength() == 11) {
				String parameterName = node.getTextContent();
			}
		}
		return null;
	}

	private User getUser(Node node) {
		User user = new User();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			user.setId(Integer.parseInt(getTagValue("id", element)));
			user.setFirstName(getTagValue("firstName", element));
			user.setLastName(getTagValue("lastName", element));
			user.setEmail(getTagValue("email", element));
			user.setGender(getTagValue("gender", element));
		}
		return user;
	}

	private String getTagValue(String tag, Element element) {
		return element.getElementsByTagName(tag).item(0).getTextContent();
//        Node node = (Node) nodeList.item(0);
//        return node.getNodeValue();
	}
}
