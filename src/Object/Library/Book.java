package Object.Library;

import Enum.Library.BookCategory;
import Enum.Library.BookStatus;

import java.util.Comparator;
import java.util.UUID;

public class Book {
    private UUID uuid = UUID.randomUUID();
    private String bookName;
    private BookCategory bookCategory;
    private String bookCode;
    private String bookAuthor;
    private String bookabstract;
    private BookStatus bookStatus;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getBookabstract() {
        return bookabstract;
    }

    public void setBookabstract(String bookabstract) {
        this.bookabstract = bookabstract;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Book(){

    }

    public Book(UUID uuid, String bookName, BookCategory bookCategory, String bookCode, String bookAuthor,
                String bookabstract, BookStatus bookStatus) {
        this.uuid = uuid;
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookCode = bookCode;
        this.bookAuthor = bookAuthor;
        this.bookabstract = bookabstract;
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "bookName = " + bookName +
                " | bookCategory = " + bookCategory +
                " | bookCode = " + bookCode +
                " | bookAuthor = " + bookAuthor +
                " | bookStatus = " + bookStatus;
    }


}
