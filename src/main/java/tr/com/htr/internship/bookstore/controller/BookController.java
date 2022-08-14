package tr.com.htr.internship.bookstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tr.com.htr.internship.bookstore.dto.BookDto;
import tr.com.htr.internship.bookstore.entity.Book;
import tr.com.htr.internship.bookstore.service.BookService;
import tr.com.htr.internship.bookstore.util.Constant;
import java.util.List;

@RestController
@Api(value = "Book Api documentation")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Returns book list")
    @GetMapping(Constant.GET_ALL_BOOKS_REST_PATH)
    public List<BookDto> getBookList() {
        return bookService.getBook();
    }

    @ApiOperation(value = "Returns book with given id")
    @GetMapping(Constant.GET_BOOK_REST_PATH)
    public Book findOne(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @ApiOperation(value = "Adds new book")
    @PostMapping(Constant.ADD_BOOK_REST_PATH)
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }
}
