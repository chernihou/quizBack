package com.quiz.Service;

import com.quiz.entity.User;
import com.quiz.entity.UserRole;

import java.util.Set;

public interface UserService {

    //Creating User
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception;

    // get user by username
    public User getUser(String username);

    // delete user by id
    public void deleteUser(Long userid);
}
