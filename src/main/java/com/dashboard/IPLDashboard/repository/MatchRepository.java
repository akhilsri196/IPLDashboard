package com.dashboard.IPLDashboard.repository;

import com.dashboard.IPLDashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {
    List<Match> getMatchesByTeam1OrTeam2OrderByDateDesc(String team1, String team2, Pageable pageable);
    default List<Match> findLatestMatchesByTeam(String teamName, int countOfMatches){

        Pageable pageable = PageRequest.of(0,countOfMatches);
        return getMatchesByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable);
    }
}
