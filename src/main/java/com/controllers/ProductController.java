package com.controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.models.Categories;
import com.models.product;
import com.servise.CategoriesServise;
import com.servise.ProductServise;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServise productServise;
    private final CategoriesServise categoriesServise;

    public ProductController(ProductServise productServise, CategoriesServise categoriesServise) {
        this.productServise = productServise;
        this.categoriesServise = categoriesServise;
    }

    @GetMapping
    public ResponseEntity<List<product>> GetAllProducts() {
        List<product> products = productServise.getALLproduct();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity <product> getPorductByid(@PathVariable UUID id){
return ResponseEntity.ok(productServise.getproductByID(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productServise.Deleteproduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<product> Addproduct(@RequestBody product product) {
        Categories categories = categoriesServise.getCategoriesByID(product.getCategories().getId());
        if (categories == null) {
            return ResponseEntity.noContent().build();
        }

        product newProduct = productServise.Addproduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<product> updateProduct(@PathVariable UUID id, @RequestBody product product) {
        product.setId(id);
        product updatedProduct = productServise.Updateproduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<String> uploadImage(@PathVariable UUID id, @RequestParam("image") MultipartFile image) {
        productServise.saveProductImage(id, image);
        return ResponseEntity.ok("image is uploaded");
    }

    @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> serveImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get("C:/Users/youss/Downloads/images/" + imageName);
            Resource imageResource = new UrlResource(imagePath.toUri());

            if (imageResource.exists() && imageResource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_PNG) // Adjust based on your image type
                        .body(imageResource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
