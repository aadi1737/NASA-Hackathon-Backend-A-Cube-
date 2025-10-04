package com.Nasa.NASA.Hackathon._5.A.Cube.Service;

import com.Nasa.NASA.Hackathon._5.A.Cube.Model.AIFrontendRequest;
import com.Nasa.NASA.Hackathon._5.A.Cube.Model.AIRAGResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class AIService {

    private final String AI_CHAT_API="https://nasaapi-724j.onrender.com/api/v1/chatbot/message";
    private final RestTemplate restTemplate;
    @Autowired
    public AIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ResponseEntity<?> getDataFromRAG(String message){

        try {
            AIFrontendRequest body = new AIFrontendRequest();
            body.setMessage(message);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<AIFrontendRequest> request = new HttpEntity<>(body, headers);

            AIRAGResponse airagResponse = restTemplate.postForObject(AI_CHAT_API, request, AIRAGResponse.class);

            System.out.println("\nResponse-\n" + airagResponse);
            return new ResponseEntity<>(airagResponse, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
