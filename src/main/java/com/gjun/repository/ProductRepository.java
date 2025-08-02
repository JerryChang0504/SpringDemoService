package com.gjun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gjun.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
