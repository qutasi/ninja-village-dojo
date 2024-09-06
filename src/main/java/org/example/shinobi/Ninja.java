package org.example.shinobi;

import org.example.mission.Mission;
import org.example.mission.MissionStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ninja {

    private final int age;
    private final String codeName;
    private NinjaRank ninjaRank;
    private final List<Mission> allAssignedMissions;
    private Mission currentMission;
    private int successfulMissionsCount;

    private LocalDate baseExamDate;
    private LocalDate mediorExamDate;
    private LocalDate seniorExamDate;

    public Ninja(int age, String codeName, NinjaRank ninjaRank, LocalDate baseExamDate) {
        this.age = age;
        this.codeName = codeName;
        this.ninjaRank = ninjaRank;
        this.allAssignedMissions = new ArrayList<>();
        this.currentMission = null;
        this.successfulMissionsCount = 0;
    }

    public void getPromoted(LocalDate examDate) {
        if (this.ninjaRank.equals(NinjaRank.JUNIOR_NINJA)) {
            this.ninjaRank = NinjaRank.MEDIOR_NINJA;
            this.mediorExamDate = examDate;
        } else {
            this.ninjaRank = NinjaRank.SENIOR_NINJA;
            this.seniorExamDate = examDate;
        }
    }

    public boolean canHandleMission(Mission mission) {
        return ninjaRank.canHandleMission(mission);
    }

    //assign to mission
    public void assignedMission(Mission mission) {
        if (currentMission == null) {
            currentMission = mission;
        } else {
            throw new IllegalStateException("ninja cannot have more then one mission");
        }
    }

    //complete mission and remove? eh
    public void completeMission(boolean success) {
        if (currentMission != null) {
            this.currentMission.endMission(success);
            allAssignedMissions.add(currentMission);
            currentMission = null;
            if (success) {
                successfulMissionsCount++;
            }
        } else {
            throw new IllegalStateException("Ninja can only handle one mission at a time");
        }
    }

    public int getSuccessfulMissionsCount() {
        return successfulMissionsCount;
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

    public List<Mission> getAllAssignedMissions() {
        return allAssignedMissions;
    }
}
