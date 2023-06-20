package com.matin.productservice.service.referencedata.type;

import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;

import java.util.List;

public interface TypeService {

    void createType(ReferenceTransferDataDto referenceTransferDataDto) throws Exception;

    List<ReferenceTransferDataDto> getAllTypes();

    ReferenceTransferDataDto getTypeById(Long id);

    ReferenceTransferDataDto getTypeByName(String name);
}
