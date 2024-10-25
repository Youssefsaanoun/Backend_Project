package com.models;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class product {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;  
    private String nom;
    private String price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    
    private Categories categories;

    private boolean status;
    private Long quantiteStocke;
     private String imagePath;
 

    
}
