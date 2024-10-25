package com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,UUID> {
    
}
