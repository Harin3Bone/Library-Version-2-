package View.Library;

import Controller.Library.Service.Library.CustomerService;
import Controller.Library.Service.Library.LibraryService;

import java.util.Scanner;

public class CustomerScreen {
    private static LibraryService service = LibraryService.getInstance();

    public static void searchDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your search type");
        System.out.println("1 - Search by name\n2 - Search by Category\n3 - Search by Code");
        CustomerService.searchBookCusProperty(scanner.nextLine());
    }

    public static void searchNameCusDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book name to search : ");
        CustomerService.searchByName(scanner.nextLine());
    }

    public static void searchCateCusDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book category to search : ");
        CustomerService.searchByCategory(scanner.nextLine());
    }

    public static void searachCodeCusDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code to search : ");
        CustomerService.searchByCode(scanner.nextLine());
    }

    public static void checkDisplay() {
        CustomerService.checkBook();
    }

    public static void borrowDisplay() {
        String bookCode = inputBook();
        CustomerService.borrowBook(bookCode);
    }

    public static void returnDisplay() {
        String bookCode = inputBook();
        CustomerService.returnBook(bookCode);
    }

    public static void changeDisplay() {
        String bookCode = inputBook();
        CustomerService.changeBook(bookCode);
    }

    public static int changeCusDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your number to change return date : ");
        return scanner.nextInt();
    }

    private static String inputBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code : ");
        return scanner.nextLine();
    }

    public static void notFoundBook(){
        System.out.println("Your book it doesn't exist");
        MainScreen.customerScreen();
    }

    public static void searchCusShow() {
        System.out.println("==========================");
        System.out.println("Book Name   : " + service.getBookDetail().getBookName());
        System.out.println("Book Type   : " + service.getBookDetail().getBookCategory());
        System.out.println("Book Code   : " + service.getBookDetail().getBookCode());
        System.out.println("Book Status : " + service.getBookDetail().getBookStatus());
        service.setBookDetail(null);
    }
}
