package com.miniproject.bookstore.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


import java.sql.Date;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private int price;

    @Column(name = "issuedDate")
    private Date issuedDate;

    @Column(name = "returnDate")
    private Date returnDate;




}
