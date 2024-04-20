package com.daspaket.diary.service;

import com.daspaket.diary.model.User;
import com.daspaket.diary.repository.UserNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    //
    @Autowired
    private UserNewRepository repo;
    @Override
    public List<User> getAllUsers()
    {
        //
        return repo.findAll();
    }
    @Override
    public User findUserById(int id)
    {
        //
        return repo.findById(id).get();
    }
    @Override
    public User findUserByUsername(String username)
    {
        Optional<User> userOptional = repo.findByNameRepo(username);
        if(userOptional.isPresent())
        {
            //User user = userOptional.get();
            return userOptional.get();
        }
        else
        {
            return null; // Handle null if the user doesn't exist
        }
        //return userOptional; fail
        //return repo.findByNameRepo(username);
    }
    public User loginProcess(String username, String password)
    {
        //
        Optional<User> userOptional = repo.loginProcessRepo(username, password);
        if(userOptional.isPresent())
        {
            //User user = userOptional.get(); return user;
            return userOptional.get();
        }
        else
        {
            return null;
        }
    }
    public User addUser(User user)
    {
        return repo.save(user);
    }
    public User findUserByUserNew(User user)
    {
        //
        Optional<User> userOptional = repo.findUserByUserNewRepo(user.getUsername(), user.getPassword(), user.getEmail(), user.getType());
        if(userOptional.isPresent())
        {
            return userOptional.get();//conversie din tipul Optional in tipul modelului meu, User
        }
        else
        {
            return null;
        }
    }
    public List<String> displayType()
    {
        //
        List<String> StringList = repo.displayTypeRepo();
        if(!StringList.isEmpty())
        {
            return StringList;//
        }
        else
        {
            return null;
        }
    }
}
