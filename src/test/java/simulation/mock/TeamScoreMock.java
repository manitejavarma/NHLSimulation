package simulation.mock;

import db.data.ITeamScoreFactory;
import simulation.model.Game;
import simulation.model.TeamScore;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TeamScoreMock implements ITeamScoreFactory {
    @Override
    public long addTeamScore(int leagueId, int regularSeason, TeamScore teamScore) throws Exception {
        teamScore.setId(0);
        teamScore.setPoints(10);
        teamScore.setNumberOfWins(5);
        teamScore.setNumberOfLoss(10);
        teamScore.setNumberOfTies(0);
        teamScore.setTeamName("Team0");
        return teamScore.getId();
    }

    @Override
    public void loadTeamScoreById(int id, TeamScore teamScore) throws Exception {
        switch (id){
            case 1:
                teamScore.setId(id);
                teamScore.setTeamName("Team1");
                teamScore.setNumberOfTies(0);
                teamScore.setNumberOfLoss(5);
                teamScore.setNumberOfWins(6);
                teamScore.setPoints(12);
                break;
            case 2:
                teamScore.setId(id);
                teamScore.setTeamName("Team2");
                teamScore.setNumberOfTies(0);
                teamScore.setNumberOfLoss(0);
                teamScore.setNumberOfWins(2);
                teamScore.setPoints(4);
                break;
            case 3:
                teamScore.setId(id);
                teamScore.setTeamName(null);
                teamScore.setNumberOfTies(0);
                teamScore.setNumberOfLoss(0);
                teamScore.setNumberOfWins(0);
                teamScore.setPoints(0);
                break;
        }
    }

    @Override
    public List<TeamScore> loadRegularTeamScoreListByLeagueId(int leagueId) throws Exception {
        List<TeamScore> teamScoreList = null;
        switch (leagueId) {
            case 0:
                TeamScore teamScore = new TeamScore();
                teamScore.setId(4);
                teamScore.setTeamName("Team1");
                teamScore.setNumberOfTies(0);
                teamScore.setNumberOfLoss(5);
                teamScore.setNumberOfWins(6);
                teamScore.setPoints(12);

                TeamScore teamScore2 = new TeamScore();
                teamScore2.setId(5);
                teamScore2.setTeamName("Team4");
                teamScore2.setNumberOfTies(0);
                teamScore2.setNumberOfLoss(5);
                teamScore2.setNumberOfWins(7);
                teamScore2.setPoints(14);

                TeamScore teamScore3 = new TeamScore();
                teamScore3.setId(6);
                teamScore3.setTeamName("Team5");
                teamScore3.setNumberOfTies(0);
                teamScore3.setNumberOfLoss(6);
                teamScore3.setNumberOfWins(8);
                teamScore3.setPoints(16);

                teamScoreList.add(teamScore);
                teamScoreList.add(teamScore2);
                teamScoreList.add(teamScore3);
                break;
        }
        return teamScoreList;
    }

    @Override
    public List<TeamScore> loadPlayoffTeamScoreListByLeagueId(int leagueId) throws Exception {
        List<TeamScore> teamScoreList = null;
        switch (leagueId) {
            case 0:
                TeamScore teamScore = new TeamScore();
                teamScore.setId(4);
                teamScore.setTeamName("Team6");
                teamScore.setNumberOfTies(0);
                teamScore.setNumberOfLoss(5);
                teamScore.setNumberOfWins(6);
                teamScore.setPoints(12);

                TeamScore teamScore2 = new TeamScore();
                teamScore2.setId(5);
                teamScore2.setTeamName("Team7");
                teamScore2.setNumberOfTies(0);
                teamScore2.setNumberOfLoss(5);
                teamScore2.setNumberOfWins(7);
                teamScore2.setPoints(14);

                TeamScore teamScore3 = new TeamScore();
                teamScore3.setId(6);
                teamScore3.setTeamName("Team8");
                teamScore3.setNumberOfTies(0);
                teamScore3.setNumberOfLoss(6);
                teamScore3.setNumberOfWins(8);
                teamScore3.setPoints(16);

                teamScoreList.add(teamScore);
                teamScoreList.add(teamScore2);
                teamScoreList.add(teamScore3);
                break;
        }
        return teamScoreList;
    }

    @Override
    public void updateTeamScoreById(TeamScore teamScore) {
        teamScore.setId(teamScore.getId());
        teamScore.setPoints(teamScore.getPoints());
        teamScore.setNumberOfWins(teamScore.getNumberOfWins());
        teamScore.setNumberOfLoss(teamScore.getNumberOfLoss());
        teamScore.setNumberOfTies(teamScore.getNumberOfTies());
        teamScore.setTeamName(teamScore.getName());
    }
}