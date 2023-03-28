package com.dorisliu.mallspringboot.dao;

import model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
