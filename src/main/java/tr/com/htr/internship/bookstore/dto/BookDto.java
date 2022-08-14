package tr.com.htr.internship.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import tr.com.htr.internship.bookstore.entity.Book;

@ApiModel(value = "Book dto documentation", description = "DTO")
public class BookDto {

    @ApiModelProperty(value = "Id field of Book object", required = true)
    private Long id;

    @ApiModelProperty(value = "Name field of Book object", required = true)
    private String bookName;

    private Long authorId;

    public BookDto() {
    }

    public BookDto(Book book) {
        setId(book.getId());
        setAuthorId(book.getAuthor().getId());
        setBookName(book.getBookName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
