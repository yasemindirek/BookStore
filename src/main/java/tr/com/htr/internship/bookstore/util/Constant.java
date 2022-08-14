package tr.com.htr.internship.bookstore.util;

public class Constant {

    // REST PATH CONSTANTS
    public static final String GET_ALL_BOOKS_REST_PATH = "/getAllBooks";

    public static final String GET_BOOK_REST_PATH = "/getBook/{id}";

    public static final String ADD_BOOK_REST_PATH = "/addBook";

    public static final String GET_ALL_AUTHORS_REST_PATH = "/getAllAuthors";

    public static final String ADD_AUTHOR_REST_PATH = "/addAuthor";

    // REGEX PATTERNS
    public static final String REGEX_AUTHOR_NAME = "[A-Za-z]+";

    public static final String REGEX_AUTHOR_ID = "[0-9]+";

    public static final String REGEX_BOOK_NAME = "[A-Za-z]+";


}

