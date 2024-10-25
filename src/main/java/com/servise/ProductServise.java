package com.servise;

import java.util.List;


import com.models.product;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public interface ProductServise {

    public List<product> getALLproduct();
    public void Deleteproduct(UUID id );
    public product getproductByID(UUID id );
    public product Addproduct(product product);
    public product Updateproduct(product product);
    public void saveProductImage(UUID id ,MultipartFile imageFile);


}
