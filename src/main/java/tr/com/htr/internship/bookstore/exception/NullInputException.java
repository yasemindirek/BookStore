package tr.com.htr.internship.bookstore.exception;

public class NullInputException extends RuntimeException {

    public NullInputException() {
        super("Input cannot be null. ");
    }
}