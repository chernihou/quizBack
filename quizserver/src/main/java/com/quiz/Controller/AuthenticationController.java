
package com.quiz.Controller;

import com.quiz.Config.JwtUtils;
import com.quiz.Service.Impl.UserDetailsServiceImpl;
import com.quiz.entity.JwtRequest;
import com.quiz.entity.JwtResponse;
import com.quiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    //Generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{

            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }
        //Authenticate
        UserDetails userDetails= this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

        //    //Generate token
        //    @PostMapping("/generate-token")
        //    public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception {
        //
        //        this.authenticate(request.getUsername(), request.getPassword());
        //
        //        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        //
        //        String token = this.jwtUtils.generateToken(userDetails);
        //
        //        JwtResponse response = new JwtResponse();
        //        response.setToken(token);
        //        return new ResponseEntity<JwtResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch(DisabledException e){
            throw new Exception("User Disabled " +e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials " +e.getMessage());
        }

    }

    //return details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ( (User)this.userDetailsService.loadUserByUsername(principal.getName()));


    }
}
