package com.ejemplos.dom;

import org.w3c.dom.Document;

public class Ejemplo {

	public static void main(String[] args) {
		Document doc = DOMaux.openXMLfile();
		if (doc!=null)
			System.out.println(DOMaux.showDOM(doc));
		else
			System.out.println("error en el proceso");
	}

}
