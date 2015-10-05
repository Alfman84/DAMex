package com.ejercicios.ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File("agenda.data");
		boolean exit=false;
		FileInputStream fis;
		FileOutputStream fos;
		
		// Comprobamos si el archivo existe y si no intentamos crearlo
		try {
			if (!f.exists())
				f.createNewFile();
			if (f.exists())
			{
				// Mientras no se ponga la variable exit a true												
				while (exit!=true)
				{
					// Mostramos las tres opciones
					System.out.println("1. Introducir nuevo contacto.");
					System.out.println("2. Consultar agenda.");
					System.out.println("3. Salir.");
					
					// Leemos y comprobamos la elegida
					String option = sc.nextLine();
					
					// Opcion nuevo contacto
					if (option.compareTo("1")==0)
					{
						// Creamos el objeto pidiendo y rellenando sus campos 
						Contact contact = new Contact();
						System.out.print("Nombre: ");
						contact.setName(sc.nextLine());
						System.out.print("Apellidos: ");
						contact.setLastName(sc.nextLine());
						System.out.print("Dirección: ");
						contact.setAddress(sc.nextLine());
						System.out.print("Población: ");
						contact.setCity(sc.nextLine());
						System.out.print("Teléfono: ");
						contact.setTelephone(sc.nextLine());
						System.out.print("Fecha de nacimiento: ");
						contact.setBirthDate(sc.nextLine());
						
						// Creamos un escritor de objetos, escribimos el contacto
						// en el archivo y cerramos los flujos
						fos = new FileOutputStream(f, true);
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(contact);	
						oos.flush();
						oos.close();
						fos.flush();
						fos.close();
					}
					
					// Opcion consultar agenda
					else if (option.compareTo("2")==0)
					{
						Object contact;
						fis = new FileInputStream(f);
						try
						{
							// Un bucle infinito hasta que salte la excepcion
							// de final de archivo EOFException
							while (true)
							{	
								// Creamos un lector de objetos y recuperamos un contacto
								ObjectInputStream ois = new ObjectInputStream(fis);
								contact = ois.readObject();
								
								// Hacemos 'cast' a la clase contacto y
								// lo mostramos con su metodo
								((Contact)contact).showContact();
								//ois.close();
								System.out.println("      -------------");
							}
						}
						catch (EOFException e)
						{
							// Mostramos un mensaje, cerramos el flujo y salimos de la opcion
							System.out.println(" --- Final de la agenda ---");
							fis.close();
						}
					}
					
					// Opcion salir, activamos la variable 'exit' con true
					else if (option.compareTo("3")==0)
					{
						exit = true;
					}
					else
						System.out.println("Opcion no válida");
				}
				
				
				sc.close();
			}
			else
				System.out.println("No se pudo crear el archivo");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}