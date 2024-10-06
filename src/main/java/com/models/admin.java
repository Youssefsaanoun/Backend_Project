package com.models;

import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class admin {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;  // Utilisation de UUID
    private String name;
    private String email;
    private String password;
}
