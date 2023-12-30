package com.example.sampleproject.controller;

import com.example.sampleproject.model.Application;
import com.example.sampleproject.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/create/application")
    public ResponseEntity<Application> create(@RequestBody Application application){
        return ResponseEntity.ok(applicationService.createApp(application));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createApplication(){
    UUID uuid = UUID.randomUUID();
    Application application = new Application();
        application.setId(uuid);
        applicationService.create(application);
        return ResponseEntity.ok("Entity created with ID: " + uuid.toString());
}
}
