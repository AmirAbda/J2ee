package com.amir.jpademo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.jpademo.model.Categorie;
import com.amir.jpademo.model.Produit;
import com.amir.jpademo.repository.ProduitRepository;

@Service
public class ProduitServiceImpl {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }
}