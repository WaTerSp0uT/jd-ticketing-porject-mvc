package com.cybertek.controller;


import com.cybertek.dto.UserDTO;
import com.cybertek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //Injection
    @Autowired
    RoleService roleService;

    @GetMapping({"/create","/add","/initialize"})
    public String createUser(Model model){
        model.addAttribute("user", new UserDTO());

        //datagenerator
        //Since this class - UserController has dependecies from Role I need to inject dependencies
        model.addAttribute("roles", roleService.findAll());

        return "/user/create";
    }
}
