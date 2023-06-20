package com.matin.productservice.service.comment;

import com.matin.productservice.dal.entity.Comment;
import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dal.repository.CommentRepository;
import com.matin.productservice.dto.comment.CommentDto;
import com.matin.productservice.mapper.CommentMapper;
import com.matin.productservice.service.product.ProductService;
import com.matin.productservice.utils.pagination.PageableFactory;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final ProductService productService;

    private final CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    public CommentServiceImpl(CommentRepository commentRepository, ProductService productService) {
        this.commentRepository = commentRepository;
        this.productService = productService;
    }

    @Override
    public Boolean addCommentToProduct(Long productId, CommentDto commentDto) {

        try{
            Product product = getProduct(productId);
            Comment comment = commentMapper.toComment(commentDto);
            comment.setProduct(product);
            commentRepository.save(comment);
            return true;
        } catch (Exception e) {
            log.error("THERE WAS AN ERROR ON ADDING A COMMENT TO THE PRODUCT WITH ID " + productId);
            throw new RuntimeException(e.getMessage());
        }

    }

    private Product getProduct(Long productId) {
        return productService.getProductById(productId).orElseThrow(() -> new RuntimeException("PRODUCT NOT FOUND"));
    }

    @Override
    public List<CommentDto> getProductComments(Long productId, Integer page) {

        Product product = getProduct(productId);
        Pageable pageable = PageableFactory.createPageable(page);
        return commentMapper.listCommentToCommentDto(commentRepository.findCommentByProduct(product, pageable));

    }

}
