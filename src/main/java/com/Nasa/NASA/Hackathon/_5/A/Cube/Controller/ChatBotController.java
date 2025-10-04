package com.Nasa.NASA.Hackathon._5.A.Cube.Controller;

import com.Nasa.NASA.Hackathon._5.A.Cube.Model.AIFrontendRequest;
import com.Nasa.NASA.Hackathon._5.A.Cube.Service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {

    @Autowired
    private AIService aiService;

    @PostMapping("/ai-chat")
    public ResponseEntity<?> getData(@RequestBody AIFrontendRequest aiFrontendRequest){
        if(aiFrontendRequest!=null) {
            String message = aiFrontendRequest.getMessage();
            ResponseEntity<?> dataFromRAG = aiService.getDataFromRAG(message);
            return dataFromRAG;
        } else
            return new ResponseEntity<>("RequestBody is Empty!", HttpStatus.BAD_REQUEST);
    }

}
