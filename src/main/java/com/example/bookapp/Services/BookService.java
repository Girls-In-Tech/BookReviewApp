package com.example.bookapp.Services;

import com.example.bookapp.Domain.Book;


import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    Book updateBook(Long id, Book updatedBook);

    void deleteBookById(Long id);


}
