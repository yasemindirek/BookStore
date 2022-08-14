package tr.com.htr.internship.bookstore.exception;

public class InvalidIdException extends RuntimeException {

    public InvalidIdException(Long id) {
        super("ID is invalid. ID: " + id);
    }
}