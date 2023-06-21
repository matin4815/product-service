package com.matin.productservice.service.vote;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dal.entity.Vote;
import com.matin.productservice.dal.repository.VoteRepository;
import com.matin.productservice.dto.vote.ProductVoteDto;
import com.matin.productservice.dto.vote.VoteDto;
import com.matin.productservice.enums.VoteState;
import com.matin.productservice.mapper.VoteMapper;
import com.matin.productservice.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VoteServiceImpl implements VoteService{

    private final VoteRepository voteRepository;
    private final ProductService productService;

    private final VoteMapper voteMapper = Mappers.getMapper(VoteMapper.class);

    private static final VoteState validVoteStatus = VoteState.ACCEPTED;

    public VoteServiceImpl(VoteRepository voteRepository, ProductService productService) {
        this.voteRepository = voteRepository;
        this.productService = productService;
    }

    @Override
    public Boolean voteOnProduct(Long productId, VoteDto voteDto) {

        try {
            Product product = checkCanVoteOnProduct(productId);
            Vote vote = voteMapper.toVote(voteDto);
            vote.setProduct(product);
            voteRepository.save(vote);
            return true;
        }catch (Exception e) {
            log.error("THERE WAS AN ERROR LEAVING A VOTE ON THE PRODUCT WITH ID " + productId);
            throw new RuntimeException(e.getMessage());
        }
    }

    private Product checkCanVoteOnProduct(Long productId) {
        Product product = getProduct(productId);
        if(!product.getCanVote()) {
            throw new RuntimeException("CANT VOTE ON THIS PRODUCT");
        }
        return product;
    }

    @Override
    public ProductVoteDto getProductVoteDetails(Long productId) {

        Product product = getProduct(productId);
        try{
            ProductVoteDto productVoteDto = new ProductVoteDto();
            productVoteDto.setProductId(productId);
            productVoteDto.setVotesCount(getVoteCountByProductAndState(product));
            productVoteDto.setAverageVote(getAverageVoteValueByProductAndState(product));
            return productVoteDto;
        } catch (Exception e) {
            log.error("AN ERROR OCCURRED WHILE TRYING CALCULATE VOTES FOR PRODUCT WITH THE ID " + productId);
            throw new RuntimeException(e.getMessage());
        }

    }

    private Product getProduct(Long productId) {
        return productService.getProductById(productId).orElseThrow(() -> new RuntimeException("PRODUCT NOT FOUND"));
    }

    @Override
    public Integer getVoteCountByProductAndState(Product product) {
        return voteRepository.getVoteCountByProductAndState(product, VoteServiceImpl.validVoteStatus);
    }

    @Override
    public Double getAverageVoteValueByProductAndState(Product product) {
        return voteRepository.getAverageVoteValueByProductAndState(product, VoteServiceImpl.validVoteStatus);
    }
}
