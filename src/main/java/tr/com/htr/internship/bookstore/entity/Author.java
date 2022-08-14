package tr.com.htr.internship.bookstore.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "\"author\"")
@ApiModel(value = "Author entity documentation", description = "Entity")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint", name = "author_id", updatable = false, nullable = false)
    @ApiModelProperty(value = "Id field of Author object", required = true)
    private Long id;

    @Column(columnDefinition = "character varying", name = "first_name", updatable = false, nullable = false)
    @ApiModelProperty(value = "First name field of Author object", required = true)
    private String firstName;

    @Column(columnDefinition = "character varying", name = "last_name", updatable = false, nullable = false)
    @ApiModelProperty(value = "Last name field of Author object", required = true)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> bookList;

    public Long getId() {
        return id;
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