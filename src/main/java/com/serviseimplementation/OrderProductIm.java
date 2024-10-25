package com.serviseimplementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.models.OrderProduct;
import com.models.product;
import com.repository.ClientRepository;
import com.repository.OrderProductRepository;
import com.repository.ProductRepository;
import com.servise.orderServise;
import com.models.Client;
@Service
public class OrderProductIm implements orderServise {
 private final OrderProductRepository orderProductRepository;
 private final ClientRepository clientRepository;
 private final ProductRepository productRepository;

    public OrderProductIm(OrderProductRepository orderProductRepository, ClientRepository clientRepository,
        ProductRepository productRepository) {
    this.orderProductRepository = orderProductRepository;
    this.clientRepository = clientRepository;
    this.productRepository = productRepository;
}







    @Override
    public List<OrderProduct> GetAllPorduct() {
       return orderProductRepository.findAll();
    }

    @Override
    public OrderProduct getOrderProductByID(UUID id) {
    Optional <OrderProduct> optional =orderProductRepository.findById(id);
    if(optional.isPresent()){
        return optional.get();

    }
    else 
        return null;
    }

    @Override
    public void deleteorderProduct(UUID id) {
            orderProductRepository.deleteById(id);
    }

    @Override
    public OrderProduct modifierOrderProduct(OrderProduct orderProduct) {
        Optional <OrderProduct> optional =orderProductRepository.findById(orderProduct.getId());
        if(optional.isPresent()){
            return  orderProductRepository.save(orderProduct);
    }
    else 
        return null; 
    }
    @Override
    public OrderProduct AjouteOrderPoruct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
       

    }



    @Override
    public OrderProduct addOrderToClinet(OrderProduct orderRequest, UUID clientid,List<UUID> productsIUuids) {
        Client client=clientRepository.findById(clientid).orElse(null);
        List<product> products=productRepository.findAllById(productsIUuids);
        if(!products.isEmpty()  ){
            orderRequest.setProducts(products);
            orderRequest.setClient(client);
            return orderProductRepository.save(orderRequest);

        }
       
        
     return null;
    }

 
    
    
}
