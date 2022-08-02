package com.example.bookshop.author;

import com.example.bookshop.author.dto.AuthorUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    public AuthorController(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> authorList(){
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/id/{id}")
    public Author authorById(@PathVariable("id") Long id){
        return authorService.findAuthorById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @PatchMapping("/id/{id}")
    public void updateAuthor(@PathVariable Long id, @RequestBody AuthorUpdateDTO author){
        authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/id/{id}")
    public void deleteBook(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }
}
