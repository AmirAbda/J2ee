package com.amir.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amir.lab1.model.Produit;
import com.amir.lab1.repository.ProduitRepository;

@SpringBootTest
class ProduitRepositoryTest {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    void testSaveAndFindProduit() {
        // Arrange
        Produit produit = new Produit();
        produit.setNomProduit("Test Product");
        produit.setPrixProduit(100.0);
        produit.setDelateProduit(new Date());

        // Act
        Produit savedProduit = produitRepository.save(produit);

        // Assert
        assertNotNull(savedProduit);
        assertNotNull(savedProduit.getIdProduit());
        assertEquals("Test Product", savedProduit.getNomProduit());
        assertEquals(100.0, savedProduit.getPrixProduit());
        assertNotNull(savedProduit.getDelateProduit());
    }
}