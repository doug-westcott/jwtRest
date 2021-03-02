package com.example.demo.controller;

import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = "/courses/{id}", method = {RequestMethod.GET})
    public ResponseEntity<?> course(@PathVariable Long id) {
        return ResponseEntity.ok(productRepository.findById(id));
    }

    @RequestMapping(path = "/courses", method = {RequestMethod.GET})
    public ResponseEntity<?> courses() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @RequestMapping(path = "/courses/findByNameContaining/{name}", method = {RequestMethod.GET})
    public ResponseEntity<?> courses(@PathVariable String name) {
        return ResponseEntity.ok(productRepository.findByNameContaining(name));
    }
}

