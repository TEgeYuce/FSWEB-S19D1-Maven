package com.workintech.s18d2.controller;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
@RequiredArgsConstructor
public class VegetableController {
    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> getAllAsc() {
        return vegetableService.findAllAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        if (id < 0) throw new IllegalArgumentException("Id must be >= 0!! ");

        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.findAllDesc();
    }

    @PostMapping
    public Vegetable upsert(@Valid @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> findByName(@PathVariable String name) {
        return vegetableService.findByNameLike(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (id < 0) throw new IllegalArgumentException("Id must be >= 0!! ");
        vegetableService.deleteById(id);

        return ResponseEntity.noContent().build();


    }
}

