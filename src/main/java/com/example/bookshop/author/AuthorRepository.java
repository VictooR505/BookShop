package com.example.bookshop.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorById(Long id);
    boolean existsById(Long id);
    boolean existsByName(String name);
}
