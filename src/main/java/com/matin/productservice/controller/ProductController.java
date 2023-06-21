package com.matin.productservice.controller;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDisplayDto;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.service.product.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    public Boolean createProduct(@RequestBody @Valid ProductDto productDto) throws Exception {
        return productService.createProduct(productDto);
    }

    @GetMapping("/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/page")
    public List<ProductDto> getProductsPaginated(@RequestParam Integer page) {
        return productService.getProductsPaginated(page);
    }

    @GetMapping("/{name}")
    public ProductDto getProductByName(@PathVariable @NotBlank String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/product")
    public Product getProductById(@RequestParam Long id) {
        return productService.getProductById(id).get();
    }

    @PostMapping("/display")
    public Boolean changeProductDisplaySetting(@RequestBody @Valid ProductDisplayDto productDisplayDto) {
        return productService.changeProductDisplaySetting(productDisplayDto);
    }

    @PostMapping("/comment/option")
    public Boolean changeProductCommentSetting(@RequestBody @Valid ProductDisplayDto productDisplayDto) {
        return productService.changeProductCommentSetting(productDisplayDto);
    }

    @PostMapping("/vote/option")
    public Boolean changeProductVoteSetting(@RequestBody @Valid ProductDisplayDto productDisplayDto) {
        return productService.changeProductVoteSetting(productDisplayDto);
    }


}
