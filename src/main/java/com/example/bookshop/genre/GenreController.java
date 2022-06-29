package com.example.bookshop.genre;

import com.example.bookshop.book.Book;
import com.example.bookshop.book.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;
    private final GenreRepository genreRepository;


    public GenreController(GenreService genreService, GenreRepository genreRepository) {
        this.genreService = genreService;
        this.genreRepository = genreRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Genre>> genreList(){
        return ResponseEntity.ok(genreRepository.findAll());
    }

    @GetMapping("/id/{id}")
    public Optional<Genre> getGenre(@PathVariable("id") Long id){
        return genreRepository.findGenreById(id);
    }

    @PostMapping()
    ResponseEntity<Book> addGenre(@RequestBody Genre genre){
        Genre result = genreRepository.save(genre);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre){
        if(!(genreRepository.existsById(id))) {
            return ResponseEntity.notFound().build();
        }
        genreRepository.save(genre);
        return ResponseEntity.ok(genre);
    }

}
