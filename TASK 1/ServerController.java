package com.example.demo.controller;

import com.example.demo.model.Server;
import com.example.demo.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping
    public ResponseEntity<List<Server>> findAll() {
        List<Server> servers = serverService.findAll();
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Server> findById(@PathVariable String id) {
        Optional<Server> server = serverService.findById(id);
        return server.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Server>> findByName(@RequestParam String name) {
        List<Server> servers = serverService.findByName(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Server> save(@RequestBody Server server) {
        return new ResponseEntity<>(serverService.save(server), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
