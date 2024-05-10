package com.amir.lab1.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.lab1.model.Produit;
import com.amir.lab1.repository.ProduitRepository;

@Service
public class ProduitServiceImpl {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    public Produit findProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit not found with id: " + id));
    }
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }
    public void deleteProduitById(Long id ) {
        produitRepository.deleteById(id);
        
    }
    

    public Produit updateProduit(Long id, Produit updatedProduit) {
        Produit existingProduit = findProduitById(id);
        if (existingProduit != null) {
            existingProduit.setNomProduit(updatedProduit.getNomProduit());
            existingProduit.setPrixProduit(updatedProduit.getPrixProduit());
            existingProduit.setDelateProduit(updatedProduit.getDelateProduit());
            return produitRepository.save(existingProduit);
        } else {
            // If the product with the given ID doesn't exist, you can either return null or throw an exception
            throw new RuntimeException("Produit not found with ID: " + id);
        }
    }


}