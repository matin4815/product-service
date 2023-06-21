package com.matin.productservice.dal.repository;

import com.matin.productservice.dal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findAllByIsVisibleTrue(Pageable pageable);
}
