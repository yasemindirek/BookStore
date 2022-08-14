
package tr.com.htr.internship.bookstore.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Long authorId) {
        super("Given author ID not found. ID: " + authorId);
    }

}