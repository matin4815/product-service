package com.matin.productservice.dal.repository;

import com.matin.productservice.dal.entity.Comment;
import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.enums.CommentState;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByProductAndState(Product product, CommentState commentState, Pageable pageable);

    List<Comment> findCommentByProduct(Product product);

}
