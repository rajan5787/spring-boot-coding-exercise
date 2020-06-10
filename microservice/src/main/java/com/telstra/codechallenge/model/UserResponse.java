package com.telstra.codechallenge.model;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private List<User> items;

    public List<User> getUserList(){
        return this.items;
    }

    public int getUserCount() { return this.items.size(); }

}
