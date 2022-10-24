package com.example.bookshop.author;

import com.example.bookshop.author.dto.AuthorUpdateDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void findAuthorByIdTest(){
        //given
        Author givenAuthor = new Author("author");
        authorRepository.save(givenAuthor);
        //when
        Author foundAuthor = authorService.findAuthorById(givenAuthor.getId());
        //then
        assertEquals(givenAuthor,foundAuthor);
    }

    @Test
    void addAuthorTest(){
        //given
        Author givenAuthor = new Author("author");
        //when
        authorService.addAuthor(givenAuthor);
        Author actualAuthor = authorService.findAuthorById(givenAuthor.getId());
        //then
        assertEquals(givenAuthor,actualAuthor);
    }

    @Test
    @Transactional
    void updateAuthorTest(){
        //given
        Author givenAuthor = new Author("author");
        authorRepository.save(givenAuthor);
        //when
        AuthorUpdateDTO updateDTO = new AuthorUpdateDTO("updatedName");
        authorService.updateAuthor(givenAuthor.getId(), updateDTO);
        //then
        assertEquals(givenAuthor.getName(), "updatedName");
    }

    @Test
    void deleteAuthorTest(){
        //given
        Author givenAuthor = new Author("author");
        authorRepository.save(givenAuthor);
        Long id = givenAuthor.getId();
        //when
        authorService.deleteAuthor(id);
        //then
        assertFalse(authorRepository.existsById(id));
    }

}
