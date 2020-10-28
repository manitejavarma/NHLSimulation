package simulation.model;

import db.data.IPlayerFactory;

public class Player extends SharedAttributes implements Comparable<Player>{

    public Player(){}

    public Player(int id){
        setId(id);
    }

    public Player(int id, IPlayerFactory factory) throws Exception {
        setId(id);
        factory.loadPlayerById(id, this);
    }

    public Player(Player player){
        this.setId(player.getId());
        this.setName(player.getName());
        this.setAge(player.getAge());
        this.setSaving(player.getSaving());
        this.setChecking(player.getChecking());
        this.setShooting(player.getShooting());
        this.setSkating(player.getSkating());
        this.setPosition(player.getPosition());
    }

    private int age;

    private String hometown;

    private Position position;

    @Override
    public int compareTo(Player player) {
        double compare = this.getStrength()-player.getStrength();
        int returnValue = 0;
        if(compare > 0){
            returnValue = 1;
        } else if (compare < 0){
            returnValue = -1;
        }
        return returnValue;
    }

    public enum Position{
        forward,
        defense,
        goalie
    }

    private int teamId;

    private int freeAgentId;

    private boolean isCaptain;

    private int seasonId;

    private int skating;

    private int shooting;

    private int checking;

    private int saving;

    private double strength;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public int getFreeAgentId() {
        return freeAgentId;
    }
    public int getSkating() {
        return skating;
    }

    public void setSkating(int skating) {
        this.skating = skating;
    }

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public int getChecking() {
        return checking;
    }

    public void setChecking(int checking) {
        this.checking = checking;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }


    public void setStrength() {
        switch (position) {
            case forward:
                this.strength = getSkating() + getShooting() + (getChecking() / 2);
                break;
            case defense:
                this.strength = getSkating() + getChecking() + (getShooting() / 2);
                break;
            case goalie:
                this.strength = getSkating() + getSaving();
                break;
        }
    }

    public double getStrength(){
        return strength;
    }

    public void setFreeAgentId(int freeAgentId) {
        this.freeAgentId = freeAgentId;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public void addPlayer(IPlayerFactory addPlayerFactory) throws Exception {
        addPlayerFactory.addPlayer(this);
    }

    private String playerTradeStatus;

    public String getPlayerTradeStatus() {
        return playerTradeStatus;
    }

    public void setPlayerTradeStatus(String playerTradeStatus) {
        this.playerTradeStatus = playerTradeStatus;
    }
}
