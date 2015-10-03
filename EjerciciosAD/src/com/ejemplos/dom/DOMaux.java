package com.ejemplos.dom;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMaux {

	static public Document openXMLfile() {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			System.out.println("Escriba el nombre del fichero");
			Scanner teclado = new Scanner(System.in);
			String nombre = teclado.nextLine();
			teclado.close();
			File file = new File(nombre);
			if (file.exists())
			{
				doc = builder.parse(file);
				return doc;
			}
			else
				return null;
			
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
			return doc;
		} catch (SAXException e) {
			System.out.println(e.getMessage());
			return doc;
		} catch (IOException e) {
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
				node_data=processBook(node);
				res = res + "\n" + "Publicado en: " + node_data[0];
				res = res + "\n" + "Autor: " + node_data[1];
				res = res + "\n" + "Título: " + node_data[2];
				res = res + "\n------------------------------";
			}
		}
		return res;
	}
	
	static public String[] processBook(Node node)
	{
		String data[] = new String[3];
		Node temp = null;
		int counter = 1;
		data[0] = node.getAttributes().item(0).getNodeValue();
		NodeList nodelist = node.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++)
		{
			temp = nodelist.item(i);
			if (temp.getNodeType()==Node.ELEMENT_NODE)
			{
				data[counter] = temp.getChildNodes().item(0).getNodeValue();
				counter++;
			}
		}
		return data;
	}
}
