package com.serviseimplementation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


import com.models.product;
import com.repository.ProductRepository;
import com.servise.ProductServise;
@Service
public class ProductIm implements ProductServise {
private final ProductRepository productRepository;

    public ProductIm(ProductRepository productRepository) {
    this.productRepository = productRepository;
}

    @Override
    public List<product> getALLproduct() {
      return  productRepository.findAll();
    }

    @Override
    public void Deleteproduct(UUID id ) {
      productRepository.deleteById(id);
    }

    @Override
    public product getproductByID(UUID id) {
       Optional <product> optional=productRepository.findById(id);
       if (optional.isPresent()){
        return optional.get();
       }
       else return null;
    }

    @Override
    public product Addproduct(product product) {
      return productRepository.save(product);
    }

    @Override
    public product Updateproduct(product product) {
        Optional <product> optional=productRepository.findById(product.getId());
        if (optional.isPresent()){
            return productRepository.save(product);
        }
        else 
        return null;
      
    }
@Override
    public void saveProductImage( @PathVariable UUID id, @RequestParam MultipartFile imageFile) {
        Optional<product> optional = productRepository.findById(id);
    
        if (optional.isPresent()) {
            product product = optional.get();
            String filename = imageFile.getOriginalFilename();
    
            String pathFile = "C:/Users/youss/Downloads/images/" + filename;
            File file = new File(pathFile);
    
            try {
                imageFile.transferTo(file);
    
                product.setImagePath("/images/" + filename);  // Assurez-vous que ce chemin est accessible via le serveur
                productRepository.save(product);
    
                System.out.println("Image saved successfully!");
    
            } catch (IOException e) {
                System.err.println("Erreur lors de la sauvegarde de l'image : " + e.getMessage());
                throw new RuntimeException("Erreur lors de la sauvegarde de l'image", e);  // Vous pouvez lever une exception pour gérer l'erreur dans le contrôleur
            }
        } else {
            System.out.println("Produit non trouvé pour l'ID : " + id);
            throw new RuntimeException("Produit non trouvé pour l'ID : " + id);  // Lancer une exception si le produit n'est pas trouvé
        }
    }
    
          }
        
      


