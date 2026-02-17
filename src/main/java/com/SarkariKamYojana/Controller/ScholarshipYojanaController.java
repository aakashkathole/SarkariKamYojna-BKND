package com.SarkariKamYojana.Controller;

import com.SarkariKamYojana.Entity.ScholarshipYojana;
import com.SarkariKamYojana.Service.ScholarshipYojanaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scholarships")
@CrossOrigin(origins = "*")
public class ScholarshipYojanaController {

    private final ScholarshipYojanaService service;

    public ScholarshipYojanaController(ScholarshipYojanaService service) {
        this.service = service;
    }


    @PostMapping("/createscholarship")
    public ResponseEntity<ScholarshipYojana> create(@RequestBody ScholarshipYojana scholarshipYojana) {
        return ResponseEntity.ok(service.createScholarshipYojana(scholarshipYojana));
    }


    @GetMapping("/getAllscholarship")
    public ResponseEntity<List<ScholarshipYojana>> getAll() {
        return ResponseEntity.ok(service.getAllScholarshipYojana());
    }


    @GetMapping("/getByIdscholarship/{id}")
    public ResponseEntity<ScholarshipYojana> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByIdScholarshipYojana(id));
    }


    @PutMapping("/updatescholarship/{id}")
    public ResponseEntity<ScholarshipYojana> update(
            @PathVariable Long id,
            @RequestBody ScholarshipYojana scholarshipYojana) {

        return ResponseEntity.ok(service.updateScholarshipYojana(id, scholarshipYojana));
    }


    @DeleteMapping("/deletescholarship/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteScholarshipYojana(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
