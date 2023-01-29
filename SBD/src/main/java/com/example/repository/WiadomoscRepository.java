package com.example.repository;

import java.util.List;



import com.example.entity.Wiadomosc;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public interface WiadomoscRepository extends JpaRepository<Wiadomosc, Integer> {
    List<Wiadomosc> findByNazwaOdbiorcyContainingIgnoreCase(String keyword);
    List<Wiadomosc> findByNazwaNadawcyAndNazwaOdbiorcyContainingIgnoreCase(String keyword,String username);

    
}
