package com.example.bookshop.book;

import com.example.bookshop.book.dto.BookUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return bookService.findBookById(id);
    }
    @GetMapping("/title/{title}")
    public Book bookByTitle(@PathVariable("title") String title){
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/author/{id}")
    public List<Book> booksByAuthorId(@PathVariable Long id){
        return bookService.findBooksByAuthorId(id);
    }

    @GetMapping("author/name/{name}")
    public List<Book> booksByAuthor(@PathVariable String name){
        return bookService.findBooksByAuthorName(name);
    }

    @GetMapping("/genre/{id}")
    public List<Book> booksByGenreId(@PathVariable Long id){
        return bookService.findBooksByGenreId(id);
    }

    @GetMapping("genre/name/{name}")
    public List<Book> booksByGenre(@PathVariable String name){
        return bookService.findBooksByGenreName(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
       bookService.addBook(book);
    }

    @PatchMapping("/id/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookUpdateDTO book){
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/id/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
