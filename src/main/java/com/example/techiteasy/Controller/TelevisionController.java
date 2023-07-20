package com.example.techiteasy.Controller;


import com.example.techiteasy.Exceptions.RecordNotFoundException;
import com.example.techiteasy.Model.Television;
import com.example.techiteasy.Repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {

    @Autowired
    TelevisionRepository repo;

    @GetMapping("television")
    public ResponseEntity<List> getAllTelevisions() {
        return ResponseEntity.ok(repo.findAll());
    }


    @GetMapping("television/{id}")
    public ResponseEntity<String> GetTvWithId(@PathVariable int id) {

        if (id == 5) {
            throw new RecordNotFoundException("Novi is de beste");
        }
        return ResponseEntity.ok("television: " + id);
    }

    @PutMapping("television/{id}")
    public ResponseEntity<String> updateTvList(@PathVariable int id, @RequestParam String name) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Television> addTvList(@RequestBody Television television){
        repo.save(television);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + television.getId()).toUriString());

        return ResponseEntity.created(uri).body(television);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name){
        repo.deleteByName(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Television> findTvByName(@PathVariable String name){
        Optional <Television> optionaltv = repo.findByName(name);
        return optionaltv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
