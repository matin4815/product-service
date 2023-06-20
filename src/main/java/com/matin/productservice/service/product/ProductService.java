package com.matin.productservice.service.product;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDto;

import java.util.List;

public interface ProductService {

    Boolean createProduct(ProductDto productDto) throws Exception;

    List<Product> getAllProducts();
}
