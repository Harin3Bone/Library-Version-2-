package Controller.Library.Service.Library;

import Controller.Library.Repository.Library.BookList;
import Controller.Library.Repository.Library.CustomerList;
import Controller.Library.Repository.Library.HistoryList;
import Controller.Library.Repository.Library.LibrarianList;
import Object.Library.Book;
import Object.Library.Customer;
import Object.Library.History;
import Object.Library.Librarian;

public class LibraryService {
    private static LibraryService instance;
    private Librarian librarianDetail;
    private Customer customerDetail;
    private Book bookDetail;
    private History historyDetail;

    private LibrarianList librarianListDetail;
    private CustomerList customerListDetail;
    private BookList bookListDetail;
    private HistoryList historyListDetail;

    private LibraryService() {

    }

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    public Librarian getLibrarianDetail() {
        return librarianDetail;
    }

    public void setLibrarianDetail(Librarian librarianDetail) {
        this.librarianDetail = librarianDetail;
    }

    public Customer getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(Customer customerDetail) {
        this.customerDetail = customerDetail;
    }

    public Book getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(Book bookDetail) {
        this.bookDetail = bookDetail;
    }

    public History getHistoryDetail() {
        return historyDetail;
    }

    public void setHistoryDetail(History historyDetail) {
        this.historyDetail = historyDetail;
    }

    //-------------------------------------------------------

    public LibrarianList getLibrarianListDetail() {
        return librarianListDetail;
    }

    public void setLibrarianListDetail(LibrarianList librarianListDetail) {
        this.librarianListDetail = librarianListDetail;
    }

    public CustomerList getCustomerListDetail() {
        return customerListDetail;
    }

    public void setCustomerListDetail(CustomerList customerListDetail) {
        this.customerListDetail = customerListDetail;
    }

    public BookList getBookListDetail() {
        return bookListDetail;
    }

    public void setBookListDetail(BookList bookListDetail) {
        this.bookListDetail = bookListDetail;
    }

    public HistoryList getHistoryListDetail() {
        return historyListDetail;
    }

    public void setHistoryListDetail(HistoryList historyListDetail) {
        this.historyListDetail = historyListDetail;
    }
}
