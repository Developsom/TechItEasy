package com.example.techiteasy;


import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {
    @GetMapping("television");

    @GetMapping("television/{id}");

    @PutMapping("television");

    @PostMapping("television");

    @DeleteMapping("television");


}
