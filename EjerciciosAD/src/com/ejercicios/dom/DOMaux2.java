package com.ejercicios.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
			}
		}
		return res;
	}
	
	static public void procesarCuenta(Node node)
	{
		Node temp = null;
		String nCuenta= node.getAttributes().item(0).getNodeValue();
		System.out.println("Cuenta numero  " + nCuenta);
		NodeList nodelist = node.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++)
		{
			temp = nodelist.item(i);
			if (temp.getNodeType()==Node.ELEMENT_NODE)
			{
				procesarTitular(temp);
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");
	}
	
	static public void procesarTitular(Node titular)
	{
		System.out.print("\tTitular: ");
		NodeList nodelist = titular.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++)
		{
			Node temp = nodelist.item(i);
			if (temp.getNodeType()==Node.ELEMENT_NODE)
			{
				String dato = temp.getNodeName();
				String valor = temp.getChildNodes().item(0).getNodeValue();
				System.out.print(dato + " - " + valor + " / ");
			}
		}
		System.out.println("");
	}
}
