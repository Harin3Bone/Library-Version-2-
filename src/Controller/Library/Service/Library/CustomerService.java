package Controller.Library.Service.Library;

import Enum.Library.BookCategory;
import Enum.Library.BookSituation;
import Enum.Library.BookStatus;
import Object.Library.Book;
import Object.Library.History;
import View.Library.CustomerScreen;
import View.Library.LibrarianScreen;
import View.Library.MainScreen;

import java.time.LocalDate;
import java.util.ConcurrentModificationException;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

public class CustomerService {
    private static LibraryService service = LibraryService.getInstance();

    public static void customerProperty(String answer) {
        switch (answer) {
            case "1":
                CustomerScreen.searchDisplay();
                break;
            case "2":
                CustomerScreen.checkDisplay();
                break;
            case "3":
                CustomerScreen.borrowDisplay();
                break;
            case "4":
                CustomerScreen.returnDisplay();
                break;
            case "5":
                CustomerScreen.changeDisplay();
                break;
            case "6":
                MainScreen.homeScreen();
                break;
            case "0":
                MainScreen.exitCase();
            default:
                MainScreen.defaultCase();
        }
    }

    public static void searchBookCusProperty(String answer) {
        switch (answer) {
            case "1":
                CustomerScreen.searchNameCusDisplay();
                break;
            case "2":
                CustomerScreen.searchCateCusDisplay();
                break;
            case "3":
                CustomerScreen.searachCodeCusDisplay();
                break;
        }
        MainScreen.customerScreen();
    }

    public static void searchByName(String bookName) {
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                service.setBookDetail(book);
                LibrarianScreen.searchShow();
            }
        }
    }

    public static void searchByCategory(String bookCategory) {
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

    public static void searchByCode(String bookCode) {
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
        MainScreen.customerScreen();
    }

    public static void borrowBook(String bookCode) {
        boolean found = false;
        // Boolean it use for check it found book name or not. If not use boolean and choose else then will occur some problem

        // Borrow component
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookCode().equalsIgnoreCase(bookCode)) {
                found = true;
                if (book.getBookStatus().equals(BookStatus.Available)) {
                    // Status set
                    book.setBookStatus(BookStatus.Unvailable);
                    // Customer set
                    service.setBookDetail(book);
                    // History add -> historyForeach use for return book
                    historyAdd(null);
                    // Display book borrow detail
                    System.out.println("User : " + service.getCustomerDetail().getFirstName());
                    CustomerScreen.searchCusShow();
                    System.out.println("Your work has been successful\n");
                } else {
                    found = false;
                }
            }
        }
        bookFoundCheck(found);
        MainScreen.customerScreen();
    }

    public static void returnBook(String bookCode) {
        boolean found = false;
        for (Book book : service.getBookListDetail().getBooks()) {
            if (book.getBookCode().equalsIgnoreCase(bookCode)) {
                found = true;
                if (book.getBookStatus().equals(BookStatus.Unvailable)) {
                    service.setBookDetail(book);
                    try {
                        for (History history : service.getHistoryListDetail().getHistories()) {
                            service.setHistoryDetail(history);
                            if (history.getBookCode().equals(bookCode) && history.getBookSituation().equals(BookSituation.Borrow)) {
                                // Return date check late or early
                                System.out.println("\nUser : " + service.getCustomerDetail().getFirstName());
                                DayLateCheck();
                                // History add
                                historyAdd(history);
                            }
                        }
                    } catch (ConcurrentModificationException ignored) {

                    }
                    // Display book return detail
                    CustomerScreen.searchCusShow();
                    System.out.println("Your work has been successful");
                } else {
                    found = false;
                }
            }
        }
        bookFoundCheck(found);
        MainScreen.customerScreen();
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
                        int day = LibrarianScreen.changeLibDate();
                        if (DAYS.between(history.getDayBorrow(), history.getDayReturn().plusDays(day)) > 15) {
                            System.out.println("Error, your date are invalid");
                            System.out.println("================================");
                            changeBook(bookCode);
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
        MainScreen.customerScreen();

    }

    private static void historyAdd(History historyForeach) {
        History history = new History();

        // Add data to history object
        history.setUuid(UUID.randomUUID());
        history.setBookName(service.getBookDetail().getBookName());
        history.setBookCode(service.getBookDetail().getBookCode());
        history.setBookCategory(service.getBookDetail().getBookCategory());
        history.setBookAuthor(service.getBookDetail().getBookAuthor());

        // Add history data to history list
        if (historyForeach == null) {
            // Can use if (service.getBookDetail().getBookStatus().equals(BookStatus.Wait_Approve))
            history.setCustomerName(service.getCustomerDetail().getFirstName());
            history.setBookSituation(BookSituation.Wait_Approve);
            service.getHistoryListDetail().getHistories().add(history);
        } else {
            // Can use if (service.getBookDetail().getBookStatus().equals(BookStatus.Wait_Accept))
            history.setCustomerName(historyForeach.getCustomerName());
            history.setDayBorrow(historyForeach.getDayBorrow());
            history.setDayReturn(historyForeach.getDayReturn());
            history.setBookSituation(BookSituation.Wait_Accept);
            service.getHistoryListDetail().getHistories().add(history);
        }
    }

    public static void DayLateCheck() {
        int x = (int) DAYS.between(service.getHistoryDetail().getDayReturn(), LocalDate.now());
        if (x > 0) {
            System.out.println("" + service.getHistoryDetail().getCustomerName() + ", You return book late " + x + " day(s)");
        }
    }

    private static void bookFoundCheck(Boolean found){
        if (!found){
            CustomerScreen.notFoundBook();
        }
    }

}

