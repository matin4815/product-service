package com.matin.productservice.mapper;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.mapper.todto.ProviderMapperToDto;
import com.matin.productservice.mapper.todto.TypeMapperToDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring_toDto", uses = {TypeMapperToDto.class,
        ProviderMapperToDto.class})
public interface ToProductDtoMapper {

    ProductDto toProductDto(Product product);

}
