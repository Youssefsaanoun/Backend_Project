package com.models;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToMany
    @JoinTable(
        name = "order_product_product", 
        joinColumns = @JoinColumn(name = "order_product_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<product> products;

    private long price;
    private String total;

    private Date order_date;
    private String status;
    private long quantite;
    private String phone;
    private String nameClient; 


    @ManyToOne
    @JoinColumn(name="client_id ",nullable = false)
    private Client client;
}
