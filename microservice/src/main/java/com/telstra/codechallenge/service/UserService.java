package com.telstra.codechallenge.service;

import com.telstra.codechallenge.model.RepositoryResponse;
import com.telstra.codechallenge.model.User;
import com.telstra.codechallenge.model.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Value("${github.base.url}")
    private String gitHubBaseUrl;

    private RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getUserWithZeroFollowers(int count){

        String postUrl = "/users?q=followers:0&sort=joined&order=asc&per_page="+count;
        UserResponse response = restTemplate.getForObject(gitHubBaseUrl + postUrl, UserResponse.class);
        return response.getUserList();
    }
}
