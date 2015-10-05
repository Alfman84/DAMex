package com.ejercicios.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cad;
		Boolean exit = false;
		File f = new File("registroDeUsuario.txt");  // El archivo es fijo
		FileWriter fw;
		try {
			// Comprobamos que el archivo se crea correctamente
			if (f.createNewFile())
			{
				// Creamos el escritor a partir del file
				fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);
				System.out.println("A continuación escriba frases y pulse 'enter' para almacenarlas. Escriba 'fin' para terminar:");
				System.out.println("");
				
				// Entramos al bucle de lectura de teclado y escritura en el archivo
				do
				{
					cad = sc.nextLine();
					// Si la linea leida es distinta de 'fin' la escribimos en el archivo
					if (cad.compareTo("fin")!=0)
					{
						pw.println(cad);
					}
					
					// en caso contrario, salimos, cambiando el valor a la variable exit y cerrando los flujos
					else
					{
						pw.flush();
						pw.close();
						sc.close();
						exit = true;
					}
				} while (!exit);
				System.out.println("Archivo creado con éxito");
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
