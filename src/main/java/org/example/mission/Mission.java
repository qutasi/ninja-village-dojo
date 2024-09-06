package org.example.mission;

import org.example.shinobi.Ninja;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final String codeName;
    private final String description;
    private MissionRank missionRank;
    private int numOfNinjaRequired;
    private MissionStatus missionStatus;
    private List<Ninja> assignedNinjas;

    public Mission(String codeName, String description, MissionRank missionRank, int numOfNinjaRequired) {
        this.codeName = codeName;
        this.description = description;
        this.missionRank = missionRank;
        this.numOfNinjaRequired = numOfNinjaRequired;
        this.assignedNinjas = new ArrayList<>();
        this.missionStatus = missionStatus; //default
    }

    public boolean assignNinjaToMission(Ninja ninja) {
        if (ninja.canHandleMission(this) && assignedNinjas.size() < numOfNinjaRequired) {
            assignedNinjas.add(ninja);
            ninja.assignedMission(this);
            return true;
        }
        return false;
    }

    public boolean canMissionStarted() {
        if (assignedNinjas.size() < numOfNinjaRequired) {
            return false;
        }
        for (Ninja ninja : assignedNinjas) {    // Check if all assigned ninjas can handle the mission's rank
            if (!ninja.canHandleMission(this)) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeStarted() {
        return assignedNinjas.size() >= numOfNinjaRequired &&
                assignedNinjas.stream().allMatch(ninja -> ninja.canHandleMission(this));
    }

    public void startMission() {
        if (canMissionStarted()) {
            this.missionStatus = MissionStatus.IN_PROGRESS;
        }
    }

    public void endMission(boolean success) {
        this.missionStatus = success ? MissionStatus.DONE_SUCCESSFUL : MissionStatus.DONE_FAILED;
    }



    public String getCodeName() {
        return codeName;
    }

    public String getDescription() {
        return description;
    }

    public MissionRank getMissionRank() {
        return missionRank;
    }

    public int getNumOfNinjaRequired() {
        return numOfNinjaRequired;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }

    public List<Ninja> getAssignedNinjas() {
        return assignedNinjas;
    }
}
