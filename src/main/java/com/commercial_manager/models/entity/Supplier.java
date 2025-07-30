package com.commercial_manager.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 5, message="The name must have at least 5 characters.")
    private String name;

    @NotEmpty
    @Size(min = 10, max= 10,  message="The phone number must have 10 characters.")
    private String phone;

    @NotEmpty
    private String address;

    @Temporal(TemporalType.DATE)
    private Date date;

    @PrePersist
    public void prePersist() {
        date = new Date();
    }
}
