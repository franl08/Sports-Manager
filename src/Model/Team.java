package Model;
import java.util.HashSet;
import java.util.Set;

public class Team {
    private int id;
    private String name;
    private Set<GK> gks;
    private Set<WB> wbs;
    private Set<DF> dfs;
    private Set<MD> mds;
    private Set<WA> was;
    private Set<AT> ats;
    private int overall;

    public Team(String name, Set<GK> gks, Set<WB> wbs, Set<DF> dfs, Set<MD> mds, Set<WA> was, Set<AT> ats) {
        this.setId();
        this.name = name;
        this.setGks(gks);
        this.setWbs(wbs);
        this.setDfs(dfs);
        this.setMds(mds);
        this.setWas(was);
        this.setAts(ats);
    }

    public Team (Team t){
        this.id = t.getId();
        this.name = t.getName();
        this.gks = t.getGks();
        this.wbs = t.getWbs();
        this.dfs = t.getDfs();
        this.mds = t.getMds();
        this.ats = t.getAts();
        this.overall = t.getOverall();
    }

    public Team clone(){
        return new Team(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = hashCode();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GK> getGks() {
        return this.gks;
    }

    public void setGks(Set<GK> gks) {
        this.gks = new HashSet<>();
        for (GK p : gks) this.gks.add(p.clone());
    }

    public Set<WB> getWbs() {
        return this.wbs;
    }

    public void setWbs(Set<WB> wbs) {
        this.wbs = new HashSet<>();
        for (WB p : wbs) this.wbs.add(p.clone());
    }

    public Set<DF> getDfs() {
        return this.dfs;
    }

    public void setDfs(Set<DF> dfs) {
        this.dfs = new HashSet<>();
        for (DF p : dfs) this.dfs.add(p.clone());
    }

    public Set<MD> getMds() {
        return this.mds;
    }

    public void setMds(Set<MD> mds) {
        this.mds = new HashSet<>();
        for (MD p : mds) this.mds.add(p.clone());
    }

    public Set<WA> getWas() {
        return this.was;
    }

    public void setWas(Set<WA> was) {
        this.was = new HashSet<>();
        for (WA p : was) this.was.add(p.clone());
    }

    public Set<AT> getAts() {
        return this.ats;
    }

    public void setAts(Set<AT> ats) {
        this.ats = new HashSet<>();
        for (AT p : ats) this.ats.add(p.clone());
    }

    public int getOverall() {
        return this.overall;
    }

    public void setOverall(){
        int acOv = 0;
        int teamSize = this.gks.size() + this.wbs.size() + this.dfs.size() + this.mds.size() + this.was.size() + this.ats.size();
        for (GK p : this.gks) acOv += p.getOverall();
        for (WB p : this.wbs) acOv += p.getOverall();
        for (DF p : this.dfs) acOv += p.getOverall();
        for (MD p : this.mds) acOv += p.getOverall();
        for (WA p : this.was) acOv += p.getOverall();
        for (AT p : this.ats) acOv += p.getOverall();
        this.overall = acOv / teamSize;
    }
}
