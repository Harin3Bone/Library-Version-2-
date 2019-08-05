package View.Library;

import Controller.Library.Service.Library.RegisterService;

import java.util.Scanner;

public class RegisterScreen {
    public static void registerDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your level to registration");
        System.out.println("1 - Librarian\t2 - Customer\n3 - Back\t\t4 - Exit");
        RegisterService.RegisterProperty(scanner.nextLine());
    }

    public static void librarianRegister() {
        String[] account = registerTemplate();
        RegisterService.librarianCheck(account);
    }

    public static void customerRegister() {
        String[] account = registerTemplate();
        RegisterService.customerCheck(account);
    }

    private static String[] registerTemplate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your firstname : ");
        String firstname = scanner.nextLine();
        System.out.print("Enter your lastname : ");
        String lastname = scanner.nextLine();
        System.out.print("Enter your username : ");
        String username = scanner.nextLine();
        System.out.print("Enter your password : ");
        String password1 = scanner.nextLine();
        System.out.print("Re-Enter your password : ");
        String password2 = scanner.nextLine();
        String account[] = {firstname,lastname,username,password1,password2};
        return account;
    }

    public static void passwordError(){
        System.out.println("Error, your password doesn't same");
        registerDisplay();
    }

    public static void accountError(){
        System.out.println("Error, your name was registered");

    }

    public static void identityError(){
        System.out.println("Error, your username has benn used");
    }

    public static void registerSuccess(){
        System.out.println("Your registration successful");
    }
}
