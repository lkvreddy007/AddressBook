package com.org.capg;

import java.util.*;
public class FinalMain extends AddressBookMain {
	private static List<Contact> addressBook=new ArrayList<Contact>();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		AddressBookMain abm=new AddressBookMain();
		HashMap<String, List<Contact>> shelf=new HashMap<>();
		boolean exit =true;
		while(exit) {
			System.out.println("\nMenu");
			System.out.println("1.Add Address Book to Shelf");
			System.out.println("2.Display names of all address books in shelf");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int check=Integer.parseInt(sc.nextLine());
			switch(check){
				case 1:
					addressBook = abm.addressBookCreator();
					boolean a=true;
					String name="";
					while(a) {
						System.out.println("\nEnter the name for Address Book:");
						name=sc.nextLine();
						if(shelf.containsKey(name)) {
							System.out.println("Key already exists.");
						} 
						else {
							shelf.put(name, addressBook);
							System.out.println("Address book added to shelf");
							a=false;
						}
					}
					break;
					
				case 2:
					Set<String> keys=shelf.keySet();
					System.out.println("Address books in the shelf are:");
					for(String key:keys) {
						System.out.println(key);
					}
					break;
					
				case 3:
					exit=false;
					break;
					
				default:
					System.out.println("Enter either 1 or 2 or 3");
			}
		}
	}
}
