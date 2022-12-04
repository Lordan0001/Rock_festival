package com.example.bialitski.rock_festival.controller;

import com.example.bialitski.rock_festival.interfaces.AlbumsRepository;
import com.example.bialitski.rock_festival.interfaces.CitiesRepository;
import com.example.bialitski.rock_festival.interfaces.GroupsRepository;
import com.example.bialitski.rock_festival.model.Albums;
import com.example.bialitski.rock_festival.model.Cities;
import com.example.bialitski.rock_festival.model.Groups;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
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

    private static Logger logger = LogManager.getRootLogger();

    public Object principal;
    public String remoteUsername;

    //main page
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", greetings);
        logger.info("Open main page");
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
        logger.info("Open group list page");
        return modelAndView;
    }

    //All Albums
    @GetMapping("/AlbumsList")
    public String listAllAlbums(Model model) {
        List<Albums> listAlbums = albumsRepo.findAll();
        model.addAttribute("listAlbums", listAlbums);
        model.addAttribute("albumListMessage", albumListMessage);
        logger.info("Open album list page");
        return "AlbumsList";
    }


    //order
    @RequestMapping("/ManageTicketList")
    public ModelAndView ManageTicket(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageTicketList");
        model.addAttribute("listTickets", GetCurrentList());
        logger.info("Open manage ticket page");
        return modelAndView;
    }


    public List<Cities> GetCurrentList(){
        principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        remoteUsername = ((UserDetails) principal).getUsername();
        List<Cities> listTickets = citiesRepo.getTicketsByUsername(remoteUsername);
        return listTickets;
    }

    @RequestMapping("/addTicket")
    public ModelAndView saveTicket(Cities cities) {
        citiesRepo.save(cities);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageTicketList");
        modelAndView.addObject("listTickets", GetCurrentList());
        logger.info("Ticket added");
        return modelAndView;
    }

    @RequestMapping("/deleteTicket")
    public ModelAndView deleteTicket(@RequestParam("Id") long Id) {
        citiesRepo.deleteById(Id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageTicketList");
        modelAndView.addObject("listTickets", GetCurrentList());
        logger.info("Ticket deleted");
        return modelAndView;
    }


    @GetMapping("/News")
    public String NewsPage(Model model) {
        logger.info("Open news page");
        return "News";
    }

    @GetMapping("/About")
    public String AboutPage(Model model) {
        logger.info("Open about page");
        return "About";
    }


}
