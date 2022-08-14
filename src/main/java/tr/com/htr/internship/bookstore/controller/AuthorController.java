package tr.com.htr.internship.bookstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tr.com.htr.internship.bookstore.dto.AuthorDto;
import tr.com.htr.internship.bookstore.dto.NewAuthorDto;
import tr.com.htr.internship.bookstore.dto.NewSavedAuthorDto;
import tr.com.htr.internship.bookstore.service.AuthorService;
import tr.com.htr.internship.bookstore.util.Constant;

import java.util.List;

@RestController
@Api(value = "Author Api documentation")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ApiOperation(value = "Returns author list")
    @GetMapping(Constant.GET_ALL_AUTHORS_REST_PATH)
    public List<AuthorDto> getAuthorList() { return authorService.getAuthors(); }

    @ApiOperation(value = "Adds new author")
    @PostMapping(Constant.ADD_AUTHOR_REST_PATH)
    public NewSavedAuthorDto addAuthor(@RequestBody NewAuthorDto authorDto) { return authorService.addAuthor(authorDto); }
}
