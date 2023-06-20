package com.matin.productservice.controller;

import com.matin.productservice.dto.comment.CommentDto;
import com.matin.productservice.service.comment.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/products/{productId}")
    public Boolean addCommentToProduct(@PathVariable Long productId, @RequestBody @Valid CommentDto commentDto) {
        return commentService.addCommentToProduct(productId, commentDto);
    }

    @GetMapping("/products/{productId}")
    public List<CommentDto> getProductComments(@PathVariable Long productId, @RequestParam Integer page) {
        return commentService.getProductComments(productId, page);
    }


}
