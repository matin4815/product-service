package com.matin.productservice.controller;

import com.matin.productservice.dto.vote.ProductVoteDto;
import com.matin.productservice.dto.vote.VoteDto;
import com.matin.productservice.service.vote.VoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
@CrossOrigin("*")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/products/{productId}")
    public Boolean voteOnProduct(@PathVariable Long productId, @Valid @RequestBody VoteDto voteDto) {
        return voteService.voteOnProduct(productId, voteDto);
    }

    @GetMapping("/products/{productId}")
    public ProductVoteDto getProductVoteDetails(@PathVariable Long productId) {
        return voteService.getProductVoteDetails(productId);
    }
}
