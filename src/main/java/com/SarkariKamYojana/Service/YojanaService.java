package com.SarkariKamYojana.Service;

import com.SarkariKamYojana.Entity.Yojana;

import java.util.List;


public interface YojanaService {

    Yojana createmahilaYojana(Yojana yojana);

    List<Yojana> getallMahilaYojana();

    Yojana getbyIdMahilaYojana(Long id);

    Yojana updateMahilaYojana(long id, Yojana yojana);

    void MahilaYojana(long id);


}
