package com.example.bialitski.rock_festival.controller;

import com.example.bialitski.rock_festival.interfaces.AlbumsRepository;
import com.example.bialitski.rock_festival.interfaces.CitiesRepository;
import com.example.bialitski.rock_festival.interfaces.GroupsRepository;
import com.example.bialitski.rock_festival.model.Albums;
import com.example.bialitski.rock_festival.model.Cities;
import com.example.bialitski.rock_festival.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AlbumsRepository albumsRepo;

    @Autowired
    private CitiesRepository citiesRepo;

    @Autowired
    private GroupsRepository groupsRepo;

    @Value("${welcome.message}")
    private String greetings;

    @Value("${groups.msg}")
    private String groupListMessage;

    @Value("${albums.msg}")
    private String albumListMessage;

    //main page
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", greetings);
        return modelAndView;
    }

    //all groups
    @RequestMapping(value = {"/GroupList"}, method = RequestMethod.GET)
    public ModelAndView groupList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("GroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        model.addAttribute("listGroups", listGroups);

        model.addAttribute("groupListMessage", groupListMessage);//message
        return modelAndView;
    }

    //All Albums
    @GetMapping("/AlbumsList")
    public String listAllAlbums(Model model) {
        List<Albums> listAlbums = albumsRepo.findAll();
        model.addAttribute("listAlbums", listAlbums);
        model.addAttribute("albumListMessage", albumListMessage);
        return "AlbumsList";
    }


    //order
    @RequestMapping("/ManageTicketList")
    public ModelAndView ManageTicket(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageTicketList");
        List<Cities> listTickets = citiesRepo.findAll();

        model.addAttribute("listTickets", listTickets);
        return modelAndView;
    }

    @RequestMapping("/addTicket")
    public ModelAndView saveTicket(Cities cities) {
        citiesRepo.save(cities);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageTicketList");
        List<Cities> listTickets = citiesRepo.findAll();

        modelAndView.addObject("listTickets", listTickets);
        return modelAndView;
    }

    @RequestMapping("/deleteTicket")
    public ModelAndView deleteTicket(@RequestParam("Id") long Id) {
        citiesRepo.deleteById(Id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageTicketList");
        List<Cities> listTickets = citiesRepo.findAll();

        modelAndView.addObject("listTickets", listTickets);
        return modelAndView;
    }



    @GetMapping("/News")
    public String NewsPage(Model model) {

        return "News";
    }

    @GetMapping("/About")
    public String AboutPage(Model model) {

        return "About";
    }


}
