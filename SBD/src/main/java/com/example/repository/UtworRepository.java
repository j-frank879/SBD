/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

import com.example.entity.Utwor;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author poker
 */
@Repository
@Transactional
public interface UtworRepository extends JpaRepository<Utwor, Long>
{
  List<Utwor> findByNazwaContainingIgnoreCase(String keyword);

}
