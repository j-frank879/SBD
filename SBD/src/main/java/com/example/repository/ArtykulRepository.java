package com.example.repository;

import com.example.entity.Artykul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ArtykulRepository extends JpaRepository<Artykul, Long>
{
    List<Artykul> findAll();
    List<Artykul> findBynazwa(String nazwa);
    List<Artykul> findBynazwaContainingIgnoreCase(String nazwa);
    @Modifying
    @Query("UPDATE Artykul a SET state=2 where a.id=:id")
    void modifyState(Long id);
}
