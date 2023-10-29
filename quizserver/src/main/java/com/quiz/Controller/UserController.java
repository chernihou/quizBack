package com.quiz.Controller;


import com.quiz.Service.UserService;
import com.quiz.entity.Role;
import com.quiz.entity.User;
import com.quiz.entity.UserRole;
import com.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception{
        //encoding password with Bcryptpasswordencoder
         user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles=new HashSet<>();

        Role role= new Role();
        role.setRoleid(45L);
        role.setRolename("NORMAL");

        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.creatUser(user, roles);
    }

    // get the user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    // delete the user by id
    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid){
        this.userService.deleteUser(userid);
    }
}
