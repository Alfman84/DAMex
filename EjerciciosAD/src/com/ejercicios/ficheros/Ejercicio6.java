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
		File f = new File("registro.txt");
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
				
				// Damos las indicaciones de uso
				System.out.println("A continuación escriba frases y pulse 'enter' para almacenarlas. Pulse sólo 'enter' para terminar:");
				System.out.println("");
				
				// Repetimos mientras que la variable 'exit' sea falsa
				do
				{
					// Leemos la linea
					cad = sc.nextLine();
					// Si no es vacia la guardamos
					if (!cad.isEmpty())
					{
						pw.println(cad);
					}
					
					// De otra manera, cerramos los flujos y activamos la variable de salida
					else
					{
						pw.flush();
						pw.close();
						sc.close();
						exit = true;
					}
				} while (!exit);
				
				// Mostramos un mensaje de aviso y el archivo resultante
				System.out.println("");
				System.out.println("Archivo creado con éxito. Resultado:");
				Scanner fSc = new Scanner(f);
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
