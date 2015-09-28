package com.ejercicios.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String cad;
		File original, copia;
		FileWriter fw;
		
		System.out.println("Escriba el nombre del fichero original y pulse 'enter':");
		cad = teclado.nextLine();
	    original = new File(cad);
	    if (original.exists())
	    {
	    	System.out.println("Escriba el nombre de la copia y pulse 'enter':");
			cad = teclado.nextLine();
		    copia = new File(cad);
		    try {
		    	if (copia.createNewFile())
			    {
			    	Scanner sc = new Scanner(original);
					fw = new FileWriter(copia, true);
					PrintWriter pw = new PrintWriter(fw);
				
					while (sc.hasNextLine())
					{
						pw.println(sc.nextLine());
					}
					pw.flush();
					pw.close();
					sc.close();
					teclado.close();
					System.out.println("El archivo se ha copiado con éxito");
			    }
			    else
					System.out.println("No se pudo crear el archivo de copia");
		    } catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	    else
			System.out.println("El archivo original no existe");
	}
}
