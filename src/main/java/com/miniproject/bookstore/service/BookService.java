package com.miniproject.bookstore.service;

import com.miniproject.bookstore.entity.Book;

public interface BookService {
    Iterable<Book> findAll();

    Book findOne(int id);

    void save(Book saveBook);

    void delete(int id);






}
