package com.telstra.codechallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Repository {

    private String Name;
    private String url;
    private String watchers_count;
    private String language;
    private String description;

}
