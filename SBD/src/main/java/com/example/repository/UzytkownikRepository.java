package com.example.repository;

import com.example.models.Uzytkownik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface UzytkownikRepository extends CrudRepository<Uzytkownik, String> {}