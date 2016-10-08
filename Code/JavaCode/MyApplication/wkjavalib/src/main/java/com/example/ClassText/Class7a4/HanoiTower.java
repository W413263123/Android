package com.example.ClassText.Class7a4;

/**
 * Created by wenkui on 16/9/12.
 */
public class HanoiTower {
    private String name;
    private static HanoiTower tower = null;
    private HanoiTower() {

    }

    public static HanoiTower getInstance() {
        if (tower == null) {
            tower = new HanoiTower();
            tower.name = "HanoiTower";
        }
        return tower;
    }

    public String getName() {
        return name;
    }
}
