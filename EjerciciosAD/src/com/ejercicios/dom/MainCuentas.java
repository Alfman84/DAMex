package com.ejercicios.dom;

import org.w3c.dom.Document;

public class MainCuentas {

	public static void main(String[] args) {
		Document doc = DOMaux2.openXMLfile();
		if (doc!=null)
			System.out.println(DOMaux2.showDOM(doc));
		else
			System.out.println("error en el proceso");
	}
}