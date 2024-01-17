package com.example.bookapp.Controller;

import com.example.bookapp.Domain.Book;
import com.example.bookapp.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "home";
    }

    @GetMapping("/showNewbookForm")
    public String showNewBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("pageTitle", "Add Book");


        return "add-books";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes){
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute("message", "Book updated successfully");

        return "redirect:/";
    }

    @GetMapping("/updateBook/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes){
        try{
            Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
            model.addAttribute("pageTitle", "Edit Book Id:" + id);

            return "new_book";
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/";
        }
    }

    @PostMapping("/updateBook")
    public String updateDrink(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes){
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute("message", "Book updated successfully");

        return "redirect:/";
    }

    @GetMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable long id, RedirectAttributes redirectAttributes){
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("message", "Book Deleted successfully");

        return "redirect:/";
    }
}

