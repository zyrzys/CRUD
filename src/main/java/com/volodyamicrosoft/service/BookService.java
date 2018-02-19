package com.volodyamicrosoft.service;

import com.volodyamicrosoft.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void updateBook(Book book);

    void readBook(boolean isRead, Book book);

    void removeBook(int id);

    Book getBookById(int id);

    Book getBookByTitle(String title);

    List<Book> listBooks();
}
