package Model;

import java.util.List;

public abstract class FieldPlayer extends Player{
    private int velocity;
    private int endurance;
    private int skill;
    private int impulsion;
    private int heading;
    private int finishing;
    private int passing;
    private int crossing;
    private int ballRecovery;
    private int positioning;
    private int creativity;
    private int aggressiveness;
    private int tackling;
    private int vision;

    /**
     * Empty Constructor
     */
    public FieldPlayer() {
        super();
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(Player p) {
        super(p);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(String name, int number, String currentTeam, List<String> historic) {
        super(name, number, currentTeam, historic, null);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(String name, int number, String currentTeam) {
        super(name, number, currentTeam, null);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(String name, int number) {
        super(name, number,null);
        this.velocity = utils.setRandomAttribute();
        this.endurance = utils.setRandomAttribute();
        this.skill = utils.setRandomAttribute();
        this.impulsion = utils.setRandomAttribute();
        this.heading = utils.setRandomAttribute();
        this.finishing = utils.setRandomAttribute();
        this.passing = utils.setRandomAttribute();
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);

    }

    public FieldPlayer(String name, int number, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, currentTeam, historic, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);
    }

    public FieldPlayer(String name, int number, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, currentTeam, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);
    }

    public FieldPlayer(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(name, number, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.setBallRecovery(ballRecovery);
        this.setPositioning(positioning);
        this.setCreativity(creativity);
        this.setAggressiveness(aggressiveness);
        this.setTackling(tackling);
        this.setVision(vision);
    }


    public FieldPlayer(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, Position position) {
        super(name, number, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.setCrossing(crossing);
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(String name, int number, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, Position position) {
        super(name, number, position);
        this.setVelocity(velocity);
        this.setEndurance(endurance);
        this.setSkill(skill);
        this.setImpulsion(impulsion);
        this.setHeading(heading);
        this.setFinishing(finishing);
        this.setPassing(passing);
        this.crossing = utils.setRandomAttribute();
        this.ballRecovery = utils.setRandomAttribute();
        this.positioning = utils.setRandomAttribute();
        this.creativity = utils.setRandomAttribute();
        this.aggressiveness = utils.setRandomAttribute();
        this.tackling = utils.setRandomAttribute();
        this.vision = utils.setRandomAttribute();
    }

    public FieldPlayer(FieldPlayer fp){
        super(fp.getName(), fp.getNumber(), fp.getCurrentTeamName(), fp.getHistoric(), fp.getCurPosition());
        this.setVelocity(fp.getVelocity());
        this.setEndurance(fp.getEndurance());
        this.setSkill(fp.getSkill());
        this.setImpulsion(fp.getImpulsion());
        this.setHeading(fp.getHeading());
        this.setFinishing(fp.getFinishing());
        this.setPassing(fp.getPassing());
        this.setCrossing(fp.getCrossing());
        this.setBallRecovery(fp.getBallRecovery());
        this.setPositioning(fp.getPositioning());
        this.setCreativity(fp.getCreativity());
        this.setAggressiveness(fp.getAggressiveness());
        this.setTackling(fp.getTackling());
        this.setVision(fp.getVision());
    }

    public abstract FieldPlayer clone();

    public abstract int calcOverall();

    public abstract Position getCurPosition();

    public int getVelocity() {
        return this.velocity;
    }

    public void setVelocity(int velocity) {
        if(velocity > 99) this.velocity = 99;
        else this.velocity = Math.max(velocity, 0);
    }

    public int getEndurance() {
        return this.endurance;
    }

    public void setEndurance(int endurance) {
        if(endurance > 99) this.endurance = 99;
        else this.endurance = Math.max(endurance, 0);
    }

    public int getSkill() {
        return this.skill;
    }

    public void setSkill(int skill) {
        if(skill > 99) this.skill = 99;
        else this.skill = Math.max(skill, 0);
    }

    public int getImpulsion() {
        return this.impulsion;
    }

    public void setImpulsion(int impulsion) {
        if(impulsion > 99) this.impulsion = 99;
        else this.impulsion = Math.max(impulsion, 0);
    }

    public int getHeading() {
        return this.heading;
    }

    public void setHeading(int heading) {
        if(heading > 99) this.heading = 99;
        else this.heading = Math.max(heading, 0);
    }

    public int getFinishing() {
        return this.finishing;
    }

    public void setFinishing(int finishing) {
        if(finishing > 99) this.finishing = 99;
        else this.finishing = Math.max(finishing, 0);
    }

    public int getPassing() {
        return this.passing;
    }

    public void setPassing(int passing) {
        if(passing > 99) this.passing = 99;
        else this.passing = Math.max(passing, 0);
    }

    public int getCrossing() {
        return this.crossing;
    }

    public void setCrossing(int crossing) {
        if(crossing > 99) this.crossing = 99;
        else this.crossing = Math.max(crossing, 0);
    }

    public int getBallRecovery() {
        return this.ballRecovery;
    }

    public void setBallRecovery(int ballRecovery) {
        if(ballRecovery > 99) this.ballRecovery = 99;
        else this.ballRecovery = Math.max(ballRecovery, 0);
    }

    public int getPositioning() {
        return this.positioning;
    }

    public void setPositioning(int positioning) {
        if(positioning > 99) this.positioning = 99;
        else this.positioning = Math.max(positioning, 0);
    }

    public int getCreativity() {
        return this.creativity;
    }

    public void setCreativity(int creativity) {
        if(creativity > 99) this.creativity = 99;
        else this.creativity = Math.max(creativity, 0);
    }

    public int getAggressiveness() {
        return this.aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        if(aggressiveness > 99) this.aggressiveness = 99;
        else this.aggressiveness = Math.max(aggressiveness, 0);
    }

    public int getTackling() {
        return this.tackling;
    }

    public void setTackling(int tackling) {
        if(tackling > 99) this.tackling = 99;
        else this.tackling = Math.max(tackling, 0);
    }

    public int getVision() {
        return this.vision;
    }

    public void setVision(int vision) {
        if(vision > 99) this.vision = 99;
        else this.vision = Math.max(vision, 0);
    }

    public String toString(){
        return super.toString();
    }
}
