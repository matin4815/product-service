package com.matin.productservice.mapper.toentity;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring_toEntity")
public interface ProviderMapperToEntity {

    Provider toEntity(ReferenceTransferDataDto referenceTransferDataDto);

    List<Provider> listProviderToEntity(List<ReferenceTransferDataDto> referenceTransferDataDtos);
}
