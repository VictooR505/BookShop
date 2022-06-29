package com.example.bookshop.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByTitle(String title);
    Book findBookById(Long id);
    Optional<List<Book>> findBooksByGenreId(Long id);
    Optional<List<Book>> findBooksByAuthorId(Long id);
    Optional<List<Book>> findBooksByAuthorName(String name);
    Optional<List<Book>> findBooksByGenreName(String name);

}
