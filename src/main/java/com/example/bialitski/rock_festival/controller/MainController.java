package com.example.bialitski.rock_festival.controller;

import com.example.bialitski.rock_festival.interfaces.AlbumsRepository;
import com.example.bialitski.rock_festival.interfaces.GroupsRepository;
import com.example.bialitski.rock_festival.model.Albums;
import com.example.bialitski.rock_festival.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    private GroupsRepository groupsRepo;

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

    //all groups
    @RequestMapping(value = {"/GroupList"}, method = RequestMethod.GET)
    public ModelAndView groupList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("GroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        model.addAttribute("listGroups", listGroups);

        model.addAttribute("grList", grList);//message
        return modelAndView;
    }


    @GetMapping("/AlbumsList")
    public String listAllAlbums(Model model) {
        List<Albums> listAlbums = albumsRepo.findAll();
        model.addAttribute("listAlbums", listAlbums);

        return "AlbumsList";
    }

    //test
    @RequestMapping("/ManageGroupList")
    public ModelAndView Manage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageGroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        model.addAttribute("listGroups", listGroups);
        return modelAndView;
    }

    @RequestMapping("/addGroup")
    public ModelAndView saveData(Groups groups) {
        groupsRepo.save(groups);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageGroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        modelAndView.addObject("listGroups", listGroups);
        return modelAndView;
    }

    @RequestMapping("/deleteGroup")
    public ModelAndView deleteData(@RequestParam("Id") long Id) {
        groupsRepo.deleteById(Id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageGroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        modelAndView.addObject("listGroups", listGroups);
             return modelAndView;
    }



}
