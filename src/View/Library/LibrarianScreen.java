package View.Library;

import Controller.Library.Service.Library.LibrarianService;
import Controller.Library.Service.Library.LibraryService;
import Object.Library.Book;

import java.util.Scanner;

public class LibrarianScreen {
    private static LibraryService service = LibraryService.getInstance();

    public static void addDisplay() {
        Scanner scanner = new Scanner(System.in);                                   // Create scanner to get input //
        System.out.print("Please enter book name : ");
        String name = scanner.nextLine();
        System.out.print("Please enter book category : ");
        String category = scanner.nextLine();
        System.out.print("Please enter book author : ");
        String author = scanner.nextLine();
        System.out.print("Please enter book abstract : ");
        String abstracts = scanner.nextLine();
        String[] bookValue = {name, category, author, abstracts};
        LibrarianService.addBook(bookValue);
    }

    public static void removeDisplay() {
        String bookValue = inputBook();
        LibrarianService.removeBook(bookValue);
    }

    public static void searchDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your search type");
        System.out.println("1 - Search by name\n2 - Search by Category\n3 - Search by Code");
        LibrarianService.searchBookLibProperty(scanner.nextLine());
    }

    public static void searchNameLibDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book name to search : ");
        LibrarianService.searchByName(scanner.nextLine());
    }

    public static void searchCateLibDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book category to search : ");
        LibrarianService.searchByCategory(scanner.nextLine());
    }

    public static void searchCodeLibDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your book code to search : ");
        LibrarianService.searchByCode(scanner.nextLine());
    }

    public static void searchShow() {
        System.out.println("==========================");
        System.out.println("Book Name   : " + service.getBookDetail().getBookName());
        System.out.println("Book Type   : " + service.getBookDetail().getBookCategory());
        System.out.println("Book Code   : " + service.getBookDetail().getBookCode());
        System.out.println("Book Status : " + service.getBookDetail().getBookStatus());
        service.setBookDetail(null);
    }

    public static void checkDisplay() {
        LibrarianService.checkBook();
    }

    public static void historyDisplay() {
        LibrarianService.historyBook();
    }

    public static void sortDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please use sorting function");
        System.out.println("1 - Sort by Name\n2 - Sort by Category\n3 - Sort by Serial\n4 - Sort by Status");
        LibrarianService.sortBook(scanner.nextLine());
    }

    public static void sortShow() {
        for (Book sort : service.getBookListDetail().getBooks()) {
            System.out.println(sort);                                                   // Display book after sorting //
        }
    }

    public static void confirmDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your property");
        System.out.println("1 - Approve\t2 - Accept");
        LibrarianService.confirmBook(scanner.nextLine());
    }

    public static void approveDisplay() {
        String bookCode = inputBook();
        LibrarianService.approveBook(bookCode);
    }

    public static void accpetDisplay() {
        String bookCode = inputBook();
        LibrarianService.acceptBook(bookCode);
    }

    public static void changeDisplay() {
        String bookCode = inputBook();
        LibrarianService.changeBook(bookCode);
    }

    public static int changeLibDate() {
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
        MainScreen.librarianScreen();
    }

}
