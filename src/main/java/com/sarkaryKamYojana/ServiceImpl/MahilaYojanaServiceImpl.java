package com.sarkaryKamYojana.ServiceImpl;

import com.sarkaryKamYojana.Entity.MahilaYojana;
import com.sarkaryKamYojana.Repository.MahilaYojanaRepository;
import com.sarkaryKamYojana.Service.MahilaYojanaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahilaYojanaServiceImpl implements MahilaYojanaService {

    private final MahilaYojanaRepository repository;


    public MahilaYojanaServiceImpl(MahilaYojanaRepository repository) {
        this.repository = repository;
    }

    @Override
    public MahilaYojana createMahilaYojana(MahilaYojana mahilaYojana) {
        return repository.save(mahilaYojana);
    }

    @Override
    public List<MahilaYojana> getAllMahilaYojana() {
        return repository.findAll();
    }

    @Override
    public MahilaYojana getMahilaYojanaById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mahila Yojana not found with id: " + id));
    }

    @Override
    public MahilaYojana updateMahilaYojana(Long id, MahilaYojana mahilaYojana) {

        MahilaYojana existing = getMahilaYojanaById(id);

        existing.setTitle(mahilaYojana.getTitle());
        existing.setDescription(mahilaYojana.getDescription());
        existing.setImage(mahilaYojana.getImage());
        existing.setLink1(mahilaYojana.getLink1());
        existing.setLink2(mahilaYojana.getLink2());
        existing.setLink3(mahilaYojana.getLink3());
        existing.setInfo1(mahilaYojana.getInfo1());
        existing.setInfo2(mahilaYojana.getInfo2());
        existing.setInfo3(mahilaYojana.getInfo3());

        return repository.save(existing);
    }

    @Override
    public void deleteMahilaYojana(Long id) {
        MahilaYojana existing = getMahilaYojanaById(id);
        repository.delete(existing);
    }
}
