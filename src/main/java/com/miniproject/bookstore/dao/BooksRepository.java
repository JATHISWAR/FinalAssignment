package com.miniproject.bookstore.dao;

import com.miniproject.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<Book,Integer> {

}
