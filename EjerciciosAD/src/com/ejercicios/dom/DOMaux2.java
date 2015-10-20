package com.ejercicios.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ejemplos.dom.DOMaux;

public class DOMaux2 extends DOMaux{
	
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
	
	static public void annadirCuenta(Document doc, String id)
	{
		Node root = doc.getFirstChild();
		Node cuenta = doc.createElement("Cuenta");
		((Element)cuenta).setAttribute("id", id);
		root.appendChild(cuenta);
	}
	
	static public void annadirTitularCuenta(Document doc, String idCuenta, String nombre, String calle)
	{
//		Node root = doc.getFirstChild();
//		NodeList nodelist = root.getChildNodes();
//		for (int i=0; i<nodelist.getLength(); i++)
//		{
//			Node temp = nodelist.item(i);
//			if (temp.getNodeType()==Node.ELEMENT_NODE)
//			{
//				String id = temp.getAttributes().item(0).getNodeValue();
//				if (id.compareTo(idCuenta)==0)
//				{
//					Node titular = doc.createElement("Titular");
//					String valor = temp.getChildNodes().item(0).getNodeValue();
//				System.out.print(dato + " - " + valor + " / ");
//			}
//		}
//		Node cuenta = doc.createElement("Cuenta");
//		((Element)cuenta).setAttribute("id", id);
//		root.appendChild(cuenta);
	}
}
