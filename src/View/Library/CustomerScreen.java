package View.Library;

import Controller.Library.Service.Library.LibraryService;

import java.util.Scanner;

public class CustomerScreen {
    private static LibraryService service = LibraryService.getInstance();

    public static void searchDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your search type");
        System.out.println("1 - Search by name\n2 - Search by Category\n3 - Search by Code");
        LibraryService.searchBookProperty(scanner.nextLine());
    }

    public static void searchNameCusDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book name to search : ");
        LibraryService.searchByName(scanner.nextLine());
    }

    public static void searchCateCusDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book category to search : ");
        LibraryService.searchByCategory(scanner.nextLine());
    }

    public static void searachCodeCusDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code to search : ");
        LibraryService.searchByCode(scanner.nextLine());
    }

    public static void checkDisplay() {
        LibraryService.checkBook();
    }

    public static void borrowDisplay() {
        String bookCode = inputBook();
        LibraryService.borrowBook(bookCode);
    }

    public static void returnDisplay() {
        String bookCode = inputBook();
        LibraryService.returnBook(bookCode);
    }

    public static void changeDisplay() {
        String bookCode = inputBook();
        LibraryService.changeBook(bookCode);
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


}
