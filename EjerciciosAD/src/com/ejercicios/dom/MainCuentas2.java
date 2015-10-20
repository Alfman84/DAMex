package com.ejercicios.dom;

import org.w3c.dom.Document;

public class MainCuentas2 {

	public static void main(String[] args) {
		Document doc = DOMaux2.openXMLfile();
		if (doc!=null)
		{
			DOMaux2.annadirCuenta(doc, "5392910");
			System.out.println(DOMaux2.showDOM(doc));
			DOMaux2.guardarDOM(doc, "otro.xml");
		}
		else
			System.out.println("error en el proceso");
	}
}