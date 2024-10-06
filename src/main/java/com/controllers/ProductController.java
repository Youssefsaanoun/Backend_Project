package com.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

import com.models.Categories;
import com.models.product;
import com.servise.CategoriesServise;
import com.servise.ProductServise;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServise productServise;
    private final CategoriesServise categoriesServise;

    
    public ProductController(ProductServise productServise,CategoriesServise categoriesServise) {
        this.productServise = productServise;
        this.categoriesServise=categoriesServise;
    }

    @GetMapping(path="/getall")
    public ResponseEntity <List<product>>GetAllProducts(){
    List<product> products=productServise.getALLproduct();
    return ResponseEntity.ok(products);
}
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        productServise.Deleteproduct(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity <product>Addproduct(@RequestBody product product){
        Categories categories=categoriesServise.getCategoriesByID(product.getCategories().getId());
        if ( categories==null){
            return ResponseEntity.noContent().build();
        }
        
       product newProduct=productServise.Addproduct(product);   
        return ResponseEntity.ok(newProduct);

    }
    @PutMapping
    public ResponseEntity <product>Updateproduct( @RequestBody product product){
        return ResponseEntity.ok(productServise.Updateproduct(product));
    }

}
