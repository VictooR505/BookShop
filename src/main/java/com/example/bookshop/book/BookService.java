package com.example.bookshop.book;

import com.example.bookshop.author.AuthorRepository;
import com.example.bookshop.book.dto.BookUpdateDTO;
import com.example.bookshop.exception.ArgumentInUseException;
import com.example.bookshop.exception.ObjectNotFoundException;
import com.example.bookshop.genre.GenreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    Logger logger = Logger.getLogger(getClass().getName());

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    public Page<Book> getBooks(String sortBy, String sortOrder, int page, int size){
        if(!sortOrder.isEmpty() && !sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc")){
            throw new IllegalArgumentException("Sort order must be ascending (ASC) or descending (DESC)");
        }
        return bookRepository.findAll(PageRequest.of(page, size, Sort.Direction.valueOf(sortOrder.toUpperCase()), sortBy));
    }

    public Book findBookById(Long id){
        if(bookRepository.existsById(id)){
            return bookRepository.findBookById(id);
        }
        throw new ObjectNotFoundException("Book not found");
    }

    public Book findBookByTitle(String title){
        if(bookRepository.existsBookByTitle(title)){
            return bookRepository.findBookByTitle(title);
        }
        throw new ObjectNotFoundException("Book not found");
    }

    public Page<Book> findBooksByAuthorName(String name, String sortBy, String sortOrder, int page, int size){
        if(!sortOrder.isEmpty() && !sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc")){
            throw new IllegalArgumentException("Sort order must be ascending (ASC) or descending (DESC)");
        }else if(authorRepository.existsByName(name)){
            return bookRepository.findBooksByAuthorName(name,PageRequest.of(page, size, Sort.Direction.valueOf(sortOrder.toUpperCase()), sortBy));
        }
        throw new ObjectNotFoundException("Author not found");
    }

    public Page<Book> findBooksByGenreName(String name, String sortBy, String sortOrder, int page, int size){
        if(!sortOrder.isEmpty() && !sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc")){
            throw new IllegalArgumentException("Sort order must be ascending (ASC) or descending (DESC)");
        }else if(genreRepository.existsByName(name)){
            return bookRepository.findBooksByGenreName(name, PageRequest.of(page, size, Sort.Direction.valueOf(sortOrder.toUpperCase()), sortBy));
        }
        throw new ObjectNotFoundException("Genre not found");
    }

    public void addBook(Book book){
        if(bookRepository.existsBookByTitle(book.getTitle())){
            throw new ArgumentInUseException("Books cannot be duplicated");
        }
        bookRepository.save(book);
        logger.info("Book added successfully");
    }

    public void updateBook(Long id, BookUpdateDTO book){
        if(!bookRepository.existsById(id)){
            throw new ObjectNotFoundException("Book not found");
        }
        Book result = bookRepository.findBookById(id);
        result.setAuthor(book.getAuthor());
        result.setTitle(book.getTitle());
        result.setGenre(book.getGenre());
        result.setPrice(book.getPrice());
        result.setCount(book.getCount());
        bookRepository.save(result);
        logger.info("Book successfully updated");
    }

    public void deleteBook(Long id){
        if(!bookRepository.existsById(id)){
            throw new ObjectNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
        logger.info("Book successfully deleted");
    }
}
