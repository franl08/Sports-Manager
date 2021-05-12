package Model;

import java.util.List;

public class WG extends FieldPlayer{
    private final Position curPosition = Position.WINGER;

    public WG() {
        super();
        super.setOverall(calcOverall());
    }

    public WG(Player p) {
        super(p);
        super.setOverall(calcOverall());
    }

    public WG(String id, String name, Team currentTeam, List<Team> historic) {
        super(id, name, currentTeam, historic);
        super.setOverall(calcOverall());
    }

    public WG(String id, String name, Team currentTeam) {
        super(id, name, currentTeam);
        super.setOverall(calcOverall());
    }

    public WG(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public WG(String id, String name, Team currentTeam, List<Team> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public WG(String id, String name, Team currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    public WG(WG w){
        super(w.getId(), w.getName(), w.getCurrentTeam(), w.getHistoric(), w.getVelocity(), w.getEndurance(), w.getSkill(), w.getImpulsion(), w.getHeading(), w.getFinishing(), w.getPassing(), w.getCrossing(), w.getBallRecovery(), w.getPositioning(), w.getCreativity(), w.getAggressiveness(), w.getTackling(), w.getVision(), w.getPosition());
        super.setOverall(calcOverall());
    }

    public WG clone(){
        return new WG(this);
    }

    public int calcOverall() {
        int newPositioning;
        if (this.getPosition().equals(this.curPosition))
            newPositioning = this.getPositioning();

        else if (this.getPosition().equals(Position.MIDFIELDER))
            newPositioning = (int) (this.getPositioning() * 0.75);

        else if (this.getPosition().equals(Position.FORWARD))
            newPositioning = (int) (this.getPositioning() * 0.5);

        else
            newPositioning = (int) (this.getPositioning() * 0.25);

        return (int) ((this.getTackling() * 0.01) + (this.getAggressiveness() * 0.01) + (this.getCreativity() * 0.1) +
                (this.getFinishing() * 0.05) + (this.getCrossing() * 0.25) + (this.getBallRecovery() * 0.05) +
                (newPositioning * 0.05) + (this.getVision() * 0.08) + (this.getPassing() * 0.08) +
                (this.getHeading() * 0.01) + (this.getImpulsion() * 0.01) + (this.getSkill() * 0.08) +
                (this.getEndurance() * 0.07) + (this.getVelocity() * 0.15));
    }

    public Position getCurPosition(){
        return this.curPosition;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Winger\n");
        return sb.toString();
    }
}
