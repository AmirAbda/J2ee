package com.amir.jpademo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private Long idProduit;

    private String nomProduit;

    private double prixProduit;

    // Hypothetical many-to-one relationship with Categorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}