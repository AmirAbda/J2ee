package com.amir.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amir.jpademo.model.Produit;
import com.amir.jpademo.serviceImpl.ProduitServiceImpl;

@RestController
@RequestMapping("/api/v1/produits")
public class ProduitController {
    @Autowired
    public ProduitServiceImpl produitServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Produit> saveProduit(@RequestBody Produit p) {
        return ResponseEntity.ok(produitServiceImpl.saveProduit(p));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getAllProduits() {
        return ResponseEntity.ok(produitServiceImpl.getAllProduits());
    }

    @GetMapping("/search/nom")
    public ResponseEntity<List<Produit>> findByNomProduit(@RequestParam String nom) {
        return ResponseEntity.ok(produitServiceImpl.findByNomProduit(nom));
    }

    @GetMapping("/search/nom-prix")
    public ResponseEntity<List<Produit>> findByNomPrix(@RequestParam String nom, @RequestParam Double prix) {
        return ResponseEntity.ok(produitServiceImpl.findByNomPrix(nom, prix));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Produit>> deleteProduit(@RequestBody Produit p) {
        produitServiceImpl.deleteProduit(p);
        return ResponseEntity.ok(produitServiceImpl.getAllProduits());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Produit>> deleteProduitById(@PathVariable("id") Long produitId) {
        produitServiceImpl.deleteProduitById(produitId);
        return ResponseEntity.ok(produitServiceImpl.getAllProduits());
    }
}