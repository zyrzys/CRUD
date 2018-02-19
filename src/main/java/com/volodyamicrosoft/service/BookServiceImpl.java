package com.volodyamicrosoft.service;

import com.volodyamicrosoft.dao.BookDao;
import com.volodyamicrosoft.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }
    @Override
    @Transactional
    public void readBook(boolean isRead ,Book book) {
        bookDao.readBook(isRead, book);
    }
    @Override
    @Transactional
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }
    @Override
    @Transactional
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
    @Override
    @Transactional
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }
    @Override
    @Transactional
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}
