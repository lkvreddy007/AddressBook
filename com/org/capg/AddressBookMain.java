package com.org.capg;

import java.util.*;

public class AddressBookMain extends Contact{
	private List<Contact> addressBook=new ArrayList<Contact>();
	static Scanner sc = new Scanner(System.in); 
	
	public void addContact(Contact obj) {
		this.addressBook.add(obj);
		System.out.println("Contact added to Address Book");
	}
	
	public void editContactGivenLastName(String lastName) {
		boolean exitFlag=true;
		System.out.println("Entered edit section");
		for(Contact c:addressBook) {
			if(c.getLastName().equals(lastName)) {
				while(exitFlag) {	
					System.out.println("To edit enter Number:\n 1.firstName\n 2.lastName\n 3.address\n 4.zip\n 5.phoneNo\n 6.email\n 7.exit");
					int check=Integer.parseInt(sc.nextLine());
					switch (check) {
						case 1:
							System.out.println("Enter First Name:");
							String firstname = sc.nextLine();
							c.setFirstName(firstname);
							break;
						
						case 2:
							System.out.println("Enter Last Name:");
							String lastname = sc.nextLine();
							c.setLastName(lastname);
							break;
						
						case 3:
							System.out.println("Enter the Address:");
							String addr = sc.nextLine();
							c.setAddress(addr);
							break;
						
						case 4:
							System.out.println("Enter Zip:");
							String zipcode = sc.nextLine();
							c.setZip(zipcode);
							break;
						
						case 5:
							System.out.println("Enter Phone Number:");
							String phone = sc.nextLine();
							c.setPhoneNo(phone);
							break;
						
						case 6:
							System.out.println("Enter Email Id:");
							String mail = sc.nextLine();
							c.setEmail(mail);
							break;
						case 7:
							System.out.println("Exiting edit section");
							exitFlag=false;
					}
				}
				System.out.println("Contact details after edit are: ");
				displayContact(c);
				return;
			}
		}
		System.out.println("Contact with "+lastName+" doesnot exist.");
	}
	
	public void displayContact(Contact obj) {
		System.out.println("First Name: "+obj.getFirstName());
		System.out.println("Last Name: "+obj.getLastName());
		System.out.println("Address: "+obj.getAddress());
		System.out.println("Zip: "+obj.getZip());
		System.out.println("Phone Number: "+obj.getPhoneNo());
		System.out.println("Email Id: "+obj.getEmail());
	}
	
	public boolean removeContact(String lastname) {
		for(Contact c:addressBook) {
			if(lastname.equals(c.getLastName())) {
				addressBook.remove(c);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		AddressBookMain abm=new AddressBookMain();
		String firstName,lastName,address,zip,phoneNo,email;
		System.out.println("Welcome to Address Book");

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
		System.out.println("Contact Details you have entered are: ");
		abm.displayContact(con);
		
		
		System.out.println("Enter the lastname of contact to edit: ");
		String lname=sc.nextLine();
		abm.editContactGivenLastName(lname);
		
		System.out.println("Enter the lastname of contact to delete: ");
		String delLastname=sc.nextLine();
		boolean b=abm.removeContact(delLastname);
		if(b) {
			System.out.println("Contact Deleted.");
		}
	}
}
