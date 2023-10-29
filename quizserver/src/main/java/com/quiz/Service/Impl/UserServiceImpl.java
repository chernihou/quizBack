package com.quiz.Service.Impl;

import com.quiz.Service.UserService;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;
import com.quiz.repository.RoleRepository;
import com.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //Creating user
    @Override
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new Exception("User already present !!");
        } else {
            // user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

        user.getUserRoles().addAll(userRoles);
        this.userRepository.save(user);
    }
        return local;
    }

    //Getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);

    }

    @Override
    public void deleteUser(Long userid){
        this.userRepository.deleteById(userid);
    }
}
