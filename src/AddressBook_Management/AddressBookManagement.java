package AddressBook_Management;

import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
		import java.util.Iterator;
		import java.util.Scanner;
		

		public class AddressBookManagement {
		
					
			static ArrayList<AddressBook> al = new ArrayList();
			static
			{
				try {
					loadDataFromFileToArrayList();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			public static void AddressBookManagement() throws IOException {
			{
				Scanner scan = new Scanner(System.in);
				boolean CanIKeepRunningTheProgram = true;
				while(CanIKeepRunningTheProgram == true )
				{		
							System.out.println("* Welcome to AddressBook Management *");
							System.out.println("\n");
							System.out.println("What would you like to do ?");
							System.out.println("1.Add Contact");
							System.out.println("2.Edit Contact");
							System.out.println("3.Delete Contact");
							System.out.println("4.Search Contact");
							System.out.println("5.Quit");
							
							int optionSelectedByUser = scan.nextInt();
							if (optionSelectedByUser == AddressBookOptions.QUIT) {
								
								
								File file = new File("C:\\Users\\pandi\\eclipse-workspace\\AddressBook\\src\\AddressBook_Management\\Address.txt");
								
								FileWriter fr = new FileWriter(file,false);
								
								BufferedWriter br = new BufferedWriter(fr);
								
								for(AddressBook u1:al)
								{
									br.write(u1.number+","+u1.name+","+u1.email+"\n");
								}
								
								br.close();
								file=null;
								
								System.out.println(" !!!! PROGRAM CLOSED !!!! ");
					
							CanIKeepRunningTheProgram = false;
							
							} else if (optionSelectedByUser ==AddressBookOptions.ADD_CONTACT) {
								AddAddressBook();
								System.out.println("\n");
							} else if (optionSelectedByUser == AddressBookOptions.SEARCH_Contact) {
								System.out.println("Enter Contact Number to search: "); // search user
								scan.nextLine(); //consume the newline character left from previous input 
								String searchContact = scan.nextLine();
								String searchContact1 = null;
								SearchAddressBook(searchContact1);
							} else if (optionSelectedByUser == AddressBookOptions.DELETE_Contact) {
								System.out.println("enter Contact Number to delete: "); //delete user
								scan.nextLine(); // consume the newline character left from previous input 
								String deleteContact = scan.nextLine();
								DeleteAddressBook(deleteContact);
								System.out.println("\n");
							} else if (optionSelectedByUser == AddressBookOptions.EDIT_Contact) {
								System.out.println("Enter Contact Number to edit: "); // edit user
								scan.nextLine(); //consume the newline character left from previous input 
								String editContact = scan.nextLine();
								EditAddressBook(editContact);
								System.out.println("\n");
							}
						}
						System.out.println("\n");
						System.out.println("#### After While Loop ###");
						for(int i=0;i<al.size();i++) {
							System.out.println(al.get(i).number);
							System.out.println(al.get(i).name);
							System.out.println(al.get(i).email);
						}
					}
			}
			
				//* Add User Function *
					public static void AddAddressBook() {
						Scanner scan = new Scanner(System.in);
						AddressBook u1 = new AddressBook();
						
						System.out.println("Enter Contact_Number: ");
						u1.number = scan.nextLine();
						
						System.out.println("Enter Contact_Name: ");
						u1.name = scan.nextLine();
						
						System.out.println("Enter Contact_email: ");
						u1.email = scan.nextLine();
						
						System.out.println("Contact Number is :"+u1.number);
						System.out.println("Contact Name is :"+u1.name);
						System.out.println("Contact email is :"+u1.email);
						
						al.add(u1);
					}
					
					//** Search Contact Function ***
					public static void SearchAddressBook(String Tasknumber) {
						for(AddressBook u1:al) {
							if(u1.number.equalsIgnoreCase(Tasknumber)) {
								System.out.println("Contact Number is :"+u1.number);
								System.out.println("Contact Name is :"+u1.name);
								System.out.println("Contact email is :"+u1.email);
										
								return;
							}
						}
						System.out.println("!!! Contact Not Found !!!");
						
					}
					
					//** Edit Contact Function *
					public static void EditAddressBook(String Contactnumber) {
						for(AddressBook u1:al) {
							if(u1.number.equalsIgnoreCase(Contactnumber)) {
								Scanner scan = new Scanner(System.in);
								
								System.out.println("Enter Contact_Number: "+u1.number);
								
								System.out.println("New Contact_Name is: ");
								u1.name = scan.nextLine();
								
								System.out.println("New Contact_Number is: ");
								u1.number = scan.nextLine();
								
								System.out.println("New Contact_email is: ");
								u1.email = scan.nextLine();

								System.out.println("Contact Information updated");
								return;
							}
						}
						System.out.println("!!! Contact Not Found !!!");
					}
					
					//** Delete Contact Function **
					
					public static void DeleteAddressBook(String Contactnumber) {
						Iterator<AddressBook> itr1 = al.iterator();
						while(itr1.hasNext()) {
							AddressBook u1= itr1.next();
							if(u1.number.equalsIgnoreCase(Contactnumber)) {
								itr1.remove();
								System.out.println("Contact "+u1.number+"has been deleted");
								break;
							}
						}
						System.out.println("!!! Contact Not Found !!!");

					}
					
					
					public static void loadDataFromFileToArrayList() throws IOException
					{
			            File file = new File("C:\\Users\\pandi\\eclipse-workspace\\AddressBook\\src\\AddressBook_Management\\Address.txt");
						
						FileReader fr = new FileReader(file);
						
						BufferedReader br = new BufferedReader(fr);
						
						String line = "";
						
						while((line = br.readLine())!=null)
						{
							AddressBook u1 = new AddressBook();
			               
			               String[] userDataArray=line.split(",");
			               
			               if(userDataArray.length>4)
			               {
			               u1.number=userDataArray[0];
			               u1.name=userDataArray[1];
			               u1.email=userDataArray[2];
			               
			               al.add(u1);
			   
						
						}
							
							br.close();
							fr.close();
							file=null;
					}
					
					}	
					
				}

