package tr.com.htr.internship.bookstore.exception;

public class InvalidBookNameException extends RuntimeException {

    public InvalidBookNameException(String bookName) {
        super("Invalid book name. Book name:" + bookName);
    }
}
