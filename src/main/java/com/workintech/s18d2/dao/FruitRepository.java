package com.workintech.s18d2.dao;
import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    List<Fruit> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> findAllOrderByPriceAsc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> findAllOrderByPriceDesc();


}

