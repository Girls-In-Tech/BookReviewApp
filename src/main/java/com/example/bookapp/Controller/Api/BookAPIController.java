package com.example.bookapp.Controller.Api;


import com.example.bookapp.Domain.Book;
import com.example.bookapp.Repository.BookRepository;
import com.example.bookapp.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookAPIController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookAPIController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }


    @RequestMapping("/book")
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> book = bookRepository.findAll();
        return ResponseEntity.ok().body(bookRepository.findAll());
    }

    @RequestMapping("/book/{id}")
    @GetMapping
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok().body(bookService.addBook(book));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    Book savedBook = bookService.updateBook(existingBook.getId(), updatedBook);
                    existingBook.setTitle(updatedBook.getTitle());
                    existingBook.setAuthor(updatedBook.getAuthor());
                    existingBook.setPublicationDate(updatedBook.getPublicationDate());
                    existingBook.setReview(updatedBook.getReview());
                    existingBook.setRating(updatedBook.getRating());
                    return ResponseEntity.ok(savedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("book/{id}")
    public HttpStatus deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return HttpStatus.OK;
    }
}

