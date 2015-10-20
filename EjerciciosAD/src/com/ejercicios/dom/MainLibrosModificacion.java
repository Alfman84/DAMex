package com.ejercicios.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.w3c.dom.Document;

import com.ejemplos.dom.DOMauxLibros;

public class MainLibrosModificacion {

	public static void main(String[] args) {
		
		String titulos[] = leerTitulos();
		if (titulos == null)
		{
			System.out.println("Error con el archivo");
			return;
		}
		
		Document doc = DOMauxLibros.openXMLfile();
		if (doc!=null)
		{
			System.out.println(DOMauxLibros.showDOM(doc));
			DOMaux2.guardarDOM(doc, "otro.xml");
		}
		else
			System.out.println("error en el proceso");
	}
	
	public static String[] leerTitulos()
	{
		String titulos[] = new String[2];

		File mod = new File("modificacion.txt");
		if (mod.exists())
		{
			Scanner sc;
			try {
				sc = new Scanner(mod);
		
				titulos[0] = sc.nextLine();
				titulos[1] = sc.nextLine();
				
				sc.close();
				return titulos;
			} catch (FileNotFoundException e) {
				return null;
			}
		}
		else
			return null;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}