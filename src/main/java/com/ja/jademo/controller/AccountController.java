package com.ja.jademo.controller;

import com.ja.jademo.model.User;
import com.ja.jademo.repository.UserRepository;
import com.ja.jademo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {

        return "account/login";
    }

    @GetMapping("/register")
    public String register() {

        return "account/register";
    }
    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/account/admin";
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userService.deleteOne(id);
        ModelAndView nextView = new ModelAndView();
        nextView.setView(new RedirectView("/account/admin?memberNumber=2", true));
        List<User> list = userService.findAll();
        nextView.addObject("userList", list);
        return nextView;
    }

    /*
    @DeleteMapping("/admin")
    public String Delete(@ModelAttribute User user){
        userService.delete(user);
        return "redirect:/account/admin";

    }*/



}
