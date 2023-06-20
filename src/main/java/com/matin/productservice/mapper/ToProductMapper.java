package com.matin.productservice.mapper;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.mapper.toentity.ProviderMapperToEntity;
import com.matin.productservice.mapper.toentity.TypeMapperToEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring_toEntity", uses = {TypeMapperToEntity.class,
        ProviderMapperToEntity.class})
public interface ToProductMapper {

    Product productDtoToProduct(ProductDto productDto);

}
