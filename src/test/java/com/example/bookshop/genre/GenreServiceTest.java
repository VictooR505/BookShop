package com.example.bookshop.genre;

import com.example.bookshop.genre.dto.GenreUpdateDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class GenreServiceTest {
    @Autowired
    private GenreService genreService;
    @Autowired
    private GenreRepository genreRepository;

    @BeforeEach
    void setUp() {
        genreService = new GenreService(genreRepository);
    }

    @Test
    void findGenreByIdTest(){
        //given
        Genre givenGenre = new Genre("genre");
        genreRepository.save(givenGenre);
        //when
        Genre foundGenre = genreService.findGenreById(givenGenre.getId());
        //then
        assertEquals(givenGenre,foundGenre);
    }

    @Test
    void addAuthorTest(){
        //given
        Genre givenGenre = new Genre("genre");
        //when
        genreService.addGenre(givenGenre);
        Genre actualGenre = genreService.findGenreById(givenGenre.getId());
        //then
        assertEquals(givenGenre,actualGenre);
    }

    @Test
    @Transactional
    void updateAuthorTest(){
        //given
        Genre givenGenre = new Genre("genre");
        genreRepository.save(givenGenre);
        //when
        GenreUpdateDTO updateDTO = new GenreUpdateDTO("updatedName");
        genreService.updateGenre(givenGenre.getId(), updateDTO);
        //then
        assertEquals(givenGenre.getName(), "updatedName");
    }

    @Test
    void deleteAuthorTest(){
        //given
        Genre givenGenre = new Genre("genre");
        genreRepository.save(givenGenre);
        Long id = givenGenre.getId();
        //when
        genreService.deleteGenre(id);
        //then
        assertFalse(genreRepository.existsById(id));
    }
}
