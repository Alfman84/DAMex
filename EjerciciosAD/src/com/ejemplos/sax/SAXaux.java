package com.ejemplos.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXaux {
	

	public SAXParser crearParserSAX()
	{
		try
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//Se crea un objeto SAXParser para interpretar el documento XML.
			SAXParser parser=factory.newSAXParser();
			return parser;
		}catch(Exception e){
			e.printStackTrace();
			return null;
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
