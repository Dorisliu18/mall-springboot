package com.dorisliu.mallspringboot.dao;

import com.dorisliu.mallspringboot.dto.ProductQueryParams;
import com.dorisliu.mallspringboot.dto.ProductRequest;
import model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
