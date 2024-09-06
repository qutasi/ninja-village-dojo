package org.example;

import org.example.mission.Mission;
import org.example.mission.MissionRank;
import org.example.mission.MissionStatus;
import org.example.shinobi.Ninja;
import org.example.shinobi.NinjaRank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NinjaVillage {

    private List<Ninja> ninjas;
    private List<Mission> missions;

    public NinjaVillage() {
        this.ninjas = new ArrayList<Ninja>();
        this.missions = new ArrayList<Mission>();
    }

    public void addNinja(Ninja ninja) {
        this.ninjas.add(ninja);
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    public boolean promoteNinja(Ninja ninja, LocalDate examDate) {}

    // Get the number of missions of a given rank currently in progress
    public int getMissionsInProgress(MissionRank missionRank) {
        int missionCount = 0;
        for (Mission mission : missions) {
            if (mission.getMissionRank() == missionRank && mission.getMissionStatus() == MissionStatus.IN_PROGRESS) {
                missionCount++;
            }
        }
        return missionCount;
    }




    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
