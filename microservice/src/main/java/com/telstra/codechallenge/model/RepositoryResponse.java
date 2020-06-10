package com.telstra.codechallenge.model;

import lombok.Data;

import java.util.List;

@Data
public class RepositoryResponse {

    private List<Repository> items;

    public List<Repository> getRepositoryList(){
        return this.items;
    }

    public int getRepositoryCount(){
        return this.items.size();
    }

}
