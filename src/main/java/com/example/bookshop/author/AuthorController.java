package com.example.bookshop.author;

import com.example.bookshop.author.dto.AuthorUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> authorList(){
        return authorService.getAuthors();
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
