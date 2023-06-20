package com.matin.productservice.controller;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public Boolean createProduct(@RequestBody ProductDto productDto) throws Exception {
        return productService.createProduct(productDto);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
