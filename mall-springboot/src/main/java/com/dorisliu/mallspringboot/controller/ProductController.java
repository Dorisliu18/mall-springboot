package com.dorisliu.mallspringboot.controller;

import com.dorisliu.mallspringboot.constant.ProductCategory;
import com.dorisliu.mallspringboot.dto.ProductQueryParams;
import com.dorisliu.mallspringboot.dto.ProductRequest;
import com.dorisliu.mallspringboot.service.ProductService;

import com.dorisliu.mallspringboot.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 Filtering
            // 查詢商品分類
            @RequestParam(required = false) ProductCategory category,
            // 查詢關鍵字
            @RequestParam(required = false) String search,

            // 排序 Sorting
            // 查詢列表(根據欄位內容來排序)
            @RequestParam(defaultValue = "created_date") String orderBy,
            // 查詢列表(使用升序asc或降序desc來排序)
            @RequestParam(defaultValue = "desc") String sort,

            // 分頁 Pagination
            // 取得 幾筆數據
            // 有用MAX跟MIN記得加@Validated註解
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            // 跳過 幾筆數據
            @RequestParam(defaultValue = "0") @Min(0) Integer offset


    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // 取得 Product list
        List<Product> productList = productService.getProducts(productQueryParams);

        // 取得 product 總數
        Integer total = productService.countProduct(productQueryParams);

        // 分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);
        return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        // 檢查 product 是否存在
        Product product = productService.getProductById(productId);

        if (product == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
