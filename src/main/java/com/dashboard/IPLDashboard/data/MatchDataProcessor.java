package com.dashboard.IPLDashboard.data;

import com.dashboard.IPLDashboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        if("bat".equals(matchInput.getToss_decision())){
        match.setTeam1(matchInput.getToss_winner());
        match.setTeam2(matchInput.getTeam2().equals(matchInput.getToss_winner())?matchInput.getTeam1():matchInput.getTeam2());
        }else{
            match.setTeam2(matchInput.getToss_winner());
            match.setTeam1(matchInput.getTeam1().equals(matchInput.getToss_winner())?matchInput.getTeam2():matchInput.getTeam1());

        }
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setMatchWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setEliminator(matchInput.getEliminator());
        match.setMethod(matchInput.getMethod());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());


        //log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return match;
    }

}
