package com.example.bookshop.book;

import com.example.bookshop.genre.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> bookList(){
       return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/id/{id}")
    public Book bookById(@PathVariable("id") Long id){
        return bookRepository.findBookById(id);
    }
    @GetMapping("/title/{title}")
    public Optional<Book> bookByTitle(@PathVariable("title") String title){
        return bookRepository.findBookByTitle(title);
    }

    @GetMapping("/author/{id}")
    public Optional<List<Book>> booksByAuthorId(@PathVariable Long id){
        return bookRepository.findBooksByAuthorId(id);
    }

    @GetMapping("author/name/{name}")
    public Optional<List<Book>> booksByAuthor(@PathVariable String name){
        return bookRepository.findBooksByAuthorName(name);
    }

    @GetMapping("/genre/{id}")
    public Optional<List<Book>> booksByGenreId(@PathVariable Long id){
        return bookRepository.findBooksByGenreId(id);
    }

    @GetMapping("genre/name/{name}")
    public Optional<List<Book>> booksByGenre(@PathVariable String name){
        return bookRepository.findBooksByGenreName(name);
    }

    @PostMapping()
    ResponseEntity<Book> addBook(@RequestBody Book book){
        Book result = bookRepository.save(book);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        if(!(bookRepository.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.save(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        if(!(bookRepository.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
