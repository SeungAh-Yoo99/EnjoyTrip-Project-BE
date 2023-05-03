package com.trip.model.service;

import com.trip.dto.User;
import com.trip.model.dao.UserDAO;
import com.trip.model.dao.UserDAOImpl;

public class UserServiceImpl implements UserService{

    UserDAO dao;

    public UserServiceImpl() {
        dao = new UserDAOImpl();
    }

    @Override
    public boolean signIn(User user) {
        return dao.signIn(user);
    }

    @Override
    public boolean signUp(User user) {
        return dao.signUp(user);
    }

    public User userDetail(String id){
        return dao.userDetail(id);
    }

    public boolean modify(String name, String id){
        return dao.modify(name, id);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
