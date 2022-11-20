package com.example.bialitski.rock_festival.controller;

import com.example.bialitski.rock_festival.interfaces.AlbumsRepository;
import com.example.bialitski.rock_festival.interfaces.GroupsRepository;
import com.example.bialitski.rock_festival.model.Albums;
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

    //Manage Group List
    @RequestMapping("/ManageGroupList")
    public ModelAndView ManageGroup(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageGroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        model.addAttribute("listGroups", listGroups);
        return modelAndView;
    }

    @RequestMapping("/addGroup")
    public ModelAndView saveGroup(Groups groups) {
        groupsRepo.save(groups);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageGroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        modelAndView.addObject("listGroups", listGroups);
        return modelAndView;
    }

    @RequestMapping("/deleteGroup")
    public ModelAndView deleteGroup(@RequestParam("Id") long Id) {
        groupsRepo.deleteById(Id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageGroupList");
        List<Groups> listGroups = groupsRepo.findAll();

        modelAndView.addObject("listGroups", listGroups);
             return modelAndView;
    }

    //Manage Album List
    @RequestMapping("/ManageAlbumList")
    public ModelAndView ManageAlbum(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageAlbumList");
        List<Albums> listAlbums = albumsRepo.findAll();

        model.addAttribute("listAlbums", listAlbums);
        return modelAndView;
    }
    @RequestMapping("/addAlbum")
    public ModelAndView saveAlbum(Albums albums) {
       albumsRepo.save(albums);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageAlbumList");
        List<Albums> listAlbums = albumsRepo.findAll();

        modelAndView.addObject("listAlbums", listAlbums);
        return modelAndView;
    }

    @RequestMapping("/deleteAlbum")
    public ModelAndView deleteAlbum(@RequestParam("Id") long Id) {
        albumsRepo.deleteById(Id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageAlbumList");
        List<Albums> listAlbums = albumsRepo.findAll();

        modelAndView.addObject("listAlbums", listAlbums);
        return modelAndView;
    }



}
