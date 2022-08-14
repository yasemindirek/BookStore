package tr.com.htr.internship.bookstore.exception;

public class AuthorAlreadyExistsException extends RuntimeException {
    public AuthorAlreadyExistsException(String firstName, String lastName){
        super("Author already exists in the database! Author name: " + firstName + " " + lastName);
    }
}

