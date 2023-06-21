package com.matin.productservice.controller;

import com.matin.productservice.dto.referencedata.ReferenceTransferDataDto;
import com.matin.productservice.service.referencedata.provider.ProviderService;
import com.matin.productservice.service.referencedata.type.TypeService;
import io.swagger.v3.oas.annotations.Operation;
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

    // Provider Endpoints

    @PostMapping("/providers")
    @Operation(summary = "Creates a provider reference data"
            , description = "Creates a provider reference data by valid dto")
    public void createProvider(@RequestBody @Valid ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        providerService.createProvider(referenceTransferDataDto);
    }

    @GetMapping("/providers")
    @Operation(summary = "Returns all providers"
            , description = "Returns all providers reference data")
    public List<ReferenceTransferDataDto> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/providers/{id}")
    @Operation(summary = "Returns a provider by id"
            , description = "Returns a provider by id")
    public ReferenceTransferDataDto getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    @GetMapping("/providers/name/{name}")
    @Operation(summary = "Returns a provider by name"
            , description = "Returns a provider by name")
    public ReferenceTransferDataDto getProviderByName(@PathVariable String name) {
        return providerService.getProviderByName(name);
    }

    // Type Endpoints

    @PostMapping("/types")
    @Operation(summary = "Creates a type reference data"
            , description = "Creates a type reference data by valid dto")
    public void createType(@RequestBody @Valid ReferenceTransferDataDto referenceTransferDataDto) throws Exception {
        typeService.createType(referenceTransferDataDto);
    }

    @GetMapping("/types")
    @Operation(summary = "Returns all types"
            , description = "Returns all types reference data")
    public List<ReferenceTransferDataDto> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/types/{id}")
    @Operation(summary = "Returns a type by Id"
            , description = "Returns a type by Id")
    public ReferenceTransferDataDto getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id);
    }

    @GetMapping("/types/name/{name}")
    @Operation(summary = "Returns a type by name"
            , description = "Returns a type by name")
    public ReferenceTransferDataDto getTypeByName(@PathVariable String name) {
        return typeService.getTypeByName(name);
    }
}
