package com.SarkariKamYojana.Service;

import com.SarkariKamYojana.Entity.MahilaYojana;

import java.util.List;

public interface MahilaYojanaService {

    MahilaYojana createMahilaYojana(MahilaYojana mahilaYojana);

    List<MahilaYojana> getAllMahilaYojana();

    MahilaYojana getMahilaYojanaById(Long id);

    MahilaYojana updateMahilaYojana(Long id, MahilaYojana mahilaYojana);

    void deleteMahilaYojana(Long id);
}
