package com.SarkariKamYojana.ServiceImpl;

import com.SarkariKamYojana.Entity.Category;
import com.SarkariKamYojana.Repository.CategoryRepository;
import com.SarkariKamYojana.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private  final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public Category createYojana(Category yojana) {
        return repository.save(yojana);
    }

    @Override
    public List<Category> getAllYojana() {
        return repository.findAll();
    }

    @Override
    public Category getByidYojana(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Yojana id not found..!!" +id));
    }

    @Override
    public Category updateYojana(Long id, Category yojana) {
        Category existing = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Yojana not Found..!!"+id));
        existing.setName(yojana.getName());

        return  repository.save(existing);
    }

    @Override
    public void deleteYojana(Long id) {
        if(!repository.existsById(id))
        {
            throw  new RuntimeException("Yajana id not Found .."+id);
        }
        repository.deleteById(id);

    }
}
