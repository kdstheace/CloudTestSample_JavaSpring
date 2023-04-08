package com.foodleague.shinjukuleague.service.impl;

import org.springframework.stereotype.Service;

import com.foodleague.shinjukuleague.repository.LeagueRepository;

@Service
public class LeagueServiceImpl {
    private LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }
}
