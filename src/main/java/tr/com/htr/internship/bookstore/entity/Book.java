package tr.com.htr.internship.bookstore.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"book\"")
@JsonSerialize(using = CustomBookSerializer.class)
@ApiModel(value = "Book entity documentation", description = "Entity")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint", name = "id", updatable = false, nullable = false)
    @ApiModelProperty(value = "Id field of Book object", required = true)
    private Long id;

    @Column(columnDefinition = "character varying", name = "book_name", nullable = false)
    @ApiModelProperty(value = "Name field of Book object", required = true)
    private String bookName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}