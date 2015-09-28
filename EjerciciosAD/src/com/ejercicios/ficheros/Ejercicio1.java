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
		File f = new File("registroDeUsuario.txt");
		FileWriter fw;
		try {
			if (f.createNewFile())
			{
				fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);
				System.out.println("A continuaci�n escriba frases y pulse 'enter' para almacenarlas. Escriba 'fin' para terminar:");
				System.out.println("");
				do
				{
					cad = sc.nextLine();
					if (cad.compareTo("fin")!=0)
					{
						pw.println(cad);
					}
					else
					{
						pw.flush();
						pw.close();
						sc.close();
						exit = true;
					}
				} while (!exit);
				System.out.println("Archivo creado con �xito");
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
