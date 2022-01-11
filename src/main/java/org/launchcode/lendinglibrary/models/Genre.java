package org.launchcode.lendinglibrary.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre extends AbstractEntity{

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "genre")
    private final List<Book> books = new ArrayList<>();

    public Genre(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    public Genre() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return name;
    }

}


