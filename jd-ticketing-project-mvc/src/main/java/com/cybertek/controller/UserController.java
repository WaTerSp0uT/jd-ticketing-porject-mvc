package com.cybertek.controller;


import com.cybertek.dto.UserDTO;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    //Injection
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    //,"/add","/initialize"
    @GetMapping({"/create"})
    public String createUser(Model model){


        model.addAttribute("user", new UserDTO());
        //data generator
        //Since this class - UserController has dependecies from Role I need to inject dependencies
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user, Model model){

        userService.save(user);
        //user, role users

        //        model.addAttribute("user", new UserDTO());
        //        model.addAttribute("roles", roleService.findAll());
        //        model.addAttribute("users", userService.findAll());


        //redirect will always run @GetMapping
        //redirect just avoids repete of actions like just comment above
        return "redirect:/user/create"; //instead of going to create.html how about if I call the createuser method

    }


    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        //Service findByID will get specific data for particullar UserId and will assing to user for next population
        model.addAttribute("user", userService.findById(username));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());

        return "/user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, UserDTO user, Model model){
        //deleting updating
        userService.update(user);



//        model.addAttribute("user", new UserDTO());
//        //data generator
//        //Since this class - UserController has dependecies from Role I need to inject dependencies
//        model.addAttribute("roles", roleService.findAll());
//        model.addAttribute("users", userService.findAll());

        //redirect just avoids repete of actions like just comment above
        return "redirect:/user/create";
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username, UserDTO user, Model model){
        //deleting updating
        userService.deleteByID(username);

        //redirect just avoids repete of actions like just comment above
        return "redirect:/user/create";
    }
}
