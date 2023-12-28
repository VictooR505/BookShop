package com.example.bookshop.book;

import com.example.bookshop.book.dto.BookCreateDTO;
import com.example.bookshop.book.dto.BookUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public Page<Book> bookList(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "1000") int size,
                               @RequestParam(defaultValue = "id") String sortBy,
                               @RequestParam(defaultValue = "ASC") String sortOrder){
       return bookService.getBooks(sortBy, sortOrder, page, size);
    }

    @GetMapping("/id/{id}")
    public Book bookById(@PathVariable("id") Long id){
        return bookService.findBookById(id);
    }
    @GetMapping("/title/{title}")
    public Book bookByTitle(@PathVariable("title") String title){
        return bookService.findBookByTitle(title);
    }

    @GetMapping("author/name/{name}")
    public Page<Book> booksByAuthor(@PathVariable String name,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "1000") int size,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(defaultValue = "ASC") String sortOrder){
        return bookService.findBooksByAuthorName(name, sortBy ,sortOrder, page,size);
    }

    @GetMapping("genre/name/{name}")
    public Page<Book> booksByGenre(@PathVariable String name,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1000") int size,
                                   @RequestParam(defaultValue = "id") String sortBy,
                                   @RequestParam(defaultValue = "ASC") String sortOrder){
        return bookService.findBooksByGenreName(name, sortBy, sortOrder, page, size);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookCreateDTO book){
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
