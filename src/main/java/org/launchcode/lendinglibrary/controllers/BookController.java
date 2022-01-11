package org.launchcode.lendinglibrary.controllers;

import org.launchcode.lendinglibrary.models.Book;
import org.launchcode.lendinglibrary.models.BookRequest;
import org.launchcode.lendinglibrary.models.User;
import org.launchcode.lendinglibrary.models.data.BookRepository;
import org.launchcode.lendinglibrary.models.data.BookRequestRepository;
import org.launchcode.lendinglibrary.models.data.GenreRepository;
import org.launchcode.lendinglibrary.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRequestRepository bookRequestRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    AuthenticationController authenticationController;


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
        model.addAttribute("genres",genreRepository.findAll());
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



    @PostMapping("view/{bookId}")
    public String requestBook(Model model, @PathVariable int bookId, HttpServletRequest request, RedirectAttributes redirectAttributes){

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        //User currentUser = getLoggedInUser(request.getUserPrincipal()) ;

        Optional optBook = bookRepository.findById(bookId);
        Book theBook = (Book) optBook.get();
        BookRequest bookRequest = new BookRequest(user,theBook);
        bookRequestRepository.save(bookRequest);
        redirectAttributes.addFlashAttribute("message","info|The book request is placed.");

        return "redirect:../";

    }

}
