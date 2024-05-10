package com.amir.jpademo.service;

import java.util.List;

import com.amir.jpademo.model.Categorie;
import com.amir.jpademo.model.Produit;

public interface ProduitService {

    Produit saveProduit(Produit p);

    List<Produit> getAllProduits();

    List<Produit> findByNomProduit(String nom);

    List<Produit> findByNomPrix(String nom, Double prix);
    
    List<Produit> findByCategorie(Categorie categorie);

    List<Produit> findByCategorieIdCat(Long id);

    Produit updateProduit(Produit p);

    void deleteProduit(Produit p);

    void deleteProduitById(Long id);

    Produit getProduit(Long id);

    

}
