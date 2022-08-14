package tr.com.htr.internship.bookstore.exception;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException(String message){
        super(message);
    }

}
