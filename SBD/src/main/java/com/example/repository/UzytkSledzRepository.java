package com.example.repository;

import com.example.entity.UzytkSledz;
import com.example.entity.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UzytkSledzRepository extends JpaRepository<UzytkSledz, String> {
    List<UzytkSledz> findAllBynazwaUzytkownika(String nazwaUzytkownika);
    List<UzytkSledz> findAllByuzytkownikSledzony(String uzytkownikSledzony);
    List<UzytkSledz> findAll();
    void deleteByid(Long id);
}
