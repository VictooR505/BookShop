package com.example.bookshop.genre;

import com.example.bookshop.exception.ArgumentInUseException;
import com.example.bookshop.exception.ObjectNotFoundException;
import com.example.bookshop.genre.dto.GenreUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    Logger logger = Logger.getLogger(getClass().getName());

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre findGenreById(Long id){
        if(!genreRepository.existsById(id)){
            throw new ObjectNotFoundException("Genre not found");
        }
        return genreRepository.findGenreById(id);
    }

    public void addGenre(Genre genre){
        if(genreRepository.existsByName(genre.getName())){
            throw new ArgumentInUseException("Genre cannot be duplicated");
        }
        logger.info("Genre successfully added");
        genreRepository.save(genre);
    }

    public void updateGenre(Long id, GenreUpdateDTO genre){
        if(!genreRepository.existsById(id)){
            throw new ObjectNotFoundException("Genre not found");
        }
        Genre result = genreRepository.findGenreById(id);
        result.setName(genre.getName());
        genreRepository.save(result);
        logger.info("Genre successfully updated");
    }

    public void deleteGenre(Long id){
        if(!genreRepository.existsById(id)){
            throw new ObjectNotFoundException("Genre not found");
        }
        genreRepository.deleteById(id);
        logger.info("Genre successfully deleted");
    }
}
