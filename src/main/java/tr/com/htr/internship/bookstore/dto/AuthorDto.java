package tr.com.htr.internship.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tr.com.htr.internship.bookstore.entity.Author;
import tr.com.htr.internship.bookstore.entity.Book;
import java.util.List;

@ApiModel(value = "Author dto documentation", description = "DTO")
public class AuthorDto {

    @ApiModelProperty(value = "Id field of Author object", required = true)
    private Long id;

    @ApiModelProperty(value = "First name field of Author object", required = true)
    private  String firstName;

    @ApiModelProperty(value = "Last name field of Author object", required = true)
    private String lastName;

    private List<Book> bookList;

    public AuthorDto(){

    }

    public AuthorDto(Author author){
        setId(author.getId());
        setFirstName(author.getFirstName());
        setLastName((author.getLastName()));
        setBookList(author.getBookList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


}
