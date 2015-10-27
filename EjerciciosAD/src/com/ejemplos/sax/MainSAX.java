package com.ejemplos.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;

public class MainSAX {

	public static void main(String[] args) {
		SAXaux saxAux = new SAXaux();
		ManejadorSAX sh = new ManejadorSAX();
		SAXParser parser = saxAux.crearParserSAX();
		File fXML = new File("Libros.xml");
		System.out.println(saxAux.recorrerSAX(fXML, sh, parser));
	}
}
