package com.matin.productservice.dal.entity;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.entity.referencedata.Type;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @Column(name = "is_visible", columnDefinition = "boolean default true", nullable = false)
    private Boolean isVisible;

    @Column(name = "can_comment", nullable = false)
    private Boolean canComment;

    @Column(name = "can_vote", nullable = false)
    private Boolean canVote;

    @Transient
    private List<Comment> comments;

    @Transient
    private Integer votesCount;

    @Transient
    private Double averageVote;

}
