package com.ejemplos.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import org.apache.xml.serialize.OutputFormat;
//import org.apache.xml.serialize.XMLSerializer;

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
		String res = "";
		Node node;
		
		Node root = doc.getFirstChild();
		NodeList nodelist = root.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++)
		{
			node = nodelist.item(i);
			if (node.getNodeType()==Node.ELEMENT_NODE)
			{
				res = processNode(node);
			}
		}
		return res;
	}
	
	static public String processNode(Node node)
	{
		String res = "";
		return res;
	}
	
	static public void guardarDOM(Document doc, String fileName)
	{
		File f = new File(fileName);
		
		// Modo de serializar incluido en los apuntes del libro
		// pero obsoleto
//		OutputFormat of = new OutputFormat(doc);
//		of.setIndenting(true);
//		XMLSerializer serializer;
//		try {
//			serializer = new XMLSerializer (new FileOutputStream(f), of);
//			serializer.serialize(doc);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// Modo alternativo de serializacion del Document
		Source source = new DOMSource(doc);
		Result result = new StreamResult(f); //nombre del archivo
        Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
