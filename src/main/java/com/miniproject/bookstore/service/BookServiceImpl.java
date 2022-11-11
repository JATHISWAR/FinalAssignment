package com.miniproject.bookstore.service;

import com.miniproject.bookstore.dao.BooksRepository;
import com.miniproject.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksRepository booksRepository;


    @Override
    public Iterable<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Book findOne(int id) {
        return booksRepository.getOne(id);
    }

    @Override
    @Transactional
    public void save(Book saveBook) {
        booksRepository.save(saveBook);
    }

    @Override
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Override
    public List<Book> search(String s) {
        return booksRepository.findByNameContaining(s);   }
}
