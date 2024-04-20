package com.daspaket.diary.controller;

import com.daspaket.diary.model.User;
import com.daspaket.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController
{
    @Autowired
    private UserService service;
    @GetMapping(path = "/all")
    public List<User> show()
    {
        //
        return service.getAllUsers();
    }
    @GetMapping(path = "/{id}")
    public User findStudentById(@PathVariable int id)

    {
        return service.findUserById(id);
    }
    @GetMapping(path = "/search")
    public String findStudentById(@RequestParam String username)
    {
        //@RequestBody implies that I must use all the fields and is used for POST METHOD(add data)
        //example: localhost:8080/user/search?username=Stefan32
        System.out.println(username);
        if(service.findUserByUsername(username) != null)
        {
            return service.findUserByUsername(username).toString();
        }
        else
        {
            return "You request has failed, check your submitted data again!";
        }
    }
    @PostMapping(path = "/login")
    public String loginController(@RequestBody User user)
    {
        if(service.loginProcess(user.getUsername(), user.getPassword()) != null)
        {
            //return service.loginProcess(user.getUsername(), user.getPassword());
            return "Login successful!";
        }
        else
        {
            return "Login failed, please try again or reset your password.";
        }
    }
    @PutMapping(path = "/add")
    public String addUserController(@RequestBody User user)
    {
        //se impune si o verificare dupa introducere in DB ptr a fi siguri ca s-a introdus inregistrarea
        service.addUser(user);
        if(service.findUserByUserNew(user) != null)
        {
            return "New field added with success";
        }
        else
        {
            return "New field failed to be added";
        }
    }
    @GetMapping(path = "/type")
    public String displayTypeController()
    {
        String s = "";
        List<String> list = service.displayType();

        s += "[\"" + list.get(0) + "\", ";
        for(int i = 1;i < list.size() - 1; i++)
        {
            s += "\"";
            s += list.get(i);
            s += "\", ";
        }
        s += "\"" + list.get(list.size() - 1) + "\"]";
        return s;
        //return service.displayType().toString();
        //return "Types fetched successfully!";
    }
}