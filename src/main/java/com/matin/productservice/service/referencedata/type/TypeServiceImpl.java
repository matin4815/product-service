package com.matin.productservice.service.referencedata.type;

import com.matin.productservice.dal.entity.referencedata.Type;
import com.matin.productservice.dal.repository.referencedata.TypeRepository;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.mapper.todto.TypeMapperToDto;
import com.matin.productservice.mapper.toentity.TypeMapperToEntity;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapperToEntity typeMapperToEntity = Mappers.getMapper(TypeMapperToEntity.class);
    private final TypeMapperToDto typeMapperToDto = Mappers.getMapper(TypeMapperToDto.class);

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void createType(ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        try {
            Type type = typeMapperToEntity.toEntity(referenceTransferDataDto);
            typeRepository.save(type);
        } catch (Exception e) {
            log.error("Failed to create type: {}", referenceTransferDataDto, e);
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ReferenceTransferDataDto> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        if (types.isEmpty()) {
            log.warn("No types were found");
            throw new RuntimeException("No items are present");
        }
        return typeMapperToDto.listTypeToDto(types);
    }

    @Override
    public ReferenceTransferDataDto getTypeById(Long id) {
        Optional<Type> type = typeRepository.findById(id);
        if (type.isPresent()) {
            return typeMapperToDto.toDto(type.get());
        } else {
            log.warn("Type not found for the given ID: {}", id);
            throw new RuntimeException("The item was not found");
        }
    }

    @Override
    public ReferenceTransferDataDto getTypeByName(String name) {
        Optional<Type> type = typeRepository.findByName(name);
        if (type.isPresent()) {
            return typeMapperToDto.toDto(type.get());
        } else {
            log.warn("Type not found for the given name: {}", name);
            throw new RuntimeException("The item was not found");
        }
    }
}
