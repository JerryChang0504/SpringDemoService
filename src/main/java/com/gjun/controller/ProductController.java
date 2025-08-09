package com.gjun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gjun.entity.Product;
import com.gjun.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api")
@Tag(name = "會員操作", description = "提供會員新增、查詢等操作")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("QueryProduct")
	public ResponseEntity<List<Product>> QueryProduct() {
		return ResponseEntity.ok(productService.QueryProduct());
	}

	@PostMapping("/student")
	public ResponseEntity<String> responseEntity(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello");
	}
}
