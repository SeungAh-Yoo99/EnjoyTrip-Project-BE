package com.trip.model.dao;

import com.trip.dto.User;

import java.util.ArrayList;

public interface UserDAO {

    boolean signIn(User user);
    boolean signUp(User user);
    ArrayList<User> selectAll();
    boolean modify(String name,String id);
    User userDetail(String id);
    void delete(String id);
}
