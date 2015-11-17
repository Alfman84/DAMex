package com.ejemplos.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class MainJAXB {

	public static void main(String[] args) {
		// Creamos el file de libros
		File fichero = new File("Libros.xml");
		Libros misLibros = new Libros();
		
		// Obtenemos los objetos desde el XML
		misLibros = abrir_XML_JAXB(fichero);
		
		// Mostramos el resultado de recorrer los objetos
		String resultado = recorrerJAXByMostrar(misLibros);
		System.out.println(resultado);
	}
	
	public static Libros abrir_XML_JAXB(File fichero)
	{
		JAXBContext contexto;
		Libros misLibros;
		try
		{
			// Crea una instancia JAXB
			contexto = JAXBContext.newInstance(Libros.class);
			// Crea un objeto Unmarshaller
			Unmarshaller u = contexto.createUnmarshaller();
			// Deserializa (unmarshal) el fichero
			misLibros = (Libros) u.unmarshal(fichero);
			return misLibros;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static String recorrerJAXByMostrar (Libros misLibros) {
		String cadena_resultado = "";
		
		// Crea una lista con objetos de tipo libro
		List<Libros.Libro> lLibros = misLibros.getLibro();
		
		// Recorre la lista para sacar los valores
		for (int i=0; i<lLibros.size();i++)
		{
			cadena_resultado += "\n" + " Publicado en: " + lLibros.get(i).getPublicadoEn();
			cadena_resultado += "\n" + " El Título es: " + lLibros.get(i).getTitulo();
			cadena_resultado += "\n" + " El Autor es: " + lLibros.get(i).getAutor();
			cadena_resultado += "\n" + "---------------------------";
		}
		return cadena_resultado;
	}
}
