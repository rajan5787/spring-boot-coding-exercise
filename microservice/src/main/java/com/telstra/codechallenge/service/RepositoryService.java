package com.telstra.codechallenge.service;

import com.telstra.codechallenge.model.Repository;
import com.telstra.codechallenge.model.RepositoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class RepositoryService {

    @Value("${github.base.url}")
    private String gitHubBaseUrl;

    private RestTemplate restTemplate;

    public RepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Repository> getHottestRepositories(int count) {

        String postUrl = "/repositories?q=created:>" + getDate() + "&sort=stars&order=desc&per_page="+count;
        RepositoryResponse response = restTemplate.getForObject(gitHubBaseUrl + postUrl, RepositoryResponse.class);

        return response.getRepositoryList();
    }

    private String getDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-7);

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return timeStamp;
    }
}
