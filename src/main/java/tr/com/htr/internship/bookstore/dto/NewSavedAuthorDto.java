package tr.com.htr.internship.bookstore.dto;

public class NewSavedAuthorDto extends NewAuthorDto {

    private Long id;

    public NewSavedAuthorDto() {
        super();
    }

    public NewSavedAuthorDto(Long id, String firstName, String lastName) {
        super(firstName, lastName);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
