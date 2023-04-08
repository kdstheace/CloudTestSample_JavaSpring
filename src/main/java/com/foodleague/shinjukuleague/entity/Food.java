package com.foodleague.shinjukuleague.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name="food"
    // ,uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
@Entity
public class Food {
    @OneToMany(mappedBy = "food")
    private List<Candidate> candidateList = new ArrayList<>();

    @Id
    @Column(name = "food_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private BigDecimal price = BigDecimal.valueOf(0);

    @Column(name="is_del")
    private boolean isDel = false;

    @Column(name="win_cnt", nullable = false)
    private int winCnt = 0;
}
