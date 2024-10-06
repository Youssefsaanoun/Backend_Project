package com.serviseimplementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.models.Categories;
import com.repository.CategoriesRepository;
import com.servise.CategoriesServise;

public class CategoriesIm implements CategoriesServise {
    private final CategoriesRepository categoriesRepository;


    

    public CategoriesIm(CategoriesRepository CategoriesRepository) {
        this.categoriesRepository = CategoriesRepository;
    }

    @Override
    public List<Categories> getALLCategories() {
     return categoriesRepository.findAll();
    }

    @Override
    public void DeleteCategories(UUID id ) {
      categoriesRepository.deleteById(id);
    }

    @Override
    public Categories getCategoriesByID(UUID id) {
        Optional <Categories> optional=categoriesRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        else
            return null;
    }

    @Override
    public Categories AddCategories(Categories Categories) {
     return categoriesRepository.save(Categories);
    }

    @Override
    public Categories UpdateCategories(Categories Categories) {
        Optional <Categories> optional=categoriesRepository.findById(Categories.getId());
        if (optional.isPresent()){
            return optional.get();
        }
        else
            return null;
    }

    

}
