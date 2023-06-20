package com.matin.productservice.mapper.todto;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.entity.referencedata.Type;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring_toDto")
public interface TypeMapperToDto {

    ReferenceTransferDataDto toDto(Type type);

    List<ReferenceTransferDataDto> listTypeToDto(List<Type> types);

}
