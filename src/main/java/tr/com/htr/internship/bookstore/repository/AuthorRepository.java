package tr.com.htr.internship.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.htr.internship.bookstore.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Boolean existsByFirstName(String firstName);
    Boolean existsByLastName(String lastName);

}