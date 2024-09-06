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
             return true;
        }
    };

    public abstract boolean canHandleMission(Mission mission);
}
