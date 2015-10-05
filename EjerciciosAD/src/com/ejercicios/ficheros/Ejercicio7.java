package com.ejercicios.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n1, n2, cad;
		File f = new File("sumas.txt");
		FileWriter fw;
		
		// Comprobamos si el archivo existe y si no intentamos crearlo
		try {
			if (!f.exists())
				f.createNewFile();
			if (f.exists())
			{
				// Creamos el escritor
				fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);
				
				// Pedimos y leemos los dos numeros como caracteres
				System.out.print("Escriba el primer número: ");
				n1 = sc.nextLine();
				System.out.print("Escriba el segundo número: ");
				n2 = sc.nextLine();
				
				// Preparamos la cadena de texto indicada en el enunciado calculando
				// el valor de la suma pasando a enteros los numeros leidos
				cad = n1 + " + " + n2 + " = " + (Integer.valueOf(n1)+Integer.valueOf(n2));
				
				// Escribimos y cerramos los flujos
				pw.println(cad);
				pw.flush();
				pw.close();
				sc.close();
				
				// Preparamos un scanner para el archivo y mostramos el contenido
				sc = new Scanner(f);
				while (sc.hasNextLine())
					System.out.println(sc.nextLine());
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
