package com.example.repository;

import com.example.entity.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {
}