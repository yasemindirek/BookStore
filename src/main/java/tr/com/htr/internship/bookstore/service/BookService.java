package tr.com.htr.internship.bookstore.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tr.com.htr.internship.bookstore.dto.BookDto;
import tr.com.htr.internship.bookstore.entity.Book;
import tr.com.htr.internship.bookstore.exception.*;
import tr.com.htr.internship.bookstore.mapper.BookMapper;
import tr.com.htr.internship.bookstore.repository.AuthorRepository;
import tr.com.htr.internship.bookstore.repository.BookRepository;
import tr.com.htr.internship.bookstore.util.Constant;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper mapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    public List<BookDto> getBook(){
        return mapper.toDto(bookRepository.findAll());
    }

    public Book getById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));


    }
    public BookDto addBook(BookDto dto) {

        Pattern p1 = Pattern.compile(Constant.REGEX_BOOK_NAME);
        String bookname = dto.getBookName();
        bookname = bookname.replaceAll("\\s", "");
        Matcher m1 = p1.matcher(bookname);
        boolean b1 = m1.matches();

        if(dto.getBookName().isBlank() /* id null?? */){
            throw new NullInputException();
        }


        if (!b1) {
            throw new InvalidBookNameException(dto.getBookName());
        }

        if (bookRepository.existsByBookName(dto.getBookName()) && bookRepository.existsByAuthor(authorRepository.getById(dto.getAuthorId()))) {
            throw new BookAlreadyExistsException(dto.getBookName());
        }

        try {
            Book entity = mapper.toEntity(dto);
            entity = bookRepository.save(entity);
            dto = mapper.toDto(entity);
            return dto;
        } catch (DataIntegrityViolationException e) {
            throw new AuthorNotFoundException(dto.getAuthorId());
        }
    }
}

