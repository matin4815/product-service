package com.matin.productservice.dal.repository;

import com.matin.productservice.dal.entity.Comment;
import com.matin.productservice.dal.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByProduct(Product product, Pageable pageable);

}
