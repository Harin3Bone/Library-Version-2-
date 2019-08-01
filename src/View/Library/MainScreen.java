package View.Library;

import Controller.Library.Service.Library.CustomerService;
import Controller.Library.Service.Library.LibrarianService;
import Controller.Library.Service.Library.LibraryService;
import Controller.Library.Service.Library.LoginService;

import java.util.Scanner;

public class MainScreen {
    public static void homeScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your property");
        System.out.println("1 - Login\t2 - register\t3 - Exit");
        String answer = scanner.nextLine();
        LoginService.ansProperty(answer);
    }
    
    public static void loginChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your level");
        System.out.println("1 - Librarian\t2 - Customer\t3 - Back");
        LoginService.ansLogin(scanner.nextLine());
    }

    public static void librarianScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("What do you want to do ?");
        System.out.println("1 - Add Book\t2 - Delete Book\t3 - Search\n4 - Check\t\t" +
                "5 - History \t6 - Sort\n7 - Confirm\t\t8 - Change\t\t9 - Back\n0 - Exit");
        String property = scanner.nextLine();
        LibrarianService.librarianProperty(property);

    }
    public static void customerScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("What do you want to do ?");
        System.out.println("1 - Search\t2 - Check\t3 - Borrow\n4 - Return\t5 - Change\t6 - Back" +
                "\n0 - Exit");
        CustomerService.customerProperty(scanner.nextLine());
    }

    // Exit
    public static void exitCase() {
        System.out.println("Thank you");
        System.out.println("================================");
        System.exit(0);
    }

    // Default
    public static void defaultCase() {
        System.out.println("Error, your input doesn't exist");
        System.out.println("================================");
        System.exit(0);
    }

    // Error
    public static void errorCase(){
        System.out.println("Error, Please try again");
        System.out.println("================================");
        System.exit(0);
    }
}
