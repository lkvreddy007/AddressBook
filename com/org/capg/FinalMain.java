package com.org.capg;

import java.util.*;
import java.util.stream.Collectors;

public class FinalMain {
	static AddressBookMain abm=new AddressBookMain();
	static HashMap<String, List<Contact>> shelf=new HashMap<>();
	private static List<Contact> addressBook=new ArrayList<Contact>();
	static Scanner sc=new Scanner(System.in);
	
	public static void searchPersonInAState(String city){
		List<Contact> matchingobj=new ArrayList<Contact>();
		for(List<Contact> li:shelf.values()) {
			matchingobj=li.stream()
				  .filter(a->a.getAddress().equals(city))
				  .collect(Collectors.toList());
		}
		System.out.println("Contacts from "+city+" are :");
		for(Contact c:matchingobj) {
			System.out.println(c.getFirstName()+c.getLastName());
		}
	}
	
	public static void main(String[] args) {
		boolean exit = true;
		while(exit) {
			System.out.println("\nMenu");
			System.out.println("1.Add Address Book to Shelf");
			System.out.println("2.Display names of all address books in shelf");
			System.out.println("3.Display contacts by City/State across multiple Address Books");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			int check=Integer.parseInt(sc.nextLine());
			switch(check){
				case 1:
					boolean a=true;
					String name="";
					while(a) {
						System.out.println("\nEnter the name for Address Book:");
						name=sc.nextLine();
						if(shelf.containsKey(name)) {
							System.out.println("Key already exists.");
						} 
						else {
							addressBook = abm.addressBookCreator();
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
					System.out.println("Enter City name to search contacts");
					String city= sc.nextLine();
					searchPersonInAState(city);
					break;
				case 4:
					exit=false;
					break;
					
				default:
					System.out.println("Enter either 1 or 2 or 3");
			}
		}
	}
}
