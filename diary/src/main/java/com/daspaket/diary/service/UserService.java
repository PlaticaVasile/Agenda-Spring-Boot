package com.daspaket.diary.service;

import com.daspaket.diary.model.User;

import java.util.List;

public interface UserService
{
    //
    //declaram signatura functiilor pe care le explicitam in UserServiceImpl
    public List<User> getAllUsers();
    public User findUserById(int id);
    public User findUserByUsername(String username);
    public User findUserByUserNew(User user);
    public User loginProcess(String username, String password);
    public User addUser(User user);
    public List<String> displayType();
}
