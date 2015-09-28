package com.ejercicios.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f;
		int counter = 0;
		
		try {
			// Select the text file
			System.out.println("Escriba el nombre del archivo de texto que quiera leer y pulse 'enter':");
			String cad = sc.nextLine();
		    f = new File(cad);
		    if (f.exists())
		    {
				Scanner fSc = new Scanner(f);
				while (fSc.hasNextLine())
				{
					if (counter<5)
					{
						System.out.println(fSc.nextLine());
						counter++;
					}
					else
					{
						System.out.println("                   -- Pulse 'enter' para continuar --                 ");
						sc.nextLine();
						counter = 0;
					}
				}
				System.out.println("                         -- Fin del archivo --                 ");
			}
			else
				System.out.println("El archivo especificado no existe o no se puede leer");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
