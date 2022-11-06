package com.example.bialitski.rock_festival.controller;

import com.example.bialitski.rock_festival.model.Artist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
@Controller
public class MainController {
public static List<Artist> artists = new ArrayList<Artist>();
static {
    artists.add(new Artist("Marilyn Manson","We Are Chaos"));
    artists.add(new Artist("Rob Zombie","The Lunar Injection Kool Aid Eclipse Conspiracy"));
}

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        return modelAndView;
    }




}
