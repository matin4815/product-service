package com.matin.productservice.controller;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDisplayDto;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.service.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Creates a product"
            , description = "Creates a valid product")
    public Boolean createProduct(@Valid @RequestBody ProductDto productDto) throws Exception {
        return productService.createProduct(productDto);
    }

    @GetMapping("/")
    @Operation(summary = "Returns all product"
            , description = "Returns all products, without considering the visibility of the product")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/page")
    @Operation(summary = "Returns a page of visible products"
            , description = "Returns a page of visible products, for these products visibilty should be set to true")
    public List<ProductDto> getProductsPaginated(@RequestParam(defaultValue = "0") Integer page) {
        return productService.getProductsPaginated(page);
    }

    @GetMapping("/name/{productName}")
    @Operation(summary = "Find a product by name"
            , description = "Find a product by name")
    public ProductDto getProductByName(@PathVariable("productName") @NotBlank String productName) {
        return productService.getProductByName(productName);
    }

    @GetMapping("/product")
    @Operation(summary = "Find a product by Id"
            , description = "Find a product by Id")
    public Product getProductById(@RequestParam Long id) {
        Optional<Product> productOptional = productService.getProductById(id);
        return productOptional.orElse(null);
    }

    @PostMapping("/display")
    @Operation(summary = "Manipulates a products display setting"
            , description = "Manipulates a products display setting, by changing the visibility field")
    public Boolean changeProductDisplaySetting(@Valid @RequestBody ProductDisplayDto productDisplayDto) {
        return productService.changeProductDisplaySetting(productDisplayDto);
    }

    @PostMapping("/comment/option")
    @Operation(summary = "Manipulates a products comment setting"
            , description = "Manipulates a products comment setting, by changing the can comment field")
    public Boolean changeProductCommentSetting(@Valid @RequestBody ProductDisplayDto productDisplayDto) {
        return productService.changeProductCommentSetting(productDisplayDto);
    }

    @PostMapping("/vote/option")
    @Operation(summary = "Manipulates a products vote setting"
            , description = "Manipulates a products vote setting, by changing the vote field")
    public Boolean changeProductVoteSetting(@Valid @RequestBody ProductDisplayDto productDisplayDto) {
        return productService.changeProductVoteSetting(productDisplayDto);
    }
}
