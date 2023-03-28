package com.dorisliu.mallspringboot.dao;

import com.dorisliu.mallspringboot.dto.ProductRequest;
import model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
