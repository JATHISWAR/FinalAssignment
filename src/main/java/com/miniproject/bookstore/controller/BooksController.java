package com.miniproject.bookstore.controller;


import com.miniproject.bookstore.entity.Book;
import com.miniproject.bookstore.service.BookService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "booklist";
    }

    @GetMapping("/book/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @GetMapping("/book/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "form";
    }

    @PostMapping("/book/save")
    public String save(@Valid Book book, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return  result.getAllErrors().toString();
        }
        else {
            bookService.save(book);
            redirect.addFlashAttribute("success", "Saved Book Details successfully!");
            return "redirect:/book";
        }
    }

    @GetMapping("/book/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        bookService.delete(id);
        redirect.addFlashAttribute("success", "Deleted Book Details successfully!");
        return "redirect:/book";
    }




}
