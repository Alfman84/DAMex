package com.ejemplos.dom;

import org.w3c.dom.Document;

public class Ejemplo {

	public static void main(String[] args) {
		Document doc = DOMauxLibros.openXMLfile();
		if (doc!=null)
			System.out.println(DOMauxLibros.showDOM(doc));
		else
			System.out.println("error en el proceso");
	}

}
