package com.SarkariKamYojana.Controller;

import com.SarkariKamYojana.Entity.MahilaYojana;
import com.SarkariKamYojana.Service.MahilaYojanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mahilayojana")
@CrossOrigin("*")
public class MahilaYojanaController {


    @Autowired
    private  final  MahilaYojanaService service;

    public MahilaYojanaController(MahilaYojanaService service) {
        this.service = service;
    }


    @PostMapping("/createMahilaYojana")
    public MahilaYojana createMahilaYojana(@RequestBody MahilaYojana mahilaYojana)
    {
        return  service.createMahilaYojana(mahilaYojana);
    }

    @GetMapping("/getAllMahilaYojana")
    public List<MahilaYojana> getAllMahilaYojana()
    {
        return  service.getAllMahilaYojana();
    }


    @GetMapping("/GetByidMahilaYojana/{id}")
    public  MahilaYojana getByid(@PathVariable Long id)
    {
        return  service.getMahilaYojanaById(id);
    }

    @PutMapping("/updateMahilaYojana/{id}")
    public  MahilaYojana update(@PathVariable Long id, @RequestBody MahilaYojana mahilaYojana)
    {
        return  service.updateMahilaYojana(id, mahilaYojana);
    }


    @DeleteMapping("/deleteMahilaYojana/{id}")
    public  String delete(@PathVariable Long id)
    {
        service.deleteMahilaYojana(id);
        return "Deleted Successfully..!!";
    }


}
