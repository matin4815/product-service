package com.matin.productservice.dal.entity;

import com.matin.productservice.dal.entity.referencedata.Provider;
import com.matin.productservice.dal.entity.referencedata.Type;
import jakarta.persistence.*;
import lombok.Data;

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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @OneToMany(mappedBy = "product")
    private List<Comment> comments;

    @Transient
    private int votesCount;

    @Transient
    private double averageVote;


    public void calculateVotesCountAndAverage(List<Vote> votes) {
        this.votesCount = votes.size();
        if (votesCount > 0) {
            double sum = votes.stream()
                    .mapToInt(Vote::getValue)
                    .sum();
            this.averageVote = (double) sum / votesCount;
        } else {
            this.averageVote = 0;
        }
    }

}
