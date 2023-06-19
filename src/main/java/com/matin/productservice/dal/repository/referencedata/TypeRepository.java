package com.matin.productservice.dal.repository.referencedata;

import com.matin.productservice.dal.entity.referencedata.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
