package Controller.Library.Service.Library;

import Object.Library.Customer;
import Object.Library.Librarian;
import View.Library.MainScreen;
import View.Library.RegisterScreen;

import java.util.UUID;

public class RegisterService {
    private static LibraryService service = LibraryService.getInstance();
    public static void RegisterProperty(String answer){
        switch (answer){
            case "1":
                RegisterScreen.librarianRegister();
                break;
            case "2":
                RegisterScreen.customerRegister();
                break;
            case "3":
                MainScreen.homeScreen();
            case "4":
                MainScreen.exitCase();

                default:
                    MainScreen.defaultCase();
        }
    }

    public static void librarianCheck(String[] account){
        passwordCheck(account);
        Librarian newLibrarian = new Librarian();
        for (Librarian librarian : service.getLibrarianListDetail().getLibrarians()){
            if (librarian.getFirstName().equals(account[0]) && librarian.getLastName().equals(account[1])){
                RegisterScreen.accountError();
            }
            else if (librarian.getIdentity().equals(account[2])){
                RegisterScreen.identityError();
            }else {
                newLibrarian.setUuid(UUID.randomUUID());
                newLibrarian.setFirstName(account[0]);
                newLibrarian.setLastName(account[1]);
                newLibrarian.setIdentity(account[2]);
                newLibrarian.setPassword(account[3]);
                service.getLibrarianListDetail().getLibrarians().add(newLibrarian);
            }
        }
        RegisterScreen.registerSuccess();
        MainScreen.homeScreen();
    }

    public static void customerCheck(String[] account){
        passwordCheck(account);
        Customer newCustomer = new Customer();
        for (Customer customer : service.getCustomerListDetail().getCustomers()){
            if (customer.getFirstName().equals(account[0]) && customer.getLastName().equals(account[1])){
                RegisterScreen.accountError();
            }
            else if (customer.getIdentity().equals(account[2])){
                RegisterScreen.identityError();
            }else {
                newCustomer.setUuid(UUID.randomUUID());
                newCustomer.setFirstName(account[0]);
                newCustomer.setLastName(account[1]);
                newCustomer.setIdentity(account[2]);
                newCustomer.setPassword(account[3]);
                service.getCustomerListDetail().getCustomers().add(newCustomer);
            }
        }
        RegisterScreen.registerSuccess();
        MainScreen.homeScreen();
    }

    private static void passwordCheck(String[] account){
        if (!account[3].equals(account[4])){
            RegisterScreen.passwordError();
        }
        MainScreen.homeScreen();
    }
}
