package org.launchcode.lendinglibrary.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Book Title is required!")
    @Size(min= 3, max= 60, message = "Book Title must be between 3 and 60 characters!")
    private String name;

    @NotBlank(message="Author name cannot be blank!")
    @Size(min = 5 , max = 60, message= "Author name must be between 5 and 60 characters!")
    private String author;


    @Size(max=500 , message = "Summary should not exceed 400 characters!")
    private String summary;

    public Book(String name, String author, String summary){

        this.name = name;
        this.author = author;
        this.summary = summary;

    }
    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
