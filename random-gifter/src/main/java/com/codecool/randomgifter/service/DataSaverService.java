package com.codecool.randomgifter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataSaverService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("data-server.url")
    private String dataSaverUrl;

    public void createPerson(String person) {
        HttpEntity<String> request = new HttpEntity<>(person);
        restTemplate.postForEntity(dataSaverUrl, request, String.class);
    }


}
