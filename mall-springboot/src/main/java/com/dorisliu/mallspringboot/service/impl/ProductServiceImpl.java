package com.dorisliu.mallspringboot.service.impl;

import com.dorisliu.mallspringboot.dao.ProductDao;
import com.dorisliu.mallspringboot.service.ProductService;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
