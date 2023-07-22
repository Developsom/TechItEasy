package com.example.techiteasy.Controller;
import com.example.techiteasy.Dto.Output.TelevisionOutputDto;
import com.example.techiteasy.Exceptions.RecordNotFoundException;
import com.example.techiteasy.Model.Television;
import com.example.techiteasy.Services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;





@RestController
@RequestMapping(value = "/televisions")
public class TelevisionController {

        //Modern @Autowired: Constructor injection
    private final TelevisionService televisionService;
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }



        ////Get methods

    @GetMapping()
    public ResponseEntity<List> getAllTelevisions() {
        List<TelevisionOutputDto> TelevisionOutput = televisionService.getAllTelevisions();
        return ResponseEntity.ok(TelevisionOutput);
    }

    @GetMapping("television/{id}")
    public ResponseEntity<String> GetTvWithId(@PathVariable int id) {

        if (id == 5) {
            throw new RecordNotFoundException("Novi is de beste");
        }
        return ResponseEntity.ok("television: " + id);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Television> findTvByName(@PathVariable String name){
        Optional <Television> optionaltv = televisionService./*Create corresponding method in Service*/(name);
        return optionaltv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }





            //Put methods

    @PutMapping("television/{id}")
    public ResponseEntity<String> updateTvList(@PathVariable int id, @RequestParam String name) {
        return ResponseEntity.noContent().build();
    }







            //Post methods

    @PostMapping
    public ResponseEntity<Television> addTvList(@RequestBody Television television){
        televisionService./*Create corresponding method in Service*/(television);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + television.getId()).toUriString());

        return ResponseEntity.created(uri).body(television);
    }






                //Delete methods


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable Long id) {
        televisionService./*Create corresponding method in Service*/(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name){
        televisionService./*Create corresponding method in Service*/(name);
        return ResponseEntity.noContent().build();
    }


}
