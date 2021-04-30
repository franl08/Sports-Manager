package Model;

import java.util.List;

public class DF extends FieldPlayer{
    private final Position curPosition = Position.DEFENDER;
    private int overall;

    public DF() {
        super();
        this.overall = calcOverall();
    }

    public DF(Player p) {
        super(p);
        this.overall = calcOverall();
    }

    public DF(String id, String name, Team currentTeam, List<Team> historic) {
        super(id, name, currentTeam, historic);
        this.overall = calcOverall();
    }

    public DF(String id, String name, Team currentTeam) {
        super(id, name, currentTeam);
        this.overall = calcOverall();
    }

    public DF(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        this.overall = calcOverall();
    }

    public DF(String id, String name, Team currentTeam, List<Team> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        this.overall = calcOverall();
    }

    public DF(String id, String name, Team currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        this.overall = calcOverall();
    }

    public DF(DF d){
        super(d.getId(), d.getName(), d.getCurrentTeam(), d.getHistoric(), d.getVelocity(), d.getEndurance(), d.getSkill(), d.getImpulsion(), d.getHeading(), d.getFinishing(), d.getPassing(), d.getCrossing(), d.getBallRecovery(), d.getPositioning(), d.getCreativity(), d.getAggressiveness(), d.getTackling(), d.getVision(), d.getPosition());
        this.overall = d.getOverall();
    }

    public DF clone(){
        return new DF(this);
    }

    public int getOverall() {
        return this.overall;
    }

    public void setOverall(int o){
        this.overall = o;
    }

    public int calcOverall() {
        int newPositioning;
        if (this.getPosition().equals(this.curPosition))
            newPositioning = this.getPositioning();

        else if (this.getPosition().equals(Position.MIDFIELDER))
            newPositioning = (int) (this.getPositioning() * 0.75);

        else if (this.getPosition().equals(Position.WINGER))
            newPositioning = (int) (this.getPositioning() * 0.5);

        else
            newPositioning = (int) (this.getPositioning() * 0.25);

        return (int) ((this.getTackling() * 0.25) + (this.getAggressiveness() * 0.1) + (this.getCreativity() * 0.03) +
                (this.getFinishing() * 0.01) + (this.getCrossing() * 0.01) + (this.getBallRecovery() * 0.15) +
                (newPositioning * 0.1) + (this.getVision() * 0.05) + (this.getPassing() * 0.07) +
                (this.getHeading() * 0.07) + (this.getImpulsion() * 0.08) + (this.getSkill() * 0.02) +
                (this.getEndurance() * 0.04) + (this.getVelocity() * 0.02));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append("\n Overall: ").append(overall);
        return sb.toString();
    }
}
