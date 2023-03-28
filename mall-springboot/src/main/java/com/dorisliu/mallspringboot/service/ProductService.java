package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.dto.ProductRequest;
import model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

}
