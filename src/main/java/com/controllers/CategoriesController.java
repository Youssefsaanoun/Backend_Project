package com.controllers;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.models.Categories;
import com.serviseimplementation.CategoriesIm;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Categories")
public class CategoriesController {
    private final CategoriesIm categoriesIm;

    public CategoriesController(CategoriesIm categoriesIm) {
        this.categoriesIm = categoriesIm;
    }
     @GetMapping
    public ResponseEntity <List<Categories>>getALLcategories(){
        List <Categories> cattegories=categoriesIm.getALLCategories();
        return ResponseEntity.ok(cattegories);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void>DeleteCategories(@PathVariable UUID id){
        categoriesIm.DeleteCategories(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateClient(@PathVariable UUID id, @RequestBody Categories categories) {
        categories.setId(id);
        Categories updatedCategory = categoriesIm.UpdateCategories(categories);
        return ResponseEntity.ok(updatedCategory);
    }
    @PostMapping("/AddCategories")
    
    
    public ResponseEntity<Categories>AddCategories(@RequestBody Categories categories){
        Categories Categories1 =categoriesIm.AddCategories(categories);

        if (Categories1==null){
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.ok(Categories1);

    }
    @GetMapping("/{id}")
    public ResponseEntity <Categories>getcategoriesByid(@PathVariable UUID id){
         Categories cattegories=categoriesIm.getCategoriesByID(id);
         if ( cattegories==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
        return ResponseEntity.ok(cattegories);
    }

}
