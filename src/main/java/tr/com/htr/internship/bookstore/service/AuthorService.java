package tr.com.htr.internship.bookstore.service;

import org.springframework.stereotype.Service;
import tr.com.htr.internship.bookstore.dto.AuthorDto;
import tr.com.htr.internship.bookstore.dto.NewAuthorDto;
import tr.com.htr.internship.bookstore.dto.NewSavedAuthorDto;
import tr.com.htr.internship.bookstore.entity.Author;
import tr.com.htr.internship.bookstore.exception.AuthorAlreadyExistsException;
import tr.com.htr.internship.bookstore.exception.InvalidAuthorNameException;
import tr.com.htr.internship.bookstore.exception.NullInputException;
import tr.com.htr.internship.bookstore.mapper.AuthorMapper;
import tr.com.htr.internship.bookstore.repository.AuthorRepository;
import tr.com.htr.internship.bookstore.util.Constant;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper mapper) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    public List<AuthorDto> getAuthors() {
        return mapper.toDto(authorRepository.findAll());
    }

    public NewSavedAuthorDto addAuthor(NewAuthorDto dto) {

        if (dto.getFirstName().isBlank() || dto.getLastName().isBlank()) {
            throw new NullInputException();
        }
        Pattern p = Pattern.compile(Constant.REGEX_AUTHOR_NAME);
        Matcher m1 = p.matcher(dto.getFirstName());
        Matcher m2 = p.matcher(dto.getLastName());
        boolean b1 = m1.matches();
        boolean b2 = m2.matches();

        if (!b1 || !b2) {
            throw new InvalidAuthorNameException("Author name: " + dto.getFirstName() + " " + dto.getLastName());
        }

        if (authorRepository.existsByFirstName(dto.getFirstName()) && authorRepository.existsByLastName(dto.getLastName())) {
            throw new AuthorAlreadyExistsException(dto.getFirstName(), dto.getLastName());
        }

        Author entity = mapper.toEntity(dto);
        entity = authorRepository.save(entity);
        return mapper.toNewSavedAuthorDto(entity);
    }
}