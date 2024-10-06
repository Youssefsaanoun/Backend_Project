package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Categories;
import java.util.UUID;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,UUID>{

}
