package com.exemple.evenimente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/evenimente")
public class EvenimentController {

    private final EvenimentService evenimentService;

    public EvenimentController(EvenimentService evenimentService) {
        this.evenimentService = evenimentService;
    }

    @GetMapping
    public List<Evenimente> getAllEvenimente() {
        return evenimentService.getAllEvenimente();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Evenimente> getEvenimenteByLocatie(@PathVariable String locatie) {
        return evenimentService.getEvenimenteByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Evenimente> getEvenimenteByData(@PathVariable String data) {
        return evenimentService.getEvenimenteByData(LocalDate.parse(data));
    }

    @PostMapping
    public Evenimente addEveniment(@RequestBody Evenimente eveniment) {
        return evenimentService.addEveniment(eveniment);
    }

    @PutMapping("/{id}")
    public Evenimente updateEveniment(@PathVariable Long id, @RequestBody Evenimente eveniment) {
        return evenimentService.updateEveniment(id, eveniment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEveniment(@PathVariable Long id) {
        evenimentService.deleteEveniment(id);
        return ResponseEntity.noContent().build();
    }
}
