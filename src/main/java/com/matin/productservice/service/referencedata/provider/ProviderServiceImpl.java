package com.matin.productservice.service.referencedata.provider;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.repository.referencedata.ProviderRepository;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.mapper.toentity.ProviderMapperToEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    private final ProviderMapperToEntity providerMapperToEntity = Mappers.getMapper(ProviderMapperToEntity.class);

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public void createProvider(ReferenceTransferDataDto referenceTransferDataDto) throws Exception {

        try {
            Provider provider = providerMapperToEntity.toEntity(referenceTransferDataDto);
            providerRepository.save(provider);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<ReferenceTransferDataDto> getAllProviders() {
        return null;
    }

    @Override
    public ReferenceTransferDataDto getProviderByName(String name) {
        return null;
    }

    @Override
    public ReferenceTransferDataDto getProviderById(Long id) {
        return null;
    }
}
