package com.commercial_manager.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // 👈 Aquí
public class Client implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 3, message = "The name must have at least 3 characters.")
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;
}
