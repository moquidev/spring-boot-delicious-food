package com.projects.repository;

import com.projects.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
  
  Restaurant findByCategory(String category);
}
