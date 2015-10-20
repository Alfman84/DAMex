package com.ejemplos.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXaux {
	static ManejadorSAX sh = null;
	static SAXParser parser = null;
	
	public static void main(String[] args) {
		SAXaux saxAux = new SAXaux();
		File fXML = new File("Libros.xml");
		
		saxAux.abrir_XML_SAX(sh, parser);
		saxAux.recorrerSAX(fXML, sh, parser);
	}

	public int abrir_XML_SAX(ManejadorSAX sh, SAXParser parser)
	{
		try
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//Se crea un objeto SAXParser para interpretar el documento XML.
			parser=factory.newSAXParser();
			//Se crea una instancia del manejador que será el que recorra el documento
			//XML secuencialmente
			sh = new ManejadorSAX();
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public String recorrerSAX(File fXML,ManejadorSAX sh,SAXParser parser){
		try{
			parser.parse(fXML,sh);
			return sh.cadena_resultado;
		} catch (SAXException e) {
			e.printStackTrace(); return "Error al parsear con SAX";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al parsear con SAX";
		}
	}
}
