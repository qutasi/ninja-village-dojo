package org.example.shinobi;

import org.example.mission.Mission;
import org.example.mission.MissionRank;

import java.time.LocalDate;

public enum NinjaRank {

    JUNIOR_NINJA {
        @Override
        public boolean canHandleMission(Mission mission) {
            return mission.getMissionRank() == MissionRank.C;
        }
    },

    MEDIOR_NINJA {
        @Override
        public boolean canHandleMission(Mission mission) {
            return mission.getMissionRank() == MissionRank.C || mission.getMissionRank() == MissionRank.B;
        }
    },

    SENIOR_NINJA {
        @Override
        public boolean canHandleMission(Mission mission) {
            return mission.getMissionRank() == MissionRank.C || mission.getMissionRank() == MissionRank.B || mission.getMissionRank() == MissionRank.A;
        }
    };
/*
    //fields for store exams
    private final LocalDate baseNinjaExamDate;
    private final LocalDate mediorNinjaExamDate;
    private final LocalDate seniorNinjaExamDate;

    NinjaRank(LocalDate baseNinjaExamDate) {
        this.baseNinjaExamDate = baseNinjaExamDate;
        this.mediorNinjaExamDate = null;
        this.seniorNinjaExamDate = null;
    }

    NinjaRank(LocalDate baseNinjaExamDate, LocalDate mediorNinjaExamDate) {
        this.baseNinjaExamDate = baseNinjaExamDate;
        this.mediorNinjaExamDate = mediorNinjaExamDate;
        this.seniorNinjaExamDate = null;
    }

    NinjaRank(LocalDate baseNinjaExamDate, LocalDate mediorNinjaExamDate, LocalDate seniorNinjaExamDate) {
        this.baseNinjaExamDate = baseNinjaExamDate;
        this.mediorNinjaExamDate = mediorNinjaExamDate;
        this.seniorNinjaExamDate = seniorNinjaExamDate;
    }

    public abstract String getExamDates();
*/

    // Abstract method for checking if a ninja of this rank can handle a mission    ???????
    public abstract boolean canHandleMission(Mission mission);

}
