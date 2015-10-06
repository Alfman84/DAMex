package com.ejercicios.dom;

import org.w3c.dom.Document;

import com.ejemplos.dom.DOMaux;

public class MainCuentas {

	public static void main(String[] args) {
		Document doc = DOMaux.openXMLfile();
		if (doc!=null)
			System.out.println(DOMaux.showDOM(doc));
		else
			System.out.println("error en el proceso");
	}

}