package org.launchcode.lendinglibrary.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BookRequest extends AbstractEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public BookRequest() {}

    public BookRequest(User user, Book book){
        this.user =user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
