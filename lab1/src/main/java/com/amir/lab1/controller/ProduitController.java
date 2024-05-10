package com.amir.lab1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.lab1.model.Produit;
import com.amir.lab1.serviceimpl.ProduitServiceImpl;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitServiceImpl produitService;
    @GetMapping()
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.findProduitById(id);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<Produit> saveProduit(Produit p) {
        Produit savedProduit = produitService.saveProduit(p);
        return ResponseEntity.ok(savedProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable("id") Long id, @RequestBody Produit p) {
        Produit updatedProduit = produitService.updateProduit(id, p);
        return ResponseEntity.ok(updatedProduit);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteProduit(Produit p) {
        produitService.deleteProduit(p);
        return ResponseEntity.noContent().build();
    }






    @DeleteMapping("/{id}")
    public ResponseEntity<Produit> deleteProduit(@PathVariable("id") Long id) {
        Produit deletedProduit = produitService.findProduitById(id);
        if (deletedProduit != null) {
            produitService.deleteProduitById(id);
            return ResponseEntity.ok(deletedProduit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





    
}
