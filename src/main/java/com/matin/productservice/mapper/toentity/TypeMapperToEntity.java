package com.matin.productservice.mapper.toentity;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.entity.referencedata.Type;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring_toEntity")
public interface TypeMapperToEntity {

    @Mapping(target = "id")
    Type toEntity(ReferenceTransferDataDto referenceTransferDataDto);

    @Mapping(target = "id", qualifiedByName = "toEntity")
    List<Type> listTypeToEntity(List<ReferenceTransferDataDto> referenceTransferDataDtos);

}
