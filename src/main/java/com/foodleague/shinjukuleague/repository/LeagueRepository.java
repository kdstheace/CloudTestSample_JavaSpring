package com.foodleague.shinjukuleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodleague.shinjukuleague.entity.League;

public interface LeagueRepository extends JpaRepository<League, Long> {

}
