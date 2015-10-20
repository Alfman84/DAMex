package com.ejemplos.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;

public class MainSAX {

	public static void main(String[] args) {
		
		ManejadorSAX sh = null;
		SAXParser parser = null;
		SAXaux saxAux = new SAXaux();
		File fXML = new File("Libros.xml");
		
		saxAux.abrir_XML_SAX(sh, parser);
		saxAux.recorrerSAX(fXML, sh, parser);
	}

}
