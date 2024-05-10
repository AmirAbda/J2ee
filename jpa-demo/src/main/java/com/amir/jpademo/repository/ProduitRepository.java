package com.amir.jpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amir.jpademo.model.Categorie;
import com.amir.jpademo.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomProduit(String nom);

    @Query("select p from Produit p where p.nomProduit like %:nom% and p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    List<Produit> findByCategorie(Categorie categorie);
}