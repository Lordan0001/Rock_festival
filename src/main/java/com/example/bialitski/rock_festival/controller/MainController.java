package com.example.bialitski.rock_festival.controller;

import com.example.bialitski.rock_festival.interfaces.CustomerRepository;
import com.example.bialitski.rock_festival.model.Artist;
import com.example.bialitski.rock_festival.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private CustomerRepository customerRepo;
    @Value("${welcome.message}")
    private String greetings;

    @Value("${groups.msg}")
    private String grList;


//main page
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", greetings);
        return modelAndView;
    }

    //all artists
    @RequestMapping(value = {"/artistList"}, method = RequestMethod.GET)
    public ModelAndView artistList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("artistList");
        model.addAttribute("music", artists);

        model.addAttribute("grList", grList);
        return modelAndView;
    }


//Temp
@GetMapping("/customers")
public String listAll(Model model) {
    List<Customer> listCustomers = customerRepo.findAll();
    model.addAttribute("listCustomers", listCustomers);

    return "customers";
}

}
