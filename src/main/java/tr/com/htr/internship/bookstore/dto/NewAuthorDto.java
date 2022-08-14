package tr.com.htr.internship.bookstore.dto;

public class NewAuthorDto {

    private String firstName;
    private String lastName;

    public NewAuthorDto() {

    }

    public NewAuthorDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}