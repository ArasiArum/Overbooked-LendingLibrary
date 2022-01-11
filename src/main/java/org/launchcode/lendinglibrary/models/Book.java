package org.launchcode.lendinglibrary.models;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Book extends AbstractEntity{



    @NotBlank(message="Book Title is required!")
    @Size(min= 3, max= 60, message = "Book Title must be between 3 and 60 characters!")
    private String name;

    @NotBlank(message="Author name cannot be blank!")
    @Size(min = 5 , max = 60, message= "Author name must be between 5 and 60 characters!")
    private String author;

//    @ManyToOne
//    @NotNull(message = "Genre is required")
//    private Genre genre;


    @Size(max=500 , message = "Summary should not exceed 400 characters!")
    private String summary;

    public Book(String name, String author, String summary){

        this.name = name;
        this.author = author;
       // this.genre = genre;
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

//    public Genre getGenre() {
//        return genre;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
}
