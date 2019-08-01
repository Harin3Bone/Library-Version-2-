package Object.Library;

import Enum.Library.BookCategory;
import Enum.Library.BookSituation;

import java.time.LocalDate;
import java.util.UUID;

public class History {
    private UUID uuid = UUID.randomUUID();
    private String librarianName;
    private String customerName;
    private String bookName;
    private BookCategory bookCategory;
    private String bookCode;
    private String bookAuthor;
    private BookSituation bookSituation;
    private LocalDate dayBorrow;
    private LocalDate dayReturn;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public BookSituation getBookSituation() {
        return bookSituation;
    }

    public void setBookSituation(BookSituation bookSituation) {
        this.bookSituation = bookSituation;
    }

    public LocalDate getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(LocalDate dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public LocalDate getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(LocalDate dayReturn) {
        this.dayReturn = dayReturn;
    }

    public History(){

    }

    public History(UUID uuid, String librarianName, String customerName, String bookName, BookCategory bookCategory,
                   String bookCode, String bookAuthor, BookSituation bookSituation, LocalDate dayBorrow, LocalDate dayReturn) {
        this.uuid = uuid;
        this.librarianName = librarianName;
        this.customerName = customerName;
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookCode = bookCode;
        this.bookAuthor = bookAuthor;
        this.bookSituation = bookSituation;
        this.dayBorrow = dayBorrow;
        this.dayReturn = dayReturn;
    }

    @Override
    public String toString() {
        return "Librarian = " + librarianName +
                " | Customer = " + customerName +
                " | Book = " + bookName +
                " | Category = " + bookCategory+
                " | Code = " + bookCode +
                " | Author = " + bookAuthor+
                " | Status = " + bookSituation +
                " | Borrow = " + dayBorrow +
                " | Return = " + dayReturn;
    }
}
