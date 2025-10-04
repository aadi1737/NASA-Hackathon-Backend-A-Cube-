package com.Nasa.NASA.Hackathon._5.A.Cube.Controller;

import com.Nasa.NASA.Hackathon._5.A.Cube.Model.FrontendRequest;
import com.Nasa.NASA.Hackathon._5.A.Cube.Model.RAGRequest;
import com.Nasa.NASA.Hackathon._5.A.Cube.Model.RAGResponse;
import com.Nasa.NASA.Hackathon._5.A.Cube.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Yes i am Alive!";
    }


    @PostMapping("/search")
    public ResponseEntity<?> searchHome(@RequestBody FrontendRequest frontendRequest){
        ResponseEntity<?> responseEntity = homeService.searchInRAG(frontendRequest.getText());
        return responseEntity;
    }

}
