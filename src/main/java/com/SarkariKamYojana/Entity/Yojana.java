package com.SarkariKamYojana.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yojana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;


    @ManyToOne
    @JoinColumn(name = "yojana_id")
    private Category yojana;


    @OneToMany(mappedBy = "yojana", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MahilaYojana> mahilaYojanas;


    @OneToMany(mappedBy = "yojana", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ScholarshipYojana> scholarshipYojanas ;


    @OneToMany(mappedBy = "yojana", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ScholarshipYojana> scholarshipYojana;

}
