package com.example.repository;

import com.example.entity.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, String> {
    Uzytkownik findBynazwa(String nazwa);
    List<Uzytkownik> findAll();
    void deleteBynazwa(String nazwa);
}
