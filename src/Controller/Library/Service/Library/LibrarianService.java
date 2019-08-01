package Controller.Library.Service.Library;

import Enum.Library.BookCategory;
import Enum.Library.BookSituation;
import Enum.Library.BookStatus;
import Exception.Library.ExceptionHandle;
import Object.Library.Book;
import Object.Library.History;
import View.Library.CustomerScreen;
import View.Library.LibrarianScreen;
import View.Library.MainScreen;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

public class LibrarianService {
    private static LibraryService service = LibraryService.getInstance();

    public static void librarianProperty(String answer){
        switch (answer) {
            case "1":
                LibrarianScreen.addDisplay();
                break;
            case "2":
                LibrarianScreen.removeDisplay();
                break;
            case "3":
                LibrarianScreen.searchDisplay();
                break;
            case "4":
                LibrarianScreen.checkDisplay();
                break;
            case "5":
                LibrarianScreen.historyDisplay();
                break;
            case "6":
                LibrarianScreen.sortDisplay();
                break;
            case "7":
                LibrarianScreen.confirmDisplay();
                break;
            case "8":
                LibrarianScreen.changeDisplay();
                break;
            case "9":
                service.setLibrarianDetail(null);
                MainScreen.homeScreen();
                break;
            case "0":
                MainScreen.exitCase();
            default:
                MainScreen.defaultCase();
        }
    }

    public static void addBook(String[] bookValue) {
        Book book = new Book();

        try {
            String code = GenerateCode(bookValue[1]);
            book.setBookCode(code);
        } catch (IllegalArgumentException ignored) {
            ExceptionHandle.excecptionIllegalArgument();
        }

        book.setUuid(UUID.randomUUID());
        book.setBookName(bookValue[0]);
        book.setBookCategory(BookCategory.valueOf(bookValue[1]));
        book.setBookAuthor(bookValue[2]);
        book.setBookabstract(bookValue[3]);
        book.setBookStatus(BookStatus.Available);

        service.getBookListDetail().getBooks().add(book);
        checkBook();
        MainScreen.librarianScreen();
    }

    private static String GenerateCode(String bookCategory){
        String CategoryCode = BookCategory.valueOf(bookCategory).getCode();             // Pull code (String) from category enum
        DecimalFormat decimalFormat = new DecimalFormat("0000");                // DecimalFormat change display value from 1 to 0001

        Integer runningNo = null;
        if (service.getBookListDetail().getBooks().size() != 0) {
            for (Book b : service.getBookListDetail().getBooks()) {
                if (CategoryCode.equals(b.getBookCode().substring(0, 1))) {
                    if (runningNo == null || runningNo < Integer.parseInt(b.getBookCode().substring(1))) {
                        runningNo = Integer.parseInt(b.getBookCode().substring(1));
                    }
                } else {
                    if (runningNo == null) {
                        runningNo = 0;
                    }
                }
            }
        } else {
            runningNo = 0;
        }
        runningNo = runningNo + 1;
        String code = CategoryCode + decimalFormat.format(runningNo);
        return code;
    }

    public static void removeBook(String bookValue) {
        Book book = new Book();
        Iterator<Book> iterator = service.getBookListDetail().getBooks().iterator();
        while (iterator.hasNext()) {
            book = iterator.next();
            if (book.getBookCode().equals(bookValue)) {
                // Condition check book code if same as input -> continue //
                // when condition is true -> remove 1 record //
                iterator.remove();
                System.out.println("Book code : " + book.getBookCode() + " remove successful");
                checkBook();

            } else {
                if (book.getBookCode().equalsIgnoreCase(bookValue)) {
                    System.out.println("Sorry your book code is not exist");
                    MainScreen.librarianScreen();
                }
            }
        }
    }

    public static void searchBookLibProperty(String answer) {
        switch (answer) {
            case "1":
                LibrarianScreen.searchNameLibDisplay();
                break;
            case "2":
                LibrarianScreen.searchCateLibDisplay();
                break;
            case "3":
                LibrarianScreen.searchCodeLibDisplay();
                break;

                default:
                    MainScreen.errorCase();
                    LibrarianScreen.searchDisplay();
        }
        MainScreen.librarianScreen();
    }

    public static void searchByName(String bookName){
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                service.setBookDetail(book);
                LibrarianScreen.searchShow();
            }
        }
    }

    public static void searchByCategory(String bookCategory){
        try {
            for (Book book : service.getBookListDetail().getBooks()) {
                if (book.getBookCategory().equals(BookCategory.valueOf(bookCategory))) {
                    service.setBookDetail(book);
                    LibrarianScreen.searchShow();
                }
            }
        } catch (IllegalArgumentException ignored) {

        }
    }

    public static void searchByCode(String bookCode){
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookCode().equalsIgnoreCase(bookCode)) {
                service.setBookDetail(book);
                LibrarianScreen.searchShow();
            }
        }
    }

    public static void checkBook() {
        System.out.println("================================");
        for (int i = 0; i < service.getBookListDetail().getBooks().size(); i++) {
            System.out.println("Book Detail " + (i + 1) + " : " + service.getBookListDetail().getBooks().get(i));
        }
        MainScreen.librarianScreen();
    }

    public static void historyBook() {
        System.out.println("================================");
        for (int i = 0; i < service.getHistoryListDetail().getHistories().size(); i++) {
            System.out.println("History Detail " + (i + 1) + " : " + service.getHistoryListDetail().getHistories().get(i));
        }
        MainScreen.librarianScreen();
    }

    public static void sortBook(String answer) {
        switch (answer){
            case "1":
                sortByName();
                break;
            case "2":
                sortByCategory();
                break;
            case "3":
                sortByCode();
                break;
            case "4":
                sortByStatus();
                break;

            default:
                MainScreen.defaultCase();
        }
    }

    private static void sortByName(){
        service.getBookListDetail().getBooks().sort(Book.bookNameCompare);
        LibrarianScreen.sortShow();
        MainScreen.librarianScreen();
    }

    private static void sortByCategory(){
        service.getBookListDetail().getBooks().sort(Book.bookCategoryCompare);
        LibrarianScreen.sortShow();
        MainScreen.librarianScreen();
    }

    private static void sortByCode(){
        service.getBookListDetail().getBooks().sort(Book.bookCodeCompare);
        LibrarianScreen.sortShow();
        MainScreen.librarianScreen();
    }

    private static void sortByStatus(){
        service.getBookListDetail().getBooks().sort(Book.bookStatusCompare);
        LibrarianScreen.sortShow();
        MainScreen.librarianScreen();
    }

    public static void confirmBook(String answer) {
        if (answer.equals("1")) {
            LibrarianScreen.approveDisplay();
        } else {
            if (answer.equals("2")) {
                LibrarianScreen.accpetDisplay();
            }
        }
    }

    public static void approveBook(String bookCode) {
        boolean found = false;
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookCode().equalsIgnoreCase(bookCode)) {
                if (book.getBookStatus().equals(BookStatus.Unvailable)) {
                    found = true;
                    for (History history : service.getHistoryListDetail().getHistories()) {
                        // Value set
                        if (history.getBookCode().equals(bookCode) && history.getBookSituation().equals(BookSituation.Wait_Approve)) {
                            history.setBookSituation(BookSituation.Borrow);
                            history.setDayBorrow(LocalDate.now());
                            history.setDayReturn(LocalDate.now().plusDays(7));
                            history.setLibrarianName(service.getLibrarianDetail().getFirstName());
                        }
                        else {
                            found = false;
                        }
                    }
                    // Display book history
                    historyBook();
                }
            }
        }
        bookFoundCheck(found);
        MainScreen.librarianScreen();
    }

    public static void acceptBook(String bookCode) {
        boolean found = false;
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookCode().equalsIgnoreCase(bookCode)) {
                found = true;
                if (book.getBookStatus().equals(BookStatus.Unvailable)) {
                    // Status change
                    book.setBookStatus(BookStatus.Available);
                    for (History history : service.getHistoryListDetail().getHistories()) {
                        // Value set
                        if (history.getBookCode().equals(bookCode) && history.getBookSituation().equals(BookSituation.Wait_Accept)) {
                            history.setLibrarianName(service.getLibrarianDetail().getFirstName());
                            history.setBookSituation(BookSituation.Return);
                        }
                    }
                    // Display book history
                    System.out.println("\nYour work has been successful");
                    historyBook();
                } else {
                    found = false;
                }
            }
        }
        bookFoundCheck(found);
        MainScreen.librarianScreen();
    }

    public static void changeBook(String bookCode) {
        boolean found = false;
        for (History history : service.getHistoryListDetail().getHistories()) {
            if (history.getBookCode().equalsIgnoreCase(bookCode)) {
                found = true;
                if (history.getBookSituation().equals(BookSituation.Borrow)) {
                    service.setHistoryDetail(history);

                    // When book borrow but not approve -> can't change date return
                    if (history.getDayBorrow() == null || history.getDayReturn() == null) {
                        found = false;
                    } else {
                        int day = CustomerScreen.changeCusDate();
                        if (DAYS.between(history.getDayBorrow(), history.getDayReturn().plusDays(day)) > 15) {
                            System.out.println("Error, your date are invalid");
                            System.out.println("================================");
                            LibrarianScreen.approveDisplay();
                        }
                        history.setDayReturn(history.getDayReturn().plusDays(day));
                        System.out.println("Your work has been successful");
                    }
                } else {
                    found = false;
                }
            }
        }
        bookFoundCheck(found);
        MainScreen.librarianScreen();
    }

    private static void bookFoundCheck(Boolean found){
        if (!found){
            LibrarianScreen.notFoundBook();
        }
    }
}
