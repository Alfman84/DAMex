package com.ejercicios.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cad;
		Boolean exit = false;
		File f = new File("frases.txt");
		FileWriter fw;
		
		// Comprobamos si el archivo existe y si no intentamos crearlo
		try {
			if (!f.exists())
				f.createNewFile();
			if (f.exists())
			{
				// Creamos el escritor
				fw = new FileWriter(f, false);
				PrintWriter pw = new PrintWriter(fw);
				
				// Damos las indicaciones
				System.out.println("A continuación escriba frases y pulse 'enter' para almacenarlas. Pulse sólo 'enter' para terminar:");
				System.out.println("");
				
				// Repetimos las lecturas
				do
				{
					cad = sc.nextLine();
					// Si la cadena no esta vacia escribimos
					if (!cad.isEmpty())
					{
						pw.println(cad);
					}
					else
					{
						// Si es vacia cerramos los flujos y ponemos la 
						// variable exit a true para terminar el bucle 
						pw.flush();
						pw.close();
						sc.close();
						exit = true;
					}
				} while (!exit);
				
				// Mostramos el resultado
				System.out.println("");
				System.out.println("Archivo creado con éxito. Resultado:");
				
				// Creamos un scanner para el archivo
				Scanner fSc = new Scanner(f);
				
				// Mientras haya lineas por leer, leemos y mostramos por pantalla
				while (fSc.hasNextLine())
				{
					System.out.println(fSc.nextLine());
				}
				fSc.close();
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}