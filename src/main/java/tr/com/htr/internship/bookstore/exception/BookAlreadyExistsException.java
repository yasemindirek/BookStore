

package tr.com.htr.internship.bookstore.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String bookName) {
        super("Book already exists in the database! Book name: " + bookName);
    }
}