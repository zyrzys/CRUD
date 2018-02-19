package com.volodyamicrosoft.dao;

import com.volodyamicrosoft.model.Book;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(book);
        session.persist(book);
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    public void readBook(boolean isRead, Book book) {
        Session session = sessionFactory.getCurrentSession();
        if (isRead)
            book.setReadAlready(false);
        else
            book.setReadAlready(true);
        session.update(book);
    }

    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if (book != null) session.delete(book);
    }

    public Book getBookById(int id) {
        Book book = sessionFactory.getCurrentSession().get(Book.class, id);

        return book;
    }
    @SuppressWarnings("unchecked")
    public Book getBookByTitle(String title) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book where title =:title")
                .setParameter("title", title)
                .list();
        return bookList.get(0);
    }


    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book").list();
        return books;
    }
}