package com.matin.productservice.dal.entity;

import com.matin.productservice.enums.VoteState;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "votes")
@Data
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vote_value",nullable = false)
    @Min(1)
    @Max(5)
    private Integer value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "entry_date",nullable = false)
    private Date entryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private VoteState state;


    @PrePersist
    private void setDefaultState() {
        if (state == null) {
            state = VoteState.UNACCEPTED;
        }
    }

}
