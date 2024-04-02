package org.ecommerce.sandhya.application;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestDatabject {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
