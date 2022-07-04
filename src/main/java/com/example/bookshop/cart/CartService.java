package com.example.bookshop.cart;

import com.example.bookshop.book.Book;
import com.example.bookshop.book.BookRepository;
import com.example.bookshop.user.User;
import com.example.bookshop.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


@Service
public class CartService {

    private List books = new ArrayList();
    private Integer sum = 0;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    Logger logger = Logger.getLogger(getClass().getName());

    public CartService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public boolean addBook(Book book){
        if(findBook(book).getCount() > 0) {
            findBook(book)
                    .setCount(findBook(book).getCount()-1);
            bookRepository.save(findBook(book));
            setSum(getSum()+findBook(book).getPrice());
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
            setSum(getSum()-findBook(book).getPrice());
            return true;
        }
        return false;
    }

    public boolean buyBooks(Long id){
        User user = userRepository.findUserById(id);
        if(user.isLogged() && user.getCash()>=getSum()){
            user.setCash(user.getCash()-getSum());
            userRepository.save(user);
            setSum(0);
            books.clear();
            return true;
        }else if(!user.isLogged()){
            logger.info("User must be logged in");
            return false;
        }
        return false;
    }

    public Book findBook(Book book){
        return bookRepository.findBookById(book.getId());
    }

    public List<Book> getCart(){
        return Collections.unmodifiableList(books);
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
