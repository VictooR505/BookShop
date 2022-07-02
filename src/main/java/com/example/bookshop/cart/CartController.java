package com.example.bookshop.cart;

import com.example.bookshop.book.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    Logger logger = Logger.getLogger(getClass().getName());

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping()
    public List<Book> getCart(){
        return cartService.getCart();
    }

    @GetMapping("/sum")
    public Integer getSum(){
        return cartService.getSum();
    }

    @PostMapping()
    public void addBook(@RequestBody Book book){
        if(cartService.addBook(book)){
            logger.info("Book added to cart");
        }else{
            logger.info("No book in stock");
        }
    }

    @DeleteMapping()
    public void deleteBook(@RequestBody Book book){
        if(cartService.removeBook(book)){
            logger.info("Book removed from cart");
        }else{
            logger.info("No book in cart");
        }
    }
}
