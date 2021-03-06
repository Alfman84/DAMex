package com.ejemplos.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMauxLibros extends DOMaux {

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
				res = res + "\n" + "T�tulo: " + node_data[2];
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
