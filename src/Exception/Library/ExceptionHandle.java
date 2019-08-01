package Exception.Library;

import View.Library.MainScreen;

public class ExceptionHandle {
    public static void excecptionIllegalArgument(){
        System.out.println("Error, your category doesn't exist");
        MainScreen.homeScreen();
    }
}
