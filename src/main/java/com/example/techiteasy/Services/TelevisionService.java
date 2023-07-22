package com.example.techiteasy.Services;
import com.example.techiteasy.Repository.TelevisionRepository;
import org.springframework.stereotype.Service;





@Service
public class TelevisionService {

    //Onderstaande code block koppelt de repository aan de service laag
    private final TelevisionRepository repo;
    public TelevisionService(TelevisionRepository repo) {
        this.repo = repo;
    }
}
