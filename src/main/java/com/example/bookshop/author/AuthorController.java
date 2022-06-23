package com.example.bookshop.author;

import com.example.bookshop.book.Book;
import com.example.bookshop.genre.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> authorList(){
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/id/{id}")
    public Author getAuthorById(@PathVariable("id") Long id){
        return authorRepository.findAuthorById(id);
    }

    @PostMapping()
    ResponseEntity<Book> addBook(@RequestBody Author author){
        Author result = authorRepository.save(author);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        if(!(authorRepository.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        authorRepository.save(author);
        return ResponseEntity.ok(author);
    }
}
