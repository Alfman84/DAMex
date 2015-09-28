package com.ejercicios.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cad;
		Boolean exit = false;
		File f = new File("sumas.txt");
		FileWriter fw;
		try {
			if (f.createNewFile())
			{
				fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);
				System.out.println("A continuación escriba frases y pulse 'enter' para almacenarlas. Pulse sólo 'enter' para terminar:");
				System.out.println("");
				do
				{
					cad = sc.nextLine();
					if (!cad.isEmpty())
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
				System.out.println("");
				System.out.println("Archivo creado con éxito. Resultado:");
				Scanner fSc = new Scanner(f);
				while (fSc.hasNextLine())
				{
					System.out.println(fSc.nextLine());
				}
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
