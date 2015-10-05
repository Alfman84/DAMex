package com.ejercicios.ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7bis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, suma;
		File f = new File("sumas2.txt");
		
		// Comprobamos si el archivo existe y si no intentamos crearlo
		try {
			if (!f.exists())
				f.createNewFile();
			if (f.exists())
			{
				// Pedimos y leemos los dos numeros como enteros
				System.out.print("Escriba el primer número: ");
				n1 = sc.nextInt();
				System.out.print("Escriba el segundo número: ");
				n2 = sc.nextInt();
				sc.close();
				suma = n1+n2;
				
				// Creamos el escritor de datos
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
				
				// Escribimos datos primitivos, en este caso enteros
				dos.writeInt(n1);
				dos.writeInt(n2);
				dos.writeInt(suma);
				dos.close();
				
				// Preparamos un scanner para el archivo y mostramos el
				// contenido mediante un lector de datos primitivos
				sc = new Scanner(f);
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);
				
				// Mientras haya datos disponibles
				while(fis.available()>0)
				{
					// Leemos los tres enteros almacenados y los mostramos
					n1 = dis.readInt();
					n2 = dis.readInt();
					suma = dis.readInt();
					System.out.println(n1 + " + " + n2 + " = " + suma);
				}
				dis.close();
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}