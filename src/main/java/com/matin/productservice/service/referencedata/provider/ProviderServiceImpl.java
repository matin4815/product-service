package com.matin.productservice.service.referencedata.provider;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.repository.referencedata.ProviderRepository;
import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.mapper.todto.ProviderMapperToDto;
import com.matin.productservice.mapper.toentity.ProviderMapperToEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<ReferenceTransferDataDto> getAllProviders() {
        List<Provider> providers = providerRepository.findAll();
        return checkProviderListPresent(providers);

    }

    private List<ReferenceTransferDataDto> checkProviderListPresent(List<Provider> providers) {
        if(providers.size() != 0) {
            return providerMapperToDto.listProviderToDto(providers);
        } else {
            throw new RuntimeException("There are no items present");
        }
    }

    @Override
    public ReferenceTransferDataDto getProviderByName(String name) {
        Optional<Provider> provider = providerRepository.findByName(name);
        return checkProviderPresent(provider);
    }

    private ReferenceTransferDataDto checkProviderPresent(Optional<Provider> provider) {
        if(provider.isPresent())
            return providerMapperToDto.toDto(provider.get());
        else {
            throw new RuntimeException("The item was not found");
        }
    }

    @Override
    public ReferenceTransferDataDto getProviderById(Long id) {
        Optional<Provider> provider = providerRepository.findById(id);
        return checkProviderPresent(provider);
    }
}
