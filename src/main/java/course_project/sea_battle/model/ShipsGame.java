package course_project.sea_battle.model;

import course_project.sea_battle.model.Ships;

import java.util.ArrayList;
import java.util.List;

public class ShipsGame {

    List<Ships> ones = new ArrayList<>();
    List<Ships> twos = new ArrayList<>();
    List<Ships> trees = new ArrayList<>();
    List<Ships> fours = new ArrayList<>();

    public ShipsGame() {
    }

    public List<Ships> getOnes() {
        return ones;
    }

    public void setOnes(List<Ships> ones) {
        this.ones = ones;
    }

    public List<Ships> getTwos() {
        return twos;
    }

    public void setTwos(List<Ships> twos) {
        this.twos = twos;
    }

    public List<Ships> getTrees() {
        return trees;
    }

    public void setTrees(List<Ships> trees) {
        this.trees = trees;
    }

    public List<Ships> getFours() {
        return fours;
    }

    public void setFours(List<Ships> fours) {
        this.fours = fours;
    }
}
