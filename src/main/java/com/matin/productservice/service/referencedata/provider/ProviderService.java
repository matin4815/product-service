package com.matin.productservice.service.referencedata.provider;

import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;

import java.util.List;

public interface ProviderService {

    void createProvider(ReferenceTransferDataDto referenceTransferDataDto) throws Exception;

    List<ReferenceTransferDataDto> getAllProviders();

    ReferenceTransferDataDto getProviderByName(String name);

    ReferenceTransferDataDto getProviderById(Long id);
}
