package com.servise;

import java.util.List;
import java.util.UUID;

import com.models.OrderProduct;
public interface orderServise {
    public List <OrderProduct> GetAllPorduct();
    public OrderProduct getOrderProductByID(UUID id);
    public  void deleteorderProduct (UUID id);
    public OrderProduct modifierOrderProduct(OrderProduct orderProduct);
    public OrderProduct AjouteOrderPoruct(OrderProduct orderProduct);
    public OrderProduct addOrderToClinet(OrderProduct orderRequest,UUID clientid,List <UUID> productsIds);





    

    

    
}
