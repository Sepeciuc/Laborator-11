package com.exemple.evenimente;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EvenimentService {

    private final EvenimentRepository evenimentRepository;

    public EvenimentService(EvenimentRepository evenimentRepository) {
        this.evenimentRepository = evenimentRepository;
    }

    public List<Evenimente> getAllEvenimente() {
        return evenimentRepository.findAll();
    }

    public List<Evenimente> getEvenimenteByLocatie(String locatie) {
        return evenimentRepository.findByLocatie(locatie);
    }

    public List<Evenimente> getEvenimenteByData(LocalDate data) {
        return evenimentRepository.findByData(data);
    }

    public Evenimente addEveniment(Evenimente eveniment) {
        return evenimentRepository.save(eveniment);
    }

    public Evenimente updateEveniment(Long id, Evenimente eveniment) {
        eveniment.setId(id);
        return evenimentRepository.save(eveniment);
    }

    public void deleteEveniment(Long id) {
        evenimentRepository.deleteById(id);
    }
}
