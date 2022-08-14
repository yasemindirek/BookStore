package tr.com.htr.internship.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleApiRequestException(AuthorNotFoundException e) {

        HttpStatus error = HttpStatus.NOT_FOUND;
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<RestErrorMessage> handleBookAlreadyExistsException(BookAlreadyExistsException bookAlreadyExistsException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                bookAlreadyExistsException.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthorAlreadyExistsException.class)
    public ResponseEntity<RestErrorMessage> handleAuthorAlreadyExistsException(AuthorAlreadyExistsException authorAlreadyExistsException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                authorAlreadyExistsException.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<RestErrorMessage> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                bookNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookNameException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidBookNameException(InvalidBookNameException invalidBookNameException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                invalidBookNameException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAuthorNameException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidAuthorNameException(InvalidAuthorNameException invalidAuthorNameException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                invalidAuthorNameException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullInputException.class)
    public ResponseEntity<RestErrorMessage> handleNullInputException(NullInputException nullInputException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                nullInputException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidIdException(InvalidIdException invalidIdException) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(
                invalidIdException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(restErrorMessage, HttpStatus.BAD_REQUEST);
    }


}
