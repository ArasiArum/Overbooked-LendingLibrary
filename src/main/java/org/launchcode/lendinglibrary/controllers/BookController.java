package org.launchcode.lendinglibrary.controllers;

import org.launchcode.lendinglibrary.models.Book;
import org.launchcode.lendinglibrary.models.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title","All Books");
        model.addAttribute("books", bookRepository.findAll());
        return "books/index";
    }




    @GetMapping("add")
    public String displayAddBooksForm(Model model){
        model.addAttribute("title","Add Books");
        model.addAttribute(new Book());
        return "books/add";

    }

    @PostMapping("add")
    public String processAddBooksForm(@ModelAttribute @Valid Book newBook, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Add book");
            return "books/add";
        }
       bookRepository.save(newBook);
       return "redirect:";
    }

    @GetMapping("view/{bookId}")
    public String displayViewEmployer(Model model, @PathVariable int bookId) {

        Optional optBook = bookRepository.findById(bookId);
        if (optBook.isPresent()) {
            Book book = (Book) optBook.get();
            model.addAttribute("book", book);
            return "books/view";
        } else {
            return "redirect:../";
        }
    }

}
