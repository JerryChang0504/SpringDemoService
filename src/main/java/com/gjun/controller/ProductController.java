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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "介面操作", description = "提供產品查詢等操作")
@RestController
@RequestMapping("api")
public class ProductController {

	@Autowired
	private ProductService productService;

<<<<<<< HEAD
  @GetMapping("QueryProduct")
  public ResponseEntity<List<Product>> QueryProduct() {
    return ResponseEntity.ok(productService.QueryProduct());
  }
  
  @PostMapping("/student")
  public ResponseEntity<String> responseEntity(@RequestBody Student student){
	  return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello");
  }
=======
	@Operation(summary = "取得所有清單")
	@ApiResponse(responseCode = "200", description = "查詢成功")
	@GetMapping("QueryProduct")
	public ResponseEntity<List<Product>> QueryProduct() {
		return ResponseEntity.ok(productService.QueryProduct());
	}
>>>>>>> Branch_Jerry
}
