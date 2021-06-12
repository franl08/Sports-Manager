package Model;

import java.util.List;

/**
 * Midfielders class
 */
public class MD extends FieldPlayer{
    /**
     * Midfielder's position
     */
    private final Position curPosition = Position.MIDFIELDER;

    /**
     * Empty Constructor
     */
    public MD() {
        super();
        super.setOverall(calcOverall());
    }

    /**
     * Construct with Field Player
     * @param p Field Player
     */
    public MD(FieldPlayer p) {
        super(p);
        super.setPosition(p.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player name, number, current team name and historic
     * @param name Player name
     * @param number Player number
     * @param currentTeam Player current team name
     * @param historic Player historic
     */
    public MD(String name, int number, String currentTeam, List<String> historic) {
        super(name, number, currentTeam, historic);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player name, number and current team name
     * @param name Player name
     * @param number Player number
     * @param currentTeam Player current team name
     */
    public MD(String name, int number, String currentTeam) {
        super(name, number, currentTeam);
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
    public MD(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player name, number, current team name, historic, attributes and position
     * @param name Player name
     * @param number Player number
     * @param currentTeam Player current team
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
    public MD(String name, int number, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player name, number, current team name, attributes and position
     * @param name Player name
     * @param number Player number
     * @param currentTeam Player current team name
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
    public MD(String name, int number, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor for logs
     * @param name Player name
     * @param number Player number
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     */
    public MD(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing) {
        super(name, number, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, Position.MIDFIELDER);
        super.setOverall(calcOverall());
    }

    /**
     * Copy constructor
     * @param m Midfielder to copy
     */
    public MD(MD m){
        super(m.getName(), m.getNumber(), m.getCurrentTeamName(), m.getHistoric(), m.getVelocity(), m.getEndurance(), m.getSkill(), m.getImpulsion(), m.getHeading(), m.getFinishing(), m.getPassing(), m.getCrossing(), m.getBallRecovery(), m.getPositioning(), m.getCreativity(), m.getAggressiveness(), m.getTackling(), m.getVision(), m.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Cloning method
     * @return Cloned midfielder
     */
    public MD clone(){
        return new MD(this);
    }

    /**
     * Method to calculate player overall playing as midfielder
     * @return Player overall playing as midfielder
     */
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

    /**
     * Current player position getter
     * @return Current player position
     */
    public Position getCurPosition(){
        return this.curPosition;
    }

    /**
     * Updates an attribute to a new value
     * @param attribute Attribute signature
     * @param newValue New value
     */
    public void updateAttribute(int attribute, int newValue) throws InvalidAttributeException
    {
        switch (attribute)
        {
            case 1:
                this.setVelocity(newValue);
                this.calcOverall();
                break;

            case 2:
                this.setEndurance(newValue);
                this.calcOverall();
                break;

            case 3:
                this.setSkill(newValue);
                this.calcOverall();
                break;

            case 4:
                this.setImpulsion(newValue);
                this.calcOverall();
                break;

            case 5:
                this.setHeading(newValue);
                this.calcOverall();
                break;

            case 6:
                this.setFinishing(newValue);
                this.calcOverall();
                break;

            case 7:
                this.setPassing(newValue);
                this.calcOverall();
                break;

            case 8:
                this.setCrossing(newValue);
                this.calcOverall();
                break;

            case 9:
                this.setBallRecovery(newValue);
                this.calcOverall();
                break;

            case 10:
                this.setPositioning(newValue);
                this.calcOverall();
                break;

            case 11:
                this.setCreativity(newValue);
                this.calcOverall();
                break;

            case 12:
                this.setAggressiveness(newValue);
                this.calcOverall();
                break;

            case 13:
                this.setTackling(newValue);
                this.calcOverall();
                break;

            case 14:
                this.setVision(newValue);
                this.calcOverall();
                break;

            default:
                throw new InvalidAttributeException("The attribute your inserted doesn't exist.");
        }
    }

    /**
     * Method to get Midfielder as String
     * @return Midfielder as String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Midfielder\n");
        return sb.toString();
    }
}
