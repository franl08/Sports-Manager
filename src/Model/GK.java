package Model;

import java.util.List;

public class GK extends Player {
    private int elasticity;
    private int reflexes;
    private int agility;
    private int decisions;
    private final Position position = Position.GOALKEEPER;

    public GK() {
        super();
        this.elasticity = 0;
        this.reflexes = 0;
        this.agility = 0;
        this.decisions = 0;
    }
    public GK(String id, String name, Team currentTeam, List<Team> historic) {
        super(id, name, currentTeam, historic);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    public GK(Player p) {
        super(p);
        this.elasticity = utils.setRandomAttribute();
        this.reflexes = utils.setRandomAttribute();
        this.agility = utils.setRandomAttribute();
        this.decisions = utils.setRandomAttribute();
        super.setOverall(calcOverall());
    }

    public GK(String id, String name, Team currentTeam, List<Team> historic, int elasticity, int reflexes, int agility, int decisions) {
        super(id, name, currentTeam, historic);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        super.setOverall(calcOverall());
    }

    public GK(String id, String name, Team currentTeam, int elasticity, int reflexes, int agility, int decisions) {
        super(id, name, currentTeam);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        super.setOverall(calcOverall());
    }

    public GK(Player p, int elasticity, int reflexes, int agility, int decisions) {
        super(p);
        this.setElasticity(elasticity);
        this.setReflexes(reflexes);
        this.setAgility(agility);
        this.setDecisions(decisions);
        super.setOverall(calcOverall());
    }

    public GK(GK gk){
        super(gk.getId(), gk.getName(), gk.getCurrentTeam(), gk.getHistoric());
        this.setElasticity(gk.getElasticity());
        this.setReflexes(gk.getReflexes());
        this.setAgility(gk.getAgility());
        this.setDecisions(gk.getDecisions());
        super.setOverall(calcOverall());
    }

    public GK clone(){
        return new GK(this);
    }

    public int getElasticity() {
        return this.elasticity;
    }

    public void setElasticity(int elasticity) {
        if(elasticity > 99) this.elasticity = 99;
        else this.elasticity = Math.max(elasticity, 0);
    }

    public int getReflexes() {
        return this.reflexes;
    }

    public void setReflexes(int reflexes) {
        if(reflexes > 99) this.reflexes = 99;
        else this.reflexes = Math.max(reflexes, 0);
    }

    public int getAgility() {
        return this.agility;
    }

    public void setAgility(int agility) {
        if(agility > 99) this.agility = 99;
        else this.agility = Math.max(agility, 0);
    }

    public int getDecisions() {
        return this.decisions;
    }

    public void setDecisions(int decisions) {
        if(decisions > 99) this.decisions = 99;
        else this.decisions = Math.max(decisions, 0);
    }

    public Position getPosition() {
        return this.position;
    }

    public int calcOverall(){
        return (int) (this.elasticity * 0.25 + this.reflexes * 0.25 + this.agility * 0.25 + this.decisions * 0.25);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Goalkeeper\n");
        return sb.toString();
    }
}
