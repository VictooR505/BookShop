package com.example.bookshop.genre;

import com.example.bookshop.genre.dto.GenreUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Genre> genreList(){
        return genreService.getGenres();
    }

    @GetMapping("/id/{id}")
    public Genre getGenre(@PathVariable("id") Long id){
        return genreService.findGenreById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void addGenre(@RequestBody Genre genre){
        genreService.addGenre(genre);
    }

    @PatchMapping("/id/{id}")
    public void updateGenre(@PathVariable Long id, @RequestBody GenreUpdateDTO genre){
        genreService.updateGenre(id, genre);
    }

    @DeleteMapping("/id/{id}")
    public void deleteBook(@PathVariable Long id){
        genreService.deleteGenre(id);
    }

}
