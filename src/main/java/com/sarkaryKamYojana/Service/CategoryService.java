package com.sarkaryKamYojana.Service;

import com.sarkaryKamYojana.Entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {


    Category createYojana(Category yojana);

    List<Category> getAllYojana();

    Category getByidYojana(Long id);

    Category updateYojana(Long id, Category yojana);

    void deleteYojana(Long id);


}
