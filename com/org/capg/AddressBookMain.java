package com.org.capg;

import java.util.*;

public class AddressBookMain{
	private List<Contact> addressBook=new ArrayList<Contact>();
	
	public void addContact(Contact obj) {
		this.addressBook.add(obj);
		System.out.println("Contact added to Address Book");
	}
	
	public static void main(String[] args) {
		AddressBookMain abm=new AddressBookMain();
		String firstName,lastName,address,zip,phoneNo,email;
		System.out.println("Welcome to Address Book");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name:");
		firstName = sc.nextLine();
		System.out.println("Enter Last Name:");
		lastName = sc.nextLine();
		System.out.println("Enter the Address:");
		address= sc.nextLine();
		System.out.println("Enter Zip Code:");
		zip= sc.nextLine();
		System.out.println("Enter Phone Number:");
		phoneNo= sc.nextLine();
		System.out.println("Enter Email Id:");
		email= sc.nextLine();
		Contact con=new Contact(firstName, lastName, address, zip, phoneNo, email);
		abm.addContact(con);
		sc.close();
	}
}
