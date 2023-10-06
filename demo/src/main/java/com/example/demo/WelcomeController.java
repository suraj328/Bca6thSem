package com.example.demo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class WelcomeController {
    @RequestMapping("/")
    public String welcomeMessage(){
        return "Welcome to sSpring Boot";
    }
    //post request
    @RequestMapping("/post")
    public String postMessage(){
        return "post example";
    }
    @PostMapping("/jsonPost")
    public ResponseEntity<String> postJson(@RequestBody HashMap<String, Object> request) {
        System.err.println(request.toString());
        HashMap < String,Object> hashMap = request;
        int size = hashMap.size();
        if(size==0){
            hashMap.put("response", "no json data found");
            hashMap.put("status", "200");
        }
        return ResponseEntity.ok("Received JSON: " + hashMap.toString());
    }
    @PostMapping("/postQuery")
    public ResponseEntity<String> handlePostRequest
    (
        @RequestParam("name") String name,
        @RequestParam("age") int age
        
    ) {
        System.out.println("name: " + name +" age: "+age);
        return ResponseEntity.ok("name: " + name +" age: "+age);
    }
    //request for handling file
    @PostMapping("/postFile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Get the file's original name
            String originalFileName = file.getOriginalFilename();

            // Define the directory to save the uploaded files (adjust as needed)
            String uploadDirectory = "C:/uploads/";

            // Create the directory if it doesn't exist
            File directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the file to the specified directory
            File uploadedFile = new File(directory, originalFileName);
            file.transferTo(uploadedFile);

            return new ResponseEntity<>("File uploaded successfully.", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload the file.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // jsonPost with file
    @PostMapping("/jsonPostFile")
    public ResponseEntity<String> postJsonFile(@RequestBody HashMap<String, Object> request) {
        System.err.println(request.toString());
        HashMap < String,Object> hashMap = request;
        int size = hashMap.size();
        if(size==0){
            hashMap.put("response", "no json data found");
            hashMap.put("status", "200");
        }
        return ResponseEntity.ok("Received JSON: " + hashMap.toString());
    }

}
