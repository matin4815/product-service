package com.matin.productservice.service.referencedata.provider;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.repository.referencedata.ProviderRepository;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.mapper.todto.ProviderMapperToDto;
import com.matin.productservice.mapper.toentity.ProviderMapperToEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapperToEntity providerMapperToEntity = Mappers.getMapper(ProviderMapperToEntity.class);
    private final ProviderMapperToDto providerMapperToDto = Mappers.getMapper(ProviderMapperToDto.class);

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public void createProvider(ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        try {
            Provider provider = providerMapperToEntity.toEntity(referenceTransferDataDto);
            providerRepository.save(provider);
        } catch (Exception e) {
            log.error("Failed to create provider: {}", referenceTransferDataDto, e);
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ReferenceTransferDataDto> getAllProviders() {
        List<Provider> providers = providerRepository.findAll();
        if (providers.isEmpty()) {
            log.warn("No providers were found");
            throw new RuntimeException("There are no items present");
        }
        return providerMapperToDto.listProviderToDto(providers);
    }

    @Override
    public ReferenceTransferDataDto getProviderByName(String name) {
        Optional<Provider> provider = providerRepository.findByName(name);
        if (provider.isPresent()) {
            return providerMapperToDto.toDto(provider.get());
        } else {
            log.warn("Provider not found for the given name: {}", name);
            throw new RuntimeException("The item was not found");
        }
    }

    @Override
    public ReferenceTransferDataDto getProviderById(Long id) {
        Optional<Provider> provider = providerRepository.findById(id);
        if (provider.isPresent()) {
            return providerMapperToDto.toDto(provider.get());
        } else {
            log.warn("Provider not found for the given ID: {}", id);
            throw new RuntimeException("The item was not found");
        }
    }
}
