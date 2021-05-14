package Model;

import java.util.List;

public class DF extends FieldPlayer{
    private final Position curPosition = Position.DEFENDER;

    /**
     * Empty Constructor
     */
    public DF() {
        super();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with a field player
     * @param fp Field player
     */
    public DF(FieldPlayer fp) {
        super(fp);
        super.setPosition(fp.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name and historic
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     * @param historic Historic of player teams
     */
    public DF(String id, String name, String currentTeam, List<String> historic) {
        super(id, name, currentTeam, historic);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name and current team name
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     */
    public DF(String id, String name, String currentTeam) {
        super(id, name, currentTeam);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player, attributes and position
     * @param p Player
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public DF(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name, historic, attributes and position
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     * @param historic Player historic
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public DF(String id, String name, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team, attributes and position
     * @param id
     * @param name
     * @param currentTeam
     * @param velocity
     * @param endurance
     * @param skill
     * @param impulsion
     * @param heading
     * @param finishing
     * @param passing
     * @param crossing
     * @param ballRecovery
     * @param positioning
     * @param creativity
     * @param aggressiveness
     * @param tackling
     * @param vision
     * @param position
     */
    public DF(String id, String name, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Copy constructor
     * @param d
     */
    public DF(DF d){
        super(d.getId(), d.getName(), d.getCurrentTeamName(), d.getHistoric(), d.getVelocity(), d.getEndurance(), d.getSkill(), d.getImpulsion(), d.getHeading(), d.getFinishing(), d.getPassing(), d.getCrossing(), d.getBallRecovery(), d.getPositioning(), d.getCreativity(), d.getAggressiveness(), d.getTackling(), d.getVision(), d.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Cloning method
     * @return Cloned defender
     */
    public DF clone(){
        return new DF(this);
    }

    /**
     * Method to calculate player overall playing as Defender
     * @return Player overall playing as defender
     */
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

    /**
     * Current player postion getter
     * @return Player current position
     */
    public Position getCurPosition(){
        return this.curPosition;
    }

    /**
     * Method to get Defender as String
     * @return Defender as String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Defender\n");
        return sb.toString();
    }
}
