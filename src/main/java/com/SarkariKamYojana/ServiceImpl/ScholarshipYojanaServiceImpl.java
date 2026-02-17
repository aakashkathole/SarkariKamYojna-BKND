package com.SarkariKamYojana.ServiceImpl;

import com.SarkariKamYojana.Entity.ScholarshipYojana;
import com.SarkariKamYojana.Repository.ScholarshipYojanaRepository;
import com.SarkariKamYojana.Service.ScholarshipYojanaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarshipYojanaServiceImpl implements ScholarshipYojanaService {

    private final ScholarshipYojanaRepository repository;

    public ScholarshipYojanaServiceImpl(ScholarshipYojanaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ScholarshipYojana createScholarshipYojana(ScholarshipYojana scholarshipYojana) {
        return repository.save(scholarshipYojana);
    }

    @Override
    public List<ScholarshipYojana> getAllScholarshipYojana() {
        return repository.findAll();
    }

    @Override
    public ScholarshipYojana getByIdScholarshipYojana(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScholarshipYojana Id not found: " + id));
    }

    @Override
    public ScholarshipYojana updateScholarshipYojana(Long id, ScholarshipYojana scholarshipYojana) {

        ScholarshipYojana existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScholarshipYojana Id not found: " + id));

        existing.setImage(scholarshipYojana.getImage());
        existing.setLink1(scholarshipYojana.getLink1());
        existing.setLink2(scholarshipYojana.getLink2());
        existing.setLink3(scholarshipYojana.getLink3());
        existing.setInfo1(scholarshipYojana.getInfo1());
        existing.setInfo2(scholarshipYojana.getInfo2());
        existing.setInfo3(scholarshipYojana.getInfo3());

        return repository.save(existing);
    }

    @Override
    public void deleteScholarshipYojana(long id) {
        ScholarshipYojana existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScholarshipYojana Id not found: " + id));

        repository.delete(existing);
    }
}
