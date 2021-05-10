package Model;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private String id;
    private String name;
    private Set<GK> goalkeepers;
    private Set<DF> defenders;
    private Set<MD> midfielders;
    private Set<WG> wingers;
    private Set<FW> forwards;

    public Team(){
        this.id = "n/a";
        this.name = "n/a";
        this.goalkeepers = new HashSet<GK>();
        this.defenders = new HashSet<DF>();
        this.midfielders = new HashSet<MD>();
        this.wingers = new HashSet<WG>();
        this.forwards = new HashSet<FW>();
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
        this.goalkeepers = new HashSet<GK>();
        this.defenders = new HashSet<DF>();
        this.midfielders = new HashSet<MD>();
        this.wingers = new HashSet<WG>();
        this.forwards = new HashSet<FW>();
    }

    public Team(String id, String name, Set<GK> goalkeepers, Set<DF> defenders, Set<MD> midfielders, Set<WG> wingers, Set<FW> forwards) {
        this.id = id;
        this.name = name;
        this.setGoalkeepers(goalkeepers);
        this.setDefenders(defenders);
        this.setMidfielders(midfielders);
        this.setWingers(wingers);
        this.setForwards(forwards);
    }

    public Team(Team t){
        this.id = t.getId();
        this.name = t.getName();
        this.setGoalkeepers(t.getGoalkeepers());
        this.setDefenders(t.getDefenders());
        this.setMidfielders(t.getMidfielders());
        this.setWingers(t.getWingers());
        this.setForwards(t.getForwards());
    }

    public Team clone(){
        return new Team(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GK> getGoalkeepers() {
        Set<GK> ans = new HashSet<GK>();
        for(GK g : this.goalkeepers)
            ans.add(g.clone());
        return ans;
    }

    public void setGoalkeepers(Set<GK> goalkeepers) {
        this.goalkeepers = goalkeepers;
    }

    public Set<DF> getDefenders() {
        Set<DF> ans = new HashSet<DF>();
        for(DF d : this.defenders)
            ans.add(d.clone());
        return ans;
    }

    public void setDefenders(Set<DF> defenders) {
        this.defenders = defenders;
    }

    public Set<MD> getMidfielders() {
        Set<MD> ans = new HashSet<MD>();
        for(MD m : this.midfielders)
            ans.add(m.clone());
        return ans;
    }

    public void setMidfielders(Set<MD> midfielders) {
        this.midfielders = midfielders;
    }

    public Set<WG> getWingers() {
        Set<WG> ans = new HashSet<WG>();
        for(WG w : this.wingers)
            ans.add(w.clone());
        return ans;
    }

    public void setWingers(Set<WG> wingers) {
        this.wingers = wingers;
    }

    public Set<FW> getForwards() {
        Set<FW> ans = new HashSet<FW>();
        for(FW f : this.forwards)
            ans.add(f.clone());
        return ans;
    }

    public void setForwards(Set<FW> forwards) {
        this.forwards = forwards;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Team: ")
                .append(name).append("\n")
                .append("Goalkeepers: ").append(goalkeepers)
                .append("\n Defenders: ").append(defenders)
                .append("\n Midfielders: ").append(midfielders)
                .append("\n Forwards: ").append(forwards);
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        Team t = (Team) o;
        return (this.id.equals(t.getId()));
    }

    public void addPlayer(Player p) throws InvalidPositionException{
        if(p.getClass().toString().split(" ")[1].equals("GK")){
            GK g = (GK) p;
            this.goalkeepers.add(g.clone());
        }
        else{
            FieldPlayer fp = (FieldPlayer) p;
            switch (fp.getPosition()) {
                case DEFENDER -> {
                    DF d = (DF) p;
                    this.defenders.add(d.clone());
                }
                case WINGER -> {
                    WG w = (WG) p;
                    this.wingers.add(w.clone());
                }
                case MIDFIELDER -> {
                    MD m = (MD) p;
                    this.midfielders.add(m.clone());
                }
                case FORWARD -> {
                    FW f = (FW) p;
                    this.forwards.add(f.clone());
                }
                default -> throw new InvalidPositionException("Invalid Player Position");
            }
        }
    }
}
