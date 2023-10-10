package Main_Application;

    import java.io.IOException;
	import java.util.Scanner;
    import AddressBook_Management.AddressBookManagement;


	public class Login {

				public static void main(String args[]) throws IOException {
					
					Scanner scanner = new Scanner (System.in);

				boolean canIKeepRunningTheProgram = true; 
				
				System.out.println("** Welcome to Address Book**");
				
				System.out.println("Enter The Login Name : ");
				String LoginName = scanner.nextLine();
				System.out.println("Enter The Password : ");
				String Password = scanner.nextLine();
				
				if(!User_Management.UserManagement.validateUserandPassword(LoginName, Password))
				{
					System.out.println("Login Failed!!");
					return;
				}
				
				while (canIKeepRunningTheProgram == true) { 
					
					System.out.println("* Welcome to Address Book Management *");
					System.out.println("\n");
					System.out.println("What would you like to do ?");
					System.out.println("1.User Management");
					System.out.println("2.AddressBook Management");
					System.out.println("3.Quit");
					
					int optionSelectedByUser = scanner.nextInt();

					if (optionSelectedByUser == 1) {
						User_Management.UserManagement.UserManagment();
						
					}else if (optionSelectedByUser == 2) {
						AddressBookManagement.AddressBookManagement();
					}else if (optionSelectedByUser == 3) {
						break;
					}
				}
				}

}
