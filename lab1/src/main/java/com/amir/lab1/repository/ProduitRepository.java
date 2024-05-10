package com.amir.lab1.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.lab1.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>  {
    

}
