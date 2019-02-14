package com.controller;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import com.repository.UserHibernateRepository;
import com.repository.UserRepository;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class WebController {

    private UserService userService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getIndex() {
//        return "index";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("add_user");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
//        Set<User> users = userService.getAllUsers();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("users", users);
//        modelAndView.setViewName("get_all");
        return getUsers();
    }

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        Set<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("get_all");
        return modelAndView;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam("id") long id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("get_user");
        return modelAndView;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView removeUser(@RequestParam("id") long id) {
        userService.removeUser(id);
        return getUsers();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updatePage(@RequestParam("id") long id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("update_user");
        return modelAndView;
    }
}
