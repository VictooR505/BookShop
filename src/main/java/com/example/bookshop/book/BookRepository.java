package com.example.bookshop.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);
    Page<Book> findBooksByAuthorName(String name, Pageable pageable);
    Page<Book> findBooksByGenreName(String name, Pageable pageable);
    Book findBookById(Long id);
    boolean existsBookByTitle(String title);
}
