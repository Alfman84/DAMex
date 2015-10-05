package com.ejercicios.ficheros;

import java.io.Serializable;

// Esta clase es un bean y debe implementar la interfaz Serializable
// para poder ser guardada en el fichero
public class Contact implements Serializable{
	// Este atributo se genera solo y es para la interfaz Serializable
	private static final long serialVersionUID = -4655302213072839866L;
	
	// Los campos del enunciado
	String name;
	String lastName;
	String address;
	String city;
	String telephone;
	String birthDate;
	
	// El constructor con todos los atributos del objeto
	public Contact(String name, String lastName, String address, String city, String telephone, String birthDate) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.birthDate = birthDate;
	}
	
	// Getters y setters
	public Contact() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	// Este metodo muestra por pantalla el contenido del contacto
	// Tambien podria haberse formado un string con los datos y devolverlo
	// para que fuera el objeto que llama a este metodo el que sacara por pantalla
	public void showContact() {
		System.out.println("Nombre: " + name);
		System.out.println("Apellidos: " + lastName);
		System.out.println("Dirección: " + address);
		System.out.println("Poblacion: " + city);
		System.out.println("Teléfono: " + telephone);
		System.out.println("Fecha de cumpleaños: " + birthDate);
	}	
}
