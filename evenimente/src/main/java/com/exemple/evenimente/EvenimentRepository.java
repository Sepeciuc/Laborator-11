package com.exemple.evenimente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EvenimentRepository extends JpaRepository<Evenimente, Long> {
    List<Evenimente> findByLocatie(String locatie);
    List<Evenimente> findByData(LocalDate data);
}
