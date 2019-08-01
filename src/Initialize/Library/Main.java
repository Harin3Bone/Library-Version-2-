package Initialize.Library;

import Controller.Library.Repository.Library.BookList;
import Controller.Library.Repository.Library.CustomerList;
import Controller.Library.Repository.Library.HistoryList;
import Controller.Library.Repository.Library.LibrarianList;
import Controller.Library.Service.Library.LibraryService;
import View.Library.MainScreen;

public class Main {

    public static void main(String[] args) {
        LibraryService service = LibraryService.getInstance();  // Create service to save all list in service -> Singleton

        LibrarianList librarians = new LibrarianList();         // Create librarian list gl_Object
        librarians.DataLibrarianList(librarians);               // Add data to librarian list
        service.setLibrarianListDetail(librarians);             // Add list to service

        CustomerList customers = new CustomerList();            // Create customer list gl_Object
        customers.DataCustomerList(customers);                  // Add data to customer list
        service.setCustomerListDetail(customers);               // Add list to service

        BookList books = new BookList();                        // Create book list gl_Object
        books.DataBookList(books);                              // Add data to book list
        service.setBookListDetail(books);                       // Add list to service

        HistoryList histories = new HistoryList();              // Create history list gl_Object
        histories.DataHistoryList(histories);                   // Add data to history list
        service.setHistoryListDetail(histories);                // Add list to service

        MainScreen.homeScreen();
    }
}
