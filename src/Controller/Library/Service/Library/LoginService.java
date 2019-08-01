package Controller.Library.Service.Library;

import Initialize.Library.Main;
import Object.Library.Customer;
import Object.Library.Librarian;
import View.Library.LoginScreen;
import View.Library.MainScreen;
import View.Library.RegisterScreen;

public class LoginService {
    private static LibraryService service = LibraryService.getInstance();

    public static void ansProperty(String answer) {
        switch (answer) {
            case "1":
                MainScreen.loginChoice();
                break;
            case "2":
                RegisterScreen.registerDisplay();
                break;
            case "3":
                System.exit(0);
            default:
                MainScreen.defaultCase();
        }
    }

    public static void ansLogin(String answer){
        switch (answer){
            case "1":
                LoginScreen.librarianLoginView();
                break;
            case "2":
                LoginScreen.customerLoginView();
                break;
            case "3":
                MainScreen.homeScreen();
            default:
                MainScreen.defaultCase();
        }
    }

    public static void librarianLogin(String id, String ps) {
        Boolean userFound = false;
        for (Librarian librarian : service.getLibrarianListDetail().getLibrarians()) {
            if (librarian.getIdentity().equals(id) && librarian.getPassword().equals(ps)) {
                userFound = true;
                service.setLibrarianDetail(librarian);
                MainScreen.librarianScreen();
            }
        }
        userCheck(userFound);
    }

    public static void customerLogin(String id, String ps) {
        Boolean userFound = false;
        for (Customer customer : service.getCustomerListDetail().getCustomers()) {
            if (customer.getIdentity().equals(id) && customer.getPassword().equals(ps)) {
                userFound = true;
                service.setCustomerDetail(customer);
                MainScreen.customerScreen();
            }
        }
        MainScreen.customerScreen();
    }

    private static void userCheck(Boolean userFound){
        if (!userFound) {
            MainScreen.errorCase();
        }
    }
}
