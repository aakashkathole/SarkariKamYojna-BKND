package com.sarkaryKamYojana.Controller;

import com.sarkaryKamYojana.Entity.Yojana;
import com.sarkaryKamYojana.Service.YojanaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Yojana")
@CrossOrigin(origins = "*")
public class YojanaController {

    private final YojanaService service;

    public YojanaController(YojanaService service) {
        this.service = service;
    }


    @PostMapping("/createYojana")
    public ResponseEntity<Yojana> create(
            @RequestBody Yojana yojana) {

        return new ResponseEntity<>(
                service.createmahilaYojana(yojana),
                HttpStatus.CREATED);
    }


    @GetMapping("/getallYojana")
    public ResponseEntity<List<Yojana>> getAll() {
        return new ResponseEntity<>(
                service.getallMahilaYojana(),
                HttpStatus.OK);
    }


    @GetMapping("/getbyIdYojana/{id}")
    public ResponseEntity<Yojana> getById(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.getbyIdMahilaYojana(id),
                HttpStatus.OK);
    }

    @PutMapping("/updateYojana/{id}")
    public ResponseEntity<Yojana> update(
            @PathVariable Long id,
            @RequestBody Yojana yojana) {

        return new ResponseEntity<>(
                service.updateMahilaYojana(id, yojana),
                HttpStatus.OK);
    }


    @DeleteMapping("/deleteYojana/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        service.MahilaYojana(id);

        return new ResponseEntity<>(
                "Yojana deleted successfully",
                HttpStatus.OK);
    }
}
