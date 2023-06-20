package com.matin.productservice.service.referencedata.type;

import com.matin.productservice.dal.entity.referencedata.Type;
import com.matin.productservice.dal.repository.referencedata.TypeRepository;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.mapper.toentity.TypeMapperToEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService{

    private final TypeRepository typeRepository;

    private final TypeMapperToEntity typeMapperToEntity = Mappers.getMapper(TypeMapperToEntity.class);

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public void createType(ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        try{
            Type type = typeMapperToEntity.toEntity(referenceTransferDataDto);
            typeRepository.save(type);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }
}
