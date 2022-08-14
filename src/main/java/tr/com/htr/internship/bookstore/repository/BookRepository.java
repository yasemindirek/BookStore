package tr.com.htr.internship.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.htr.internship.bookstore.entity.Author;
import tr.com.htr.internship.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Boolean existsByBookName(String bookName);
    Boolean existsByAuthor(Author author);
}
