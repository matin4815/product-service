package com.matin.productservice.service.product;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dal.repository.ProductRepository;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.mapper.ToProductMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ToProductMapper toProductMapper = Mappers.getMapper(ToProductMapper.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Boolean createProduct(ProductDto productDto) throws Exception {

        try {
            Product product = toProductMapper.productDtoToProduct(productDto);
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
