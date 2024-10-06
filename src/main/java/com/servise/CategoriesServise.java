package com.servise;

import java.util.List;

import com.models.Categories;
import java.util.UUID;

public interface CategoriesServise {


   public List<Categories> getALLCategories();
    public void DeleteCategories(UUID id);
    public Categories getCategoriesByID(UUID id );
    public Categories AddCategories(Categories Categories);
    public Categories UpdateCategories(Categories Categories);


}
