package com.example.bookshop.book;


import com.example.bookshop.author.Author;
import com.example.bookshop.author.AuthorRepository;
import com.example.bookshop.book.dto.BookUpdateDTO;
import com.example.bookshop.genre.Genre;
import com.example.bookshop.genre.GenreRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository, authorRepository, genreRepository);
    }

    @AfterEach
    void cleanUp(){
        bookRepository.deleteAll();
        genreRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    void findBookByIdTest(){
        //given
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        bookRepository.save(givenBook);
        //when
        Book foundBook = bookService.findBookById(givenBook.getId());
        //then
        assertEquals(givenBook,foundBook);
    }

    @Test
    void findBookByTitleTest(){
        //given
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        bookRepository.save(givenBook);
        //when
        Book foundBook = bookService.findBookByTitle(givenBook.getTitle());
        //then
        assertEquals(givenBook,foundBook);
    }

    @Test
    void findBooksByAuthorNameTest(){
        //given
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        Book givenBook2 = new Book(author, "title2", genre, 30, 10);
        bookRepository.save(givenBook);
        bookRepository.save(givenBook2);
        //when
      //  List<Book> foundBooks = bookService.findBooksByAuthorName(author.getName());
        //then
     //   assertEquals(2,foundBooks.size());
    }

    @Test
    void findBooksByGenreNameTest(){
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        Book givenBook2 = new Book(author, "title2", genre, 30, 10);
        bookRepository.save(givenBook);
        bookRepository.save(givenBook2);
        //when
     //   List<Book> foundBooks = bookService.findBooksByGenreName(genre.getName());
        //then
     //   assertEquals(2,foundBooks.size());
    }

    @Test
    void addBookTest(){
        //given
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        //when
        bookService.addBook(givenBook);
        Book actualBook = bookService.findBookById(givenBook.getId());
        //then
        assertEquals(givenBook,actualBook);
    }

    @Test
    @Transactional
    void updateBookTest(){
        //given
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        bookRepository.save(givenBook);
        //when
        BookUpdateDTO updateDTO = new BookUpdateDTO(author, "updatedTitle", genre, 40, 10);
        bookService.updateBook(givenBook.getId(), updateDTO);
        //then
        assertEquals( "updatedTitle", givenBook.getTitle());
        assertEquals(40, givenBook.getPrice());
    }

    @Test
    void deleteBookTest(){
        //given
        Author author = new Author("author");
        authorRepository.save(author);
        Genre genre = new Genre("genre");
        genreRepository.save(genre);
        Book givenBook = new Book(author, "title", genre, 30, 10);
        bookRepository.save(givenBook);
        Long id = givenBook.getId();
        //when
        bookService.deleteBook(id);
        //then
        assertFalse(bookRepository.existsById(id));
    }
}
