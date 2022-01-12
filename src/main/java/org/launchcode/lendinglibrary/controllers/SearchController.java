package org.launchcode.lendinglibrary.controllers;

import org.launchcode.lendinglibrary.models.Book;
import org.launchcode.lendinglibrary.models.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/search")
    public String search(@RequestParam String searchTerm , Model model) {

        List<Book> searchResults = bookRepository.search(searchTerm);
        model.addAttribute("searchTerm",searchTerm);
        model.addAttribute("title","Search Results for " + searchTerm);
        model.addAttribute("searchResults", searchResults);
        return "search";
    }
}
