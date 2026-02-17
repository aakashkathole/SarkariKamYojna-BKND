package com.SarkariKamYojana.ServiceImpl;

import com.SarkariKamYojana.Entity.Yojana;
import com.SarkariKamYojana.Entity.Category;
import com.SarkariKamYojana.Repository.YojanaRepository;
import com.SarkariKamYojana.Repository.CategoryRepository;
import com.SarkariKamYojana.Service.YojanaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YojanaServiceImpl implements YojanaService {

    private final YojanaRepository repository;
    private final CategoryRepository yojanaRepository;

    public YojanaServiceImpl(YojanaRepository repository,
                             CategoryRepository yojanaRepository) {
        this.repository = repository;
        this.yojanaRepository = yojanaRepository;
    }


    @Override
    public Yojana createmahilaYojana(Yojana mahilaYojana) {

        if (mahilaYojana.getYojana() == null ||
                mahilaYojana.getYojana().getId() == null) {
            throw new RuntimeException("Yojana ID must not be null");
        }

        Long yojanaId = mahilaYojana.getYojana().getId();

        Category yojana = yojanaRepository.findById(yojanaId)
                .orElseThrow(() ->
                        new RuntimeException("Yojana not found with id: " + yojanaId));

        mahilaYojana.setYojana(yojana);

        return repository.save(mahilaYojana);
    }


    @Override
    public List<Yojana> getallMahilaYojana() {
        return repository.findAll();
    }


    @Override
    public Yojana getbyIdMahilaYojana(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("MahilaYojana not found with id: " + id));
    }


    @Override
    public Yojana updateMahilaYojana(long id, Yojana mahilaYojana) {

        Yojana existing = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("MahilaYojana not found with id: " + id));

        // update name
        existing.setName(mahilaYojana.getName());

        // update yojana safely
        if (mahilaYojana.getYojana() != null &&
                mahilaYojana.getYojana().getId() != null) {

            Long yojanaId = mahilaYojana.getYojana().getId();

            Category yojana = yojanaRepository.findById(yojanaId)
                    .orElseThrow(() ->
                            new RuntimeException("Yojana not found with id: " + yojanaId));

            existing.setYojana(yojana);
        }

        return repository.save(existing);
    }


    @Override
    public void MahilaYojana(long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("MahilaYojana not found with id: " + id);
        }

        repository.deleteById(id);
    }
}
