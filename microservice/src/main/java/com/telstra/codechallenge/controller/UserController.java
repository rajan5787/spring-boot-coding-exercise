package com.telstra.codechallenge.controller;

import com.telstra.codechallenge.model.Repository;
import com.telstra.codechallenge.model.User;
import com.telstra.codechallenge.service.RepositoryService;
import com.telstra.codechallenge.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(
            UserService userService) {
        this.userService = userService;
    }

    // Get users with zero followers
    @RequestMapping(path = "/users/zeroFollowers/{count}", method = RequestMethod.GET)
    public List<User> getUserWithZeroFollowers(@PathVariable("count") int count) {
        return userService.getUserWithZeroFollowers(count);
    }

}
