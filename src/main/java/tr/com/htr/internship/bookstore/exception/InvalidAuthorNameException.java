
package tr.com.htr.internship.bookstore.exception;

public class InvalidAuthorNameException extends RuntimeException {

    public InvalidAuthorNameException(String name) {
        super("Invalid author name. " + name);
    }
}