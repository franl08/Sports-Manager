package Model;

import java.util.List;

public class WG extends FieldPlayer{
    private final Position curPosition = Position.WINGER;

    /**
     * Empty Constructor
     */
    public WG() {
        super();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with a Field Player
     * @param p a Field Player
     */
    public WG(FieldPlayer p) {
        super(p);
        super.setPosition(p.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team and historic
     * @param id player ID
     * @param name player name
     * @param currentTeam player current team name
     * @param historic historic of player teams
     */
    public WG(String id, String name, String currentTeam, List<String> historic) {
        super(id, name, currentTeam, historic);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name and current team
     * @param id player ID
     * @param name player name
     * @param currentTeam player current team name
     */
    public WG(String id, String name, String currentTeam) {
        super(id, name, currentTeam);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Construct with player, attributes and position
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
    public WG(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team, historic, attributes and position
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
    public WG(String id, String name, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team, attributes and position
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team
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
    public WG(String id, String name, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Copy constructor
     * @param w Winger to copy
     */
    public WG(WG w){
        super(w.getId(), w.getName(), w.getCurrentTeamName(), w.getHistoric(), w.getVelocity(), w.getEndurance(), w.getSkill(), w.getImpulsion(), w.getHeading(), w.getFinishing(), w.getPassing(), w.getCrossing(), w.getBallRecovery(), w.getPositioning(), w.getCreativity(), w.getAggressiveness(), w.getTackling(), w.getVision(), w.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Cloning method
     * @return Cloned winger
     */
    public WG clone(){
        return new WG(this);
    }

    /**
     * Method to calculate player overall playing as winger
     * @return Player overall playing as winger
     */
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

    /**
     * Current player position getter
     * @return Current player position
     */
    public Position getCurPosition(){
        return this.curPosition;
    }

    /**
     * Method to pass a winger to string
     * @return winger as a string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Winger\n");
        return sb.toString();
    }
}
