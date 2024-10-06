package com.serviseimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
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

}
