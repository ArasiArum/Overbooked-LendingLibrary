package org.launchcode.lendinglibrary.controllers;

import org.launchcode.lendinglibrary.models.Genre;
import org.launchcode.lendinglibrary.models.data.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("title","All Genres");
        model.addAttribute("genres", genreRepository.findAll());
        return "genres/index";
    }



    @GetMapping("create")
    public String displayCreateGenreForm(Model model) {
        model.addAttribute("title","Create Genre");
        model.addAttribute(new Genre());
        return "genres/create";
    }

    @PostMapping("create")
    public String processCreateGenreForm(@Valid @ModelAttribute Genre genre, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title","Create Genre");
            model.addAttribute(new Genre());
            return "genres/create";
        }

        genreRepository.save(genre);
        return "redirect:";
    }





}
