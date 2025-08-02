package com.gjun.service;

import java.util.List;
import com.gjun.entity.Product;

public interface ProductService {

  public List<Product> QueryProduct();

  public void SaveProduct(List<Product> products);
}
