package com.matin.productservice.dal.repository;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dal.entity.Vote;
import com.matin.productservice.enums.VoteState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.product = :product AND v.state = :state")
    Integer getVoteCountByProductAndState(@Param("product") Product product, @Param("state") VoteState state);

    @Query("SELECT AVG(v.value) FROM Vote v WHERE v.product = :product AND v.state = :state")
    Double getAverageVoteValueByProductAndState(@Param("product") Product product, @Param("state") VoteState state);

}
