package edu.example.eventdesk.factorymethod;

public final class PassModels {
    private PassModels() {
    }

    public interface Pass {
        String attendee();
        int validDays();
    }

    public record DayPass(String attendee) implements Pass {
        @Override
        public int validDays() {
            return 1;
        }
    }

    public record WeekendPass(String attendee) implements Pass {
        @Override
        public int validDays() {
            return 2;
        }
    }
}
