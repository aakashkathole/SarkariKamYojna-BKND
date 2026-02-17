package com.sarkaryKamYojana.Service;

import com.sarkaryKamYojana.Entity.ScholarshipYojana;

import java.util.List;

public interface ScholarshipYojanaService {


    ScholarshipYojana createScholarshipYojana(ScholarshipYojana scholarshipYojana);

    List<ScholarshipYojana> getAllScholarshipYojana();

    ScholarshipYojana getByIdScholarshipYojana(Long id);

    ScholarshipYojana updateScholarshipYojana(Long id, ScholarshipYojana scholarshipYojana);

    void deleteScholarshipYojana(long id);

}
