package com.telstra.codechallenge.controller;

import com.telstra.codechallenge.model.Repository;
import com.telstra.codechallenge.service.RepositoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepositoryController {
    private RepositoryService repositoryService;

    public RepositoryController(
            RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    // Get Hottest Repositories
    @RequestMapping(path = "/repositories/hottest/{count}", method = RequestMethod.GET)
    public List<Repository> quotes(@PathVariable("count") int count) {
        return repositoryService.getHottestRepositories(count);
    }

}
