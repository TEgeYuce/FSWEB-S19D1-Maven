package com.workintech.s18d2.dao;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    List<Vegetable> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> findAllOrderByPriceAsc();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> findAllOrderByPriceDesc();


}

