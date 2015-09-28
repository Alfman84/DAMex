package com.ejercicios.ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String cad1, cad2;
		File primero, segundo;
		int cEq = 0; 		// number of same characters
		int cDif = 0;		// number of different characters
		int sEq = 0;		// number of same lines
		int sDif = 0;		// number of different lines
		int nLines1 = 0;	// number of lines in first file
		int nLines2 = 0;	// number of lines in second file
		
		// Select the first file
		System.out.println("Escriba el nombre del primer archivo a comparar y pulse 'enter':");
		cad1 = teclado.nextLine();
	    primero = new File(cad1);
	    if (primero.exists())
	    {
	    	// Select the second file
	    	System.out.println("Escriba el nombre del segundo archivo a comparar y pulse 'enter':");
			cad1 = teclado.nextLine();
		    segundo = new File(cad1);
		    try {
		    	if (segundo.exists())
			    {
			    	Scanner sc1 = new Scanner(primero);
			    	Scanner sc2 = new Scanner(segundo);
				
			    	// while first file has lines
					while (sc1.hasNextLine())
					{
						nLines1++;
						cad1 = sc1.nextLine();
						
						// if second files has lines
						if (sc2.hasNextLine())
						{
							nLines2++;
							cad2 = sc2.nextLine();
							// if the lines are equal
							if (cad1.compareTo(cad2)==0)
							{
								sEq++;
								cEq += cad1.length();
							}
							else
							{
								sDif++;
								cDif += nDiffChars(cad1, cad2);
								cEq += nEqualChars(cad1, cad2);
							}
						}
						else
						{
							sDif++;
							cDif += cad1.length();
						}
					}
					while (sc2.hasNextLine())
					{
						nLines2++;
						sDif++;
						cad2 = sc2.nextLine();
						cDif += cad2.length();
					}
					sc1.close();
					sc2.close();
					teclado.close();
					System.out.println("Comparación realizada con éxito");
					System.out.println("-------------------------------");
					System.out.println("Líneas del primer archivo: " + nLines1);
					System.out.println("Líneas del segundo archivo: " + nLines2);
					System.out.println("Líneas iguales: " + sEq);
					System.out.println("Líneas distintas: " + sDif);
					System.out.println("Caracteres iguales: " + cEq);
					System.out.println("Caracteres distintos: " + cDif);
			    }
			    else
					System.out.println("No se encontró el archivo especificado");
		    } catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	    else
			System.out.println("No se encontró el archivo especificado");
	}
	
	// This method compare two strings and returns the number of equal characters
	public static int nEqualChars(String cad1, String cad2)
	{
		int res = 0;
		int l1 = cad1.length();
		int l2 = cad2.length();
		
		// if the first string is shorten than the second string
		if (l1<=l2)
		{
			for (int i=0;i<l1;i++)
				// character comparison
				if (cad1.charAt(i)==cad2.charAt(i))
					res++;
		}
		else
		{
			for (int i=0;i<l2;i++)
				// character comparison
				if (cad1.charAt(i)==cad2.charAt(i))
					res++;
		}
		return res;
	}
			
	// This method compare two strings and returns the number of diff characters
	public static int nDiffChars(String cad1, String cad2)
	{
		int res = 0;
		int l1 = cad1.length();
		int l2 = cad2.length();
		
		// if the first string is shorten than the second string
		if (l1<=l2)
		{
			for (int i=0;i<l1;i++)
				// character comparison
				if (cad1.charAt(i)!=cad2.charAt(i))
					res++;
			// add the length difference
			res += l2-l1;
		}
		else
		{
			for (int i=0;i<l2;i++)
				// character comparison
				if (cad1.charAt(i)!=cad2.charAt(i))
					res++;
			// add the length difference
			res += l1-l2;
		}
		return res;
	}
	
	
}