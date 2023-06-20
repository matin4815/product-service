package com.matin.productservice.controller;

import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.service.referencedata.provider.ProviderService;
import com.matin.productservice.service.referencedata.type.TypeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reference-data")
@CrossOrigin("*")
public class ReferenceDataController {

    private final ProviderService providerService;

    private final TypeService typeService;

    public ReferenceDataController(ProviderService providerService, TypeService typeService) {
        this.providerService = providerService;
        this.typeService = typeService;
    }

    //provider

    @PostMapping("/provider")
    public void createProvider(@RequestBody @Valid ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        providerService.createProvider(referenceTransferDataDto);
    }

    @GetMapping("/providers")
    public List<ReferenceTransferDataDto> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/provider")
    public ReferenceTransferDataDto getProviderById(@RequestParam Long id) {
        return providerService.getProviderById(id);
    }

    @GetMapping("/provider/{name}")
    public ReferenceTransferDataDto getProviderByName(@PathVariable String name) {
        return providerService.getProviderByName(name);
    }

    //type

    @PostMapping("/type")
    public void createType(@RequestBody @Valid ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        typeService.createType(referenceTransferDataDto);
    }

    @GetMapping("/types")
    public List<ReferenceTransferDataDto> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/type")
    public ReferenceTransferDataDto getTypeById(@RequestParam Long id) {
        return typeService.getTypeById(id);
    }

    @GetMapping("/type/{name}")
    public ReferenceTransferDataDto getTypeByName(@PathVariable String name) {
        return typeService.getTypeByName(name);
    }

}
