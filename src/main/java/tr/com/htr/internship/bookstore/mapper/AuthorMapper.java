package tr.com.htr.internship.bookstore.mapper;

import org.springframework.stereotype.Component;
import tr.com.htr.internship.bookstore.dto.AuthorDto;
import tr.com.htr.internship.bookstore.dto.NewAuthorDto;
import tr.com.htr.internship.bookstore.dto.NewSavedAuthorDto;
import tr.com.htr.internship.bookstore.entity.Author;
import tr.com.htr.internship.bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorMapper {

    private final BookRepository bookRepository;

    public AuthorMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public AuthorDto toDto(Author entity) {
        AuthorDto dto = new AuthorDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBookList(entity.getBookList());
        return dto;

    }

    public NewSavedAuthorDto toNewSavedAuthorDto(Author entity) {
        NewSavedAuthorDto newSavedAuthorDto = new NewSavedAuthorDto();
        newSavedAuthorDto.setId(entity.getId());
        newSavedAuthorDto.setFirstName(entity.getFirstName());
        newSavedAuthorDto.setLastName(entity.getLastName());
        return newSavedAuthorDto;
    }

    public List<AuthorDto> toDto(List<Author> authorList) {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (Author author : authorList) {
            authorDtoList.add(toDto(author));
        }
        return authorDtoList;
    }

    public Author toEntity(NewAuthorDto authorDto) {
        Author entity = new Author();
        entity.setFirstName(authorDto.getFirstName());
        entity.setLastName(authorDto.getLastName());
        return entity;
    }
}

