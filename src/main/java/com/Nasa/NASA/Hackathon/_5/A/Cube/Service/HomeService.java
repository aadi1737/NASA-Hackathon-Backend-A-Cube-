package com.Nasa.NASA.Hackathon._5.A.Cube.Service;

import com.Nasa.NASA.Hackathon._5.A.Cube.Application;
import com.Nasa.NASA.Hackathon._5.A.Cube.Model.RAGRequest;
import com.Nasa.NASA.Hackathon._5.A.Cube.Model.RAGResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeService {

    private final RestTemplate restTemplate;

    @Autowired
    public HomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private final String SEARCH_API="https://nasaapi-724j.onrender.com/api/v1/summarize/" ;

    public ResponseEntity<?> searchInRAG(String query){

        RAGRequest body = new RAGRequest();
        body.setText(query);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RAGRequest> request = new HttpEntity<>(body,headers);

        RAGResponse ragResponse = restTemplate.postForObject(SEARCH_API, request, RAGResponse.class);

        return new ResponseEntity<>(ragResponse, HttpStatus.OK);
    }


}
