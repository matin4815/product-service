package com.matin.productservice.dal.repository.referencedata;

import com.matin.productservice.dal.entity.referencedata.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    Optional<Type> findByName(String name);

}
