package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.constant.ProductCategory;
import com.dorisliu.mallspringboot.dto.ProductRequest;
import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
