package View.Library;

import Controller.Library.Service.Library.LoginService;

import java.util.Scanner;

public class LoginScreen {

    public static void librarianLoginView(){
        String account[] = loginTemplate();
        LoginService.librarianLogin(account[0],account[1]);
    }

    public static void customerLoginView(){
        String account[] = loginTemplate();
        LoginService.customerLogin(account[0],account[1]);
    }

    public static String[] loginTemplate(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("Password : ");
        String ps = scanner.nextLine();
        String account[] = {id,ps};
        return account;
    }
}
