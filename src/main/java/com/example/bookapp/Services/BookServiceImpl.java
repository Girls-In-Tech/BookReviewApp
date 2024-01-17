package com.example.bookapp.Services;

import com.example.bookapp.Domain.Book;
import com.example.bookapp.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        Book emptyBook;
        if (book.isPresent()){
            emptyBook = book.get();
            return emptyBook;
        } else {
            throw new RuntimeException("Book Not Found");
        }
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalExistingBook = bookRepository.findById(id);

        if (optionalExistingBook.isPresent()) {
            Book existingBook = optionalExistingBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublicationDate(updatedBook.getPublicationDate());
            existingBook.setReview(updatedBook.getReview());
            existingBook.setRating(updatedBook.getRating());

            bookRepository.save(updatedBook);
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }
}

