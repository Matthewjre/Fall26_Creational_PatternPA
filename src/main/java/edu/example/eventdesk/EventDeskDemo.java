package edu.example.eventdesk;

import edu.example.eventdesk.abstractfactory.KitModels.Kit;
import edu.example.eventdesk.abstractfactory.WorkshopDesk;
import edu.example.eventdesk.builder.EventPlan;
import edu.example.eventdesk.factorymethod.PassDesk;
import edu.example.eventdesk.factorymethod.PassModels.Pass;

public class EventDeskDemo {
    public static void main(String[] args) {
        PassDesk passDesk = new PassDesk();
        Pass dayPass = passDesk.issuePass("Avery", false);
        Pass weekendPass = passDesk.issuePass("Jordan", true);
        System.out.printf("Pass for %s | %d day(s)%n", dayPass.attendee(), dayPass.validDays());
        System.out.printf("Pass for %s | %d day(s)%n", weekendPass.attendee(), weekendPass.validDays());

        WorkshopDesk workshopDesk = new WorkshopDesk();
        Kit onlineKit = workshopDesk.prepareKit(true);
        System.out.println("Online workshop | " + onlineKit.schedule().checkInInstructions());
        System.out.println("Supplies | " + String.join(", ", onlineKit.supplies().items()));

        // TODO: Configure the same plan using the builder once it is ready.
        EventPlan plan = new EventPlan("Welcome session", "Union 210", 40, true, false);
        System.out.printf("%s | %s | %d seats%n", plan.title(), plan.room(), plan.seats());
        System.out.printf("Projector: %s | Refreshments: %s%n", plan.projector(), plan.refreshments());
    }
}
