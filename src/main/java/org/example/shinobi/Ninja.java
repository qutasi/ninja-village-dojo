package org.example.shinobi;

import org.example.mission.Mission;

import java.util.ArrayList;
import java.util.List;

public class Ninja {

    private final int age;
    private final String codeName;
    private final NinjaRank ninjaRank;
    private List<Mission> missions;


    public Ninja(int age, String codeName, NinjaRank ninjaRank) {
        this.age = age;
        this.codeName = codeName;
        this.ninjaRank = ninjaRank;
        this.missions = new ArrayList<>();
    }

    public boolean canHandleMission(Mission mission) {
        return ninjaRank.canHandleMission(mission);
    }

    //List all the ninja's mission
    public List<Mission> listMissions() {
        List<Mission> allMissions = new ArrayList<>();
        for (Mission mission : missions) {
            allMissions.add(mission);
        }
        return allMissions;
    }

    //get exam date
    public String getExamDates() {
        return ninjaRank.getExamDates();
    }

    //assign to mission
    public void assignedMission(Mission mission) {
        if (missions.isEmpty()) {
            missions.add(mission);
        } else {
            throw new IllegalStateException("Ninja can only handle 1 mission at a time");
        }
    }

    //complete mission and remove? eh
    public void completeMission(Mission mission, boolean success) {
        if (!missions.contains(mission)) {
            missions.remove(mission);
        } else {
            throw new IllegalStateException("Ninja can only handle one mission at a time");
        }
    }


    public int getAge() {
        return age;
    }

    public String getCodeName() {
        return codeName;
    }

    public NinjaRank getNinjaRank() {
        return ninjaRank;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
