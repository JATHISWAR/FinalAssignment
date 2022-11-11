package com.miniproject.bookstore.dao;

import com.miniproject.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;


public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByNameContaining(String s);

}
