package com.matin.productservice.service.product;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dal.repository.ProductRepository;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.mapper.ToProductDtoMapper;
import com.matin.productservice.mapper.ToProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ToProductMapper toProductMapper = Mappers.getMapper(ToProductMapper.class);
    private final ToProductDtoMapper toProductDtoMapper = Mappers.getMapper(ToProductDtoMapper.class);

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
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if(products.size() != 0) {
            return products.stream().map(toProductDtoMapper::toProductDto).toList();
        } else {
            log.warn("THERE WERE NO FILES TO BE RENDERED.");
            throw new RuntimeException("No products were found!");
        }
    }

    @Override
    public ProductDto getProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return checkProductPresent(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product;
        }else {
            log.warn("REQUESTED OBJECT DID NOT EXIST.");
            throw new RuntimeException("Item was not found");
        }
    }

    private ProductDto checkProductPresent(Optional<Product> product) {
        if(product.isPresent()) {
            return toProductDtoMapper.toProductDto(product.get());
        } else
            log.warn("REQUESTED OBJECT DID NOT EXIST.");
            throw new RuntimeException("Item was not found");
    }

}
