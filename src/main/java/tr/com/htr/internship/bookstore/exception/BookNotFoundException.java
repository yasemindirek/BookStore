package tr.com.htr.internship.bookstore.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super("Given book ID not found. ID: " + bookId);
    }
}