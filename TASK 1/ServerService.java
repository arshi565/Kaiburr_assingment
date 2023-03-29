package com.example.demo.service;

import com.example.demo.model.Server;
import com.example.demo.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> findAll() {
        return serverRepository.findAll();
    }

    public Optional<Server> findById(String id) {
        return serverRepository.findById(id);
    }

    public List<Server> findByName(String name) {
        return serverRepository.findByNameContaining(name);
    }

    public Server save(Server server) {
        return serverRepository.save(server);
    }

    public void deleteById(String id) {
        serverRepository.deleteById(id);
    }
}
