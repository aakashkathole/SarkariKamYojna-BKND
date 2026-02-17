package com.sarkaryKamYojana.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mahila_yojana")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahilaYojana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 3000)
    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    private String link1;
    private String link2;
    private String link3;
    private  String info1;
    private String info2;
    private String info3;


    @ManyToOne
    @JoinColumn(name = "yojana_id")
    private Yojana yojana;

}
