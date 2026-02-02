package com.workintech.s18d2.controller;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fruit")
@RequiredArgsConstructor
public class FruitController {
    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> getAllAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable Long id) {
        if (id < 0) throw new IllegalArgumentException("Id must be >= 0!! ");

        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getAllDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/name/{name}")
    public List<Fruit> findByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit upsert(@Valid @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fruit> delete(@PathVariable Long id) {
        if (id < 0) throw new IllegalArgumentException("Id must be >= 0!! ");
        Fruit deleted = fruitService.delete(id);

        return ResponseEntity.ok(deleted);


    }
}

