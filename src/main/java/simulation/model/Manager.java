package simulation.model;

public class Manager extends ParentObj {
    private int leagueId;
    private int teamId;

    public Manager() {
    }


    public Manager(int id) {
        setId(id);
    }

    public Manager(Manager manager) {
        this.setId(manager.getId());
        this.setLeagueId(manager.getLeagueId());
        if (manager.getName() != null) {
            this.setName(manager.getName());
        }
        this.setTeamId(manager.teamId);
    }


    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

}
