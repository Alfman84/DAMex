package com.ejercicios.ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f;
		int counter = 0;
		
		try {
			// Pedimos el nombre del archivo a leer
			System.out.println("Escriba el nombre del archivo de texto que quiera leer y pulse 'enter':");
			String cad = sc.nextLine();
		    f = new File(cad);
		    
		    // Comprobamos si existe
		    if (f.exists())
		    {
		    	// Creamos un scanner para el archivo
				Scanner fSc = new Scanner(f);
				
				// Repetimos mientras haya lineas por leer
				while (fSc.hasNextLine())
				{
					// Cuando el contador es menor que 5
					if (counter<5)
					{
						// Mostramos por pantalla la siguiente linea y aumentamos el contador
						System.out.println(fSc.nextLine());
						counter++;
					}
					// Si el contador llega a 5
					else
					{
						// Espero un 'enter' para continuar y pongo el contador a 0
						System.out.println("                   -- Pulse 'enter' para continuar --                 ");
						sc.nextLine();
						counter = 0;
					}
				}
				System.out.println("                         -- Fin del archivo --                 ");
				fSc.close();
			}
			else
				System.out.println("El archivo especificado no existe o no se puede leer");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}