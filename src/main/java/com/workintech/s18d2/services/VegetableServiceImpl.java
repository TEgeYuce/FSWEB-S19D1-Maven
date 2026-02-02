package com.workintech.s18d2.services;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.dao.VegetableRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository vegetableRepository;

    @Override
    public List<Vegetable> findAllAsc() {
        return vegetableRepository.findAllOrderByPriceAsc();
    }

    @Override
    public List<Vegetable> findAllDesc() {
        return vegetableRepository.findAllOrderByPriceDesc();
    }

    @Override
    public Vegetable findById(Long id) {
        return vegetableRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vegetable not found!! -> " + id));
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void deleteById(Long id) {
        vegetableRepository.deleteById(id);
    }

    @Override
    public List<Vegetable> findByNameLike(String name) {
        return vegetableRepository.findByNameContainingIgnoreCase(name);
    }


}

