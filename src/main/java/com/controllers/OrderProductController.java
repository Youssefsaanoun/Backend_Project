package com.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.OrderProduct;
import com.serviseimplementation.ClientIm;
import com.serviseimplementation.OrderProductIm;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/orderProduct")
public class OrderProductController {
    public final OrderProductIm orderProductIm;
    public final ClientIm clientIm;
 
    public OrderProductController(OrderProductIm orderProductIm, ClientIm clientIm) {
        this.orderProductIm = orderProductIm;
        this.clientIm = clientIm;
    }
    @GetMapping
    public ResponseEntity  <List<OrderProduct>> GetAllPorduct(){
        return ResponseEntity.ok( orderProductIm.GetAllPorduct());
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteOrder(@PathVariable UUID id){
        orderProductIm.deleteorderProduct(id);
         return ResponseEntity.noContent().build();
    }
    @PostMapping("/addOrderToClient/{clinet_id}/products/{productsId}")
    public ResponseEntity <OrderProduct> AddOrderToClinet(@PathVariable UUID clinet_id,@RequestBody OrderProduct orderRequest,@PathVariable List<UUID>productsId ){
OrderProduct orderProduct=orderProductIm.addOrderToClinet(orderRequest, clinet_id, productsId);  
        return ResponseEntity.ok(orderProduct);
        
    }
 
    

    
}
