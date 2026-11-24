package edu.example.eventdesk.factorymethod;

import edu.example.eventdesk.factorymethod.PassModels.DayPass;
import edu.example.eventdesk.factorymethod.PassModels.Pass;
import edu.example.eventdesk.factorymethod.PassModels.WeekendPass;

public class PassDesk {
    public Pass issuePass(String attendee, boolean weekend) {
        // TODO: Route pass creation through the common factory type.
        return weekend ? new WeekendPass(attendee) : new DayPass(attendee);
    }
}
