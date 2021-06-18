package com.dashboard.IPLDashboard.repository;

import com.dashboard.IPLDashboard.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
Team findByTeamName(String teamName);
}
