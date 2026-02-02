package com.workintech.s18d2.services;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new PlantException("Fruit not found!! -> " + id));
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.findAllOrderByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.findAllOrderByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit existing = fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException("Fruit not found!! -> " + id));
        fruitRepository.delete(existing);

        return existing;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.findByNameContainingIgnoreCase(name);
    }


}

