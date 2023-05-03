package com.trip.model.service;

import com.trip.dto.User;

public interface UserService {
    boolean signIn(User user);
    boolean signUp(User user);
    User userDetail(String id);
    boolean modify(String name, String id);
    void delete(String id);
}
