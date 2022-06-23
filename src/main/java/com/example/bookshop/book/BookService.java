package com.example.bookshop.book;

import com.example.bookshop.author.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

}
