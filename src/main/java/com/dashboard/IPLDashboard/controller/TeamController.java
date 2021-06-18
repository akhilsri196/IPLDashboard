package com.dashboard.IPLDashboard.controller;

import com.dashboard.IPLDashboard.model.Match;
import com.dashboard.IPLDashboard.model.Team;
import com.dashboard.IPLDashboard.repository.MatchRepository;
import com.dashboard.IPLDashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
  Team team = teamRepository.findByTeamName(teamName);
        int countOfMatches = 4;
        List<Match> matchesByTeam = matchRepository.findLatestMatchesByTeam(teamName, countOfMatches);
        team.setMatches(matchesByTeam);
       return team;
    }

}
