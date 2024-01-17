package com.example.bookapp.Repository;


import com.example.bookapp.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
BookRepository extends JpaRepository<Book, Long> {}

