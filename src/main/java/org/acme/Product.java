package org.acme;


import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Product extends PanacheEntity {
    @Column
    public String name;

    @ManyToOne
    public SecondTable secondTable;

    @OneToOne(mappedBy = "product")
    public ThirdTable thirdTable;

}
