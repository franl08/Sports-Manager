package Model;

import java.util.List;

public class FW extends FieldPlayer{
    private final Position curPosition = Position.FORWARD;

    public FW() {
        super();
        super.setOverall(calcOverall());
    }

    public FW(Player p) {
        super(p);
        super.setOverall(calcOverall());
    }

    public FW(String id, String name, Team currentTeam, List<Team> historic) {
        super(id, name, currentTeam, historic);
        super.setOverall(calcOverall());
    }

    public FW(String id, String name, Team currentTeam) {
        super(id, name, currentTeam);
        super.setOverall(calcOverall());
    }

    public FW(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public FW(String id, String name, Team currentTeam, List<Team> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public FW(String id, String name, Team currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public FW(FW f){
        super(f.getId(), f.getName(), f.getCurrentTeam(), f.getHistoric(), f.getVelocity(), f.getEndurance(), f.getSkill(), f.getImpulsion(), f.getHeading(), f.getFinishing(), f.getPassing(), f.getCrossing(), f.getBallRecovery(), f.getPositioning(), f.getCreativity(), f.getAggressiveness(), f.getTackling(), f.getVision(), f.getPosition());
        super.setOverall(calcOverall());
    }

    public FW clone(){
        return new FW(this);
    }

    public int calcOverall() {
        int newPositioning;
        if (this.getPosition().equals(this.curPosition))
            newPositioning = this.getPositioning();

        else if (this.getPosition().equals(Position.WINGER))
            newPositioning = (int) (this.getPositioning() * 0.75);

        else if (this.getPosition().equals(Position.MIDFIELDER))
            newPositioning = (int) (this.getPositioning() * 0.5);

        else
            newPositioning = (int) (this.getPositioning() * 0.25);

        return (int) ((this.getTackling() * 0.01) + (this.getAggressiveness() * 0.05) + (this.getCreativity() * 0.03) +
                (this.getFinishing() * 0.25) + (this.getCrossing() * 0.01) + (this.getBallRecovery() * 0.01) +
                (newPositioning * 0.09) + (this.getVision() * 0.08) + (this.getPassing() * 0.05) +
                (this.getHeading() * 0.1) + (this.getImpulsion() * 0.07) + (this.getSkill() * 0.1) +
                (this.getEndurance() * 0.04) + (this.getVelocity() * 0.11));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Forward\n");
        return sb.toString();
    }
}
