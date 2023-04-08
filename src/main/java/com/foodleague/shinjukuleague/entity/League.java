package com.foodleague.shinjukuleague.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name="league"
    // ,uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
@Entity
public class League {
    @OneToMany(mappedBy = "league")
    private List<Candidate> candidateList = new ArrayList<>();

    @Id
    @Column(name = "league_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leagueId;

    @Column(name="title")
    private String title;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="view_cnt")
    private int viewCnt;
}
