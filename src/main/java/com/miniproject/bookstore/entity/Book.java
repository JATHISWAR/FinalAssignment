package com.miniproject.bookstore.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    @NotEmpty(
            message
                    = "Name cannot be null and must have size greater than 0")
    private String name;

    @Column(name = "author")
    @NotEmpty
    @NotNull
    private String author;

    @Column(name = "publisher")
    @NotEmpty
    @NotNull
    private String publisher;

    @Column(name = "type")
    @NotEmpty
    @NotNull
    private String type;

    @Column(name = "price")
    @NotNull
    @NotEmpty
    @Min(value = 100, message = "Must be greater than 100")
    @Max(value = 10000, message = "Must be lesser than 10000")
    private int price;

    @Column(name = "issuedDate")
    @NotEmpty
    @NotNull
    private Date issuedDate;

    @Column(name = "returnDate")
    @NotEmpty
    @NotNull
    private Date returnDate;


}
