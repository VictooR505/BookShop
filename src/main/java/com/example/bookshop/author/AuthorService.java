package com.example.bookshop.author;

import com.example.bookshop.author.dto.AuthorUpdateDTO;
import com.example.bookshop.exception.ArgumentInUseException;
import com.example.bookshop.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    Logger logger = Logger.getLogger(getClass().getName());

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findAuthorById(Long id){
        if(!authorRepository.existsById(id)){
            throw new ObjectNotFoundException("Author not found");
        }
        return authorRepository.findAuthorById(id);
    }

    public void addAuthor(Author author){
        if(authorRepository.existsByName(author.getName())){
            throw new ArgumentInUseException("Author cannot be duplicated");
        }
        authorRepository.save(author);
        logger.info("Author successfully added");
    }

    public void updateAuthor(Long id, AuthorUpdateDTO author){
        if(!authorRepository.existsById(id)){
            throw new ObjectNotFoundException("Author not found");
        }
        Author result = authorRepository.findAuthorById(id);
        result.setName(author.getName());
        authorRepository.save(result);
        logger.info("Author successfully updated");
    }

    public void deleteAuthor(Long id){
        if(!authorRepository.existsById(id)){
            throw new ObjectNotFoundException("Author not found");
        }
        authorRepository.deleteById(id);
        logger.info("Author successfully deleted");
    }
}
