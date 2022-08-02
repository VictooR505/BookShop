package com.example.bookshop.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);
    List<Book> findBooksByGenreId(Long id);
    List<Book> findBooksByAuthorId(Long id);
    List<Book> findBooksByAuthorName(String name);
    List<Book> findBooksByGenreName(String name);
    Book findBookById(Long id);
    boolean existsBookByTitle(String title);
}
