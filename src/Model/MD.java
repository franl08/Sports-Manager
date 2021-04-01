package Model;

import java.util.List;
import java.util.Set;

// Midfielder
public class MD extends Player{
    private int overall;

    public MD(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public MD(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, teamsHistory, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public MD(MD m){
        super(m.getId(), m.getName(), m.getNumber(), m.getCurrentTeam(), m.getTeamsHistory(), m.getPos(), m.getPace(), m.getEndurance(), m.getSkill(), m.getImpulsion(), m.getHeading(), m.getFinishing(), m.getPassing(), m.getTackling(), m.getPositioning());
        this.overall = m.getOverall();
    }

    public MD clone(){
        return new MD(this);
    }

    public int getOverall(){
        return this.overall;
    }

    public void setOverall() {
        this.overall = calOverall(Position.MD);
    }
}
