package com.matin.productservice.controller;

import com.matin.productservice.dto.comment.ChangeCommentStatusDto;
import com.matin.productservice.dto.vote.ChangeVoteStatusDto;
import com.matin.productservice.dto.vote.ProductVoteDto;
import com.matin.productservice.dto.vote.VoteDto;
import com.matin.productservice.service.vote.VoteService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Add vote to a product"
            , description = "Checks if a product has the add vote activated and if so adds the vote")
    public Boolean voteOnProduct(@PathVariable Long productId, @Valid @RequestBody VoteDto voteDto) {
        return voteService.voteOnProduct(productId, voteDto);
    }

    @GetMapping("/products/{productId}")
    @Operation(summary = "Returns a products votes"
            , description = "Returns a products Accepted votes count and average")
    public ProductVoteDto getProductVoteDetails(@PathVariable Long productId) {
        return voteService.getProductVoteDetails(productId);
    }

    @PostMapping("/product/change-status")
    @Operation(summary = "Updates a Products votes status"
            , description = "Updates a Products votes status")
    public Boolean changeVoteStatus(@Valid @RequestBody ChangeVoteStatusDto changeVoteStatusDto) {
        return voteService.changeVoteStatus(changeVoteStatusDto);
    }
}
