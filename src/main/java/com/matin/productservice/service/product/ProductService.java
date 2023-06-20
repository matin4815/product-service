package com.matin.productservice.service.product;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Boolean createProduct(ProductDto productDto) throws Exception;

    List<ProductDto> getAllProducts();

    ProductDto getProductByName(String name);

    Optional<Product> getProductById(Long id);
}
