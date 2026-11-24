package edu.example.eventdesk.abstractfactory;

import java.util.List;

public final class KitModels {
    private KitModels() {
    }

    public interface Schedule {
        String checkInInstructions();
    }

    public interface SupplyList {
        List<String> items();
    }

    public static final class CampusSchedule implements Schedule {
        @Override
        public String checkInInstructions() {
            return "Check in at the classroom";
        }
    }

    public static final class CampusSupplies implements SupplyList {
        @Override
        public List<String> items() {
            return List.of("Notebook", "Pen");
        }
    }

    public static final class OnlineSchedule implements Schedule {
        @Override
        public String checkInInstructions() {
            return "Join the video call";
        }
    }

    public static final class OnlineSupplies implements SupplyList {
        @Override
        public List<String> items() {
            return List.of("Headset", "Worksheet");
        }
    }

    public record Kit(Schedule schedule, SupplyList supplies) {
    }
}
