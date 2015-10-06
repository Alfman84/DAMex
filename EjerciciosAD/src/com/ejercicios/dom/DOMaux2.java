package com.ejercicios.dom;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMaux2 {

	static public Document openXMLfile() {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse("cuentas.xml");
			return doc;			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return doc;
		}
	}
		
	
	static public String showDOM(Document doc)
	{
		String node_data[]=null;
		String res="";
		Node node;
		
		Node root = doc.getFirstChild();
		NodeList nodelist = root.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++)
		{
			node = nodelist.item(i);
			if (node.getNodeType()==Node.ELEMENT_NODE)
			{
				procesarCuenta(node);
				res = res + "\n" + "Publicado en: " + node_data[0];
				res = res + "\n" + "Autor: " + node_data[1];
				res = res + "\n" + "Título: " + node_data[2];
				res = res + "------------------------------";
			}
		}
		return res;
	}
	
	static public void procesarCuenta(Node node)
	{
		Node temp = null;
		
		NodeList nodelist = node.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++)
		{
			temp = nodelist.item(i);
			if (temp.getNodeType()==Node.ELEMENT_NODE)
			{
				procesarTitular(temp);
			}
		}
	}
	
	static public void procesarTitular(Node titular)
	{
		
	}
}
