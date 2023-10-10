package User_Management;

        import java.util.Scanner;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.io.IOException;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.BufferedReader;
	import java.io.FileWriter;
	import java.io.BufferedWriter;

	              public class UserManagement {
				
			static ArrayList<User> al = new ArrayList();
			static
			{
				try {
					loadDataFromFileToArrayList();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			public static void UserManagment() throws IOException
			{
				Scanner scan = new Scanner(System.in);
				boolean CanIKeepRunTheProgram = true;
				while(CanIKeepRunTheProgram == true )
				{
					System.out.println(" ***WELCOME TO USER MANAGMENT* ");
					System.out.println(" 1.Add User ");
					System.out.println(" 2.Edit User ");
					System.out.println(" 3.Search User ");
					System.out.println(" 4.Delete User ");
					System.out.println(" 5.Quit ");
					
					int optionselectedbyuser = scan.nextInt();
					if(optionselectedbyuser == UserOptions.QUIT)
					{
						File file = new File("C:\\Users\\pandi\\eclipse-workspace\\AddressBook\\src\\User_Management\\User.txt");
						
						FileWriter fr = new FileWriter(file);
						
						BufferedWriter br = new BufferedWriter(fr);
						
						for(User u1:al)
						{
							br.write(u1.userName+","+u1.loginName+","+u1.password+","+u1.userRole+"\n");
						}
						br.close();
						file = null;
						System.out.println(" !!!! PROGRAM CLOSED !!!! ");
						CanIKeepRunTheProgram = false;
					}
					else if(optionselectedbyuser == UserOptions.ADD_USER)
					{
						Adduser();
					}
					else if(optionselectedbyuser == UserOptions.SEARCH_USER)
					{
						System.out.println(" Enter the user name to search : ");
						scan.nextLine();
						String searchuser = scan.nextLine();
						Search(searchuser);
					}
					else if(optionselectedbyuser == UserOptions.EDIT_USER)
					{
						System.out.println(" Enter the user name to edit : ");
						scan.nextLine();
						String edituser = scan.nextLine();
						Edit(edituser);
					}
					else if(optionselectedbyuser == UserOptions.DELETE_USER)
					{
						System.out.println(" Enter the user name to delete : ");
						scan.nextLine();
						String deleteuser = scan.nextLine();
						Delete(deleteuser);
					}
				}
				System.out.println(" *After While Loop *");
				for(int i=0;i<al.size();i++)
				{
					System.out.println(al.get(i).userName);
					System.out.println(al.get(i).loginName);
					System.out.println(al.get(i).password);
					System.out.println(al.get(i).conformPassword);
					System.out.println(al.get(i).userRole);
				}
			}
			public static void Adduser()
			{
				Scanner scan = new Scanner(System.in);
				User u1 = new User();
				
				System.out.println(" Enter the User Name : ");
				u1.userName = scan.nextLine();
				System.out.println(" Enter the Login Name : ");
				u1.loginName = scan.nextLine();
				System.out.println(" Enter the Password : ");
				u1.password = scan.nextLine();
				System.out.println(" Enter the Confirm Password : ");
				u1.conformPassword = scan.nextLine();
				System.out.println(" Enter the User Role : ");
				u1.userRole = scan.nextLine();
				
				al.add(u1);
			}
			public static void Search (String searchuser)
			{
				for(User u1:al)
				{
					if(u1.userName.equalsIgnoreCase(searchuser))
					{
						System.out.println(u1.userName);
						System.out.println(u1.loginName);
						System.out.println(u1.password);
						System.out.println(u1.conformPassword);
						System.out.println(u1.userRole);
						return;
						
					}
				}
				System.out.println(" USER NOT FOUND ");
			}
			public static void Edit (String edituser)
			{
				for(User u1:al)
				{
					if(u1.userName.equalsIgnoreCase(edituser))
					{
						Scanner scan = new Scanner(System.in);
						System.out.println(" Editing User Is : "+u1.userName);
						
						System.out.println(" New User Name is :");
						u1.userName = scan.nextLine();
						System.out.println(" New Login Name is : ");
						u1.loginName = scan.nextLine();
						System.out.println(" New Password is : ");
						u1.password = scan.nextLine();
						System.out.println(" New Confirm Password is : ");
						u1.conformPassword = scan.nextLine();
						System.out.println(" New User Role is : ");
						u1.userRole = scan.nextLine();
						
						System.out.println(" INFORMATION UPDATED ");
						return;
					}
				}
			}
			public static void Delete(String deleteuser)
			{
				Iterator<User>itr = al.iterator();
				while(itr.hasNext())
				{
					User u1 = itr.next();
					if(u1.userName.equalsIgnoreCase(deleteuser))
					{
						itr.remove();
						System.out.println(" User "+u1.userName+" has been deleted ");
						return;
					}
				}
				System.out.println(" USER NOT FOUND ");
			}
			public static void loadDataFromFileToArrayList() throws IOException
			{
				File file = new File("C:\\Users\\pandi\\eclipse-workspace\\AddressBook\\src\\User_Management\\User.txt");
				
				FileReader fr = new FileReader(file);
				
				BufferedReader br = new BufferedReader(fr);
				String line ="";
				
				while((line = br.readLine())!=null)
				{
				   User u1 = new User();
				   
				   String[] userDataArray = line.split(",");
				   
				   if(userDataArray.length>3)
				   {
					   u1.userName = userDataArray[0];
					   u1.loginName = userDataArray[1];
					   u1.password = userDataArray[2];
					   u1.userRole = userDataArray[3];
					   
					   al.add(u1);
				   }
				}
				br.close();
				fr.close();
				file = null;
			}
			public static boolean validateUserandPassword(String login ,String password)
			{
				 Iterator<User>itr = al.iterator();
				 while(itr.hasNext())
				 {
					 User u1 = itr.next();
					 if(u1.loginName.equalsIgnoreCase(login)&&u1.password.equalsIgnoreCase(password))
					 {
						 return true;
					 }
				 }
				 return false;
			 }
			
}
