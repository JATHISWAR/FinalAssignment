package com.miniproject.bookstore.controller;


import com.miniproject.bookstore.entity.Book;
import com.miniproject.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<String> index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return new ResponseEntity<>(model.toString(), HttpStatus.OK);
    }

    @GetMapping("/book/create")
    public ResponseEntity<String> create(Model model) {
        model.addAttribute("book", new Book());
        return new ResponseEntity<>(model.toString(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}/edit")
    public ResponseEntity<String> edit(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return new ResponseEntity<String>(model.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Book book) {
            bookService.save(book);
           return  ResponseEntity.status(HttpStatus.OK).body(book.toString());
    }

    @GetMapping("/book/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable int id, RedirectAttributes redirect) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item deleted");
    }


    @GetMapping("/books/search")
    public ResponseEntity<String> search(@RequestParam("str") String str,Model model){
       model.addAttribute("books",bookService.search(str));

        return new ResponseEntity<String>(model.toString(), HttpStatus.OK);
    }




}
