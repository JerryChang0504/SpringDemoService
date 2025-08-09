package com.gjun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjun.entity.Product;
import com.gjun.service.ProductService;

@RestController
@RequestMapping("api")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("QueryProduct")
  public ResponseEntity<List<Product>> QueryProduct() {
    return ResponseEntity.ok(productService.QueryProduct());
  }
}
