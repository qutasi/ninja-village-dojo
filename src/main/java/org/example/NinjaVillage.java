package org.example;

import org.example.mission.Mission;
import org.example.mission.MissionRank;
import org.example.mission.MissionStatus;
import org.example.shinobi.Ninja;
import org.example.shinobi.NinjaRank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NinjaVillage {

    private List<Ninja> ninjas;
    private List<Mission> missions;

    public NinjaVillage() {
        this.ninjas = new ArrayList<Ninja>();
        this.missions = new ArrayList<Mission>();
    }

    public void promoteNinja(Ninja ninja, LocalDate examDate) {
        ninja.getPromoted(examDate);
    }

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

    public Ninja getMostSuccessfulNinjaEver() {
        return ninjas.stream().max(Comparator.comparingInt(Ninja::getSuccessfulMissionsCount)).orElse(null);
    }

}
