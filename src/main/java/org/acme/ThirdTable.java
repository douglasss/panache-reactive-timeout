package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ThirdTable extends PanacheEntity {

    @OneToOne
    private Product product;

    @Column
    public String name;
}
