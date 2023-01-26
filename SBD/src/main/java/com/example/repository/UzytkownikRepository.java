package com.example.repository;

import com.example.entity.Tutorial;
import com.example.entity.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long>
{
    List<Uzytkownik> findAll();
    List<Uzytkownik> findByNazwa(String nazwa);
}
