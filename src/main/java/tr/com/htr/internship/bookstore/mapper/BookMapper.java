package tr.com.htr.internship.bookstore.mapper;

import org.springframework.stereotype.Component;
import tr.com.htr.internship.bookstore.dto.BookDto;
import tr.com.htr.internship.bookstore.entity.Author;
import tr.com.htr.internship.bookstore.entity.Book;
import tr.com.htr.internship.bookstore.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    private final AuthorRepository authorRepository;

    public BookMapper(AuthorRepository authorRepository)  {
        this.authorRepository = authorRepository;
    }

    public BookDto toDto(Book entity) {
        BookDto dto = new BookDto();
        dto.setId(entity.getId());
        dto.setBookName(entity.getBookName());
        dto.setAuthorId(entity.getAuthor().getId());
        return dto;
    }

    public List<BookDto> toDto(List<Book> bookList){
        List<BookDto> bookDtoList = new ArrayList<>();
        for(Book book : bookList){
            bookDtoList.add(toDto(book));
        }
        return bookDtoList;
    }

    public Book toEntity(BookDto dto) {
        Author author = authorRepository.getById(dto.getAuthorId());
        Book entity = new Book();
        entity.setBookName(dto.getBookName());
        entity.setAuthor(author);
        return entity;

    }
}
