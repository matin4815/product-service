package com.matin.productservice.dal.repository.referencedata;

import com.matin.productservice.dal.entity.referencedata.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
