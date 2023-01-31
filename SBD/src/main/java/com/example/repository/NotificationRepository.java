package com.example.repository;

import com.example.entity.Notification;
import com.example.entity.Wiadomosc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findAllBynazwaOdbiorcy(String nazwaOdbiorcy);
}
