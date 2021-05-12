package Model;

import java.util.List;

public class MD extends FieldPlayer{
    private final Position curPosition = Position.MIDFIELDER;

    public MD() {
        super();
        super.setOverall(calcOverall());
    }

    public MD(Player p) {
        super(p);
        super.setOverall(calcOverall());
    }

    public MD(String id, String name, Team currentTeam, List<Team> historic) {
        super(id, name, currentTeam, historic);
        super.setOverall(calcOverall());
    }

    public MD(String id, String name, Team currentTeam) {
        super(id, name, currentTeam);
        super.setOverall(calcOverall());
    }

    public MD(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public MD(String id, String name, Team currentTeam, List<Team> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public MD(String id, String name, Team currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public MD(MD m){
        super(m.getId(), m.getName(), m.getCurrentTeam(), m.getHistoric(), m.getVelocity(), m.getEndurance(), m.getSkill(), m.getImpulsion(), m.getHeading(), m.getFinishing(), m.getPassing(), m.getCrossing(), m.getBallRecovery(), m.getPositioning(), m.getCreativity(), m.getAggressiveness(), m.getTackling(), m.getVision(), m.getPosition());
        super.setOverall(calcOverall());
    }

    public MD clone(){
        return new MD(this);
    }

    public Position getPosition(){
        return this.curPosition;
    }

    public int calcOverall() {
        int newPositioning;
        if (this.getPosition().equals(this.curPosition))
            newPositioning = this.getPositioning();

        else if (this.getPosition().equals(Position.WINGER))
            newPositioning = (int) (this.getPositioning() * 0.75);

        else
            newPositioning = (int) (this.getPositioning() * 0.5);

        return (int) ((this.getTackling() * 0.03) + (this.getAggressiveness() * 0.02) + (this.getCreativity() * 0.08) +
                (this.getFinishing() * 0.03) + (this.getCrossing() * 0.02) + (this.getBallRecovery() * 0.2) +
                (newPositioning * 0.14) + (this.getVision() * 0.11) + (this.getPassing() * 0.13) +
                (this.getHeading() * 0.01) + (this.getImpulsion() * 0.01) + (this.getSkill() * 0.08) +
                (this.getEndurance() * 0.06) + (this.getVelocity() * 0.06));
    }

    public Position getCurPosition(){
        return this.curPosition;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Miedfielder\n");
        return sb.toString();
    }
}
