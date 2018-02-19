package com.volodyamicrosoft.dao;

import java.util.List;
import com.volodyamicrosoft.model.Book;


public interface BookDao {

    void addBook(Book book);

    void updateBook(Book book);

    void readBook(boolean isRead, Book book);

    void removeBook(int id);

    Book getBookById(int id);

    Book getBookByTitle(String title);

    List<Book> listBooks();
}
