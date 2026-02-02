package com.workintech.s18d2.services;
import java.util.List;
import com.workintech.s18d2.entity.Vegetable;

public interface VegetableService {

    List<Vegetable> findAllAsc();
    List<Vegetable> findAllDesc();
    Vegetable findById(Long id);
    Vegetable save(Vegetable vegetable);
    void deleteById(Long id);
    List<Vegetable> findByNameLike(String name);

}

