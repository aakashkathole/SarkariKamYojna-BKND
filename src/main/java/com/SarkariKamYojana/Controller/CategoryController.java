package com.SarkariKamYojana.Controller;


import com.SarkariKamYojana.Entity.Category;
import com.SarkariKamYojana.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @PostMapping("/createCategory")
    public ResponseEntity<Category> createYojana(@RequestBody Category yojana) {
        Category saved = service.createYojana(yojana);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @GetMapping("/getallCategory")
    public ResponseEntity<List<Category>> getAllYojana() {
        return new ResponseEntity<>(service.getAllYojana(), HttpStatus.OK);
    }


    @GetMapping("/getbyidCategory/{id}")
    public ResponseEntity<Category> getYojanaById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getByidYojana(id), HttpStatus.OK);
    }


    @PutMapping("/updateCategorya/{id}")
    public ResponseEntity<Category> updateYojana(
            @PathVariable Long id,
            @RequestBody Category yojana) {

        Category updated = service.updateYojana(id, yojana);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteYojana(@PathVariable Long id) {
        service.deleteYojana(id);
        return new ResponseEntity<>("Yojana deleted successfully!", HttpStatus.OK);
    }
}
