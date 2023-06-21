package com.matin.productservice.controller;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDisplayDto;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.service.product.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public Boolean createProduct(@Valid @RequestBody ProductDto productDto) throws Exception {
        return productService.createProduct(productDto);
    }

    @GetMapping("/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/page")
    public List<ProductDto> getProductsPaginated(@RequestParam(defaultValue = "0") Integer page) {
        return productService.getProductsPaginated(page);
    }

    @GetMapping("/name/{productName}")
    public ProductDto getProductByName(@PathVariable("productName") @NotBlank String productName) {
        return productService.getProductByName(productName);
    }

    @GetMapping("/product")
    public Product getProductById(@RequestParam Long id) {
        Optional<Product> productOptional = productService.getProductById(id);
        return productOptional.orElse(null);
    }

    @PostMapping("/display")
    public Boolean changeProductDisplaySetting(@Valid @RequestBody ProductDisplayDto productDisplayDto) {
        return productService.changeProductDisplaySetting(productDisplayDto);
    }

    @PostMapping("/comment/option")
    public Boolean changeProductCommentSetting(@Valid @RequestBody ProductDisplayDto productDisplayDto) {
        return productService.changeProductCommentSetting(productDisplayDto);
    }

    @PostMapping("/vote/option")
    public Boolean changeProductVoteSetting(@Valid @RequestBody ProductDisplayDto productDisplayDto) {
        return productService.changeProductVoteSetting(productDisplayDto);
    }
}
