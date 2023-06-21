package com.matin.productservice.dal.entity;

import com.matin.productservice.enums.CommentState;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String username;

    @Column(name = "entry_date",nullable = false)
    private Date entryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private CommentState state;

    @PrePersist
    private void setDefaultState() {
        if (state == null) {
            state = CommentState.UNACCEPTED;
        }
    }
}
