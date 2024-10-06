package com.models;

import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Client {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;  // Utilisation de UUID
    private String nom;
    private String prenom;
    private String email;
    private String address;

    @ManyToMany
    @JoinTable(
        name = "client_product",
        joinColumns = @JoinColumn(name = "client_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<product> products;
}
