package com.foodleague.shinjukuleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodleague.shinjukuleague.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
