package com.example.bookshop.cart;

import com.example.bookshop.book.Book;
import com.example.bookshop.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CartService {

    private List books = new ArrayList();
    BookRepository bookRepository;

    @Autowired
    public CartService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean addBook(Book book){
        if(findBook(book).getCount() > 0) {
            findBook(book)
                    .setCount(findBook(book).getCount()-1);
            bookRepository.save(findBook(book));
            books.add(findBook(book));
            return true;
        }
        return false;
    }
    public boolean removeBook(Book book){
        if(books.contains(findBook(book))){
            books.remove(books.lastIndexOf(findBook(book)));
            findBook(book).setCount(findBook(book).getCount()+1);
            bookRepository.save(findBook(book));
            return true;
        }
        return false;
    }

    public Book findBook(Book book){
        return bookRepository.findBookById(book.getId());
    }

    public List<Book> getCart(){
        return Collections.unmodifiableList(books);
    }


}
