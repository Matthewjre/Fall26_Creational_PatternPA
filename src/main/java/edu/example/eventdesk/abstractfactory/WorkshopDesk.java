package edu.example.eventdesk.abstractfactory;

import edu.example.eventdesk.abstractfactory.KitModels.CampusSchedule;
import edu.example.eventdesk.abstractfactory.KitModels.CampusSupplies;
import edu.example.eventdesk.abstractfactory.KitModels.Kit;
import edu.example.eventdesk.abstractfactory.KitModels.OnlineSchedule;
import edu.example.eventdesk.abstractfactory.KitModels.OnlineSupplies;

public class WorkshopDesk {
    public Kit prepareKit(boolean online) {
        // TODO: Get both parts of the kit from a single family factory.
        if (online) {
            return new Kit(new OnlineSchedule(), new OnlineSupplies());
        }
        return new Kit(new CampusSchedule(), new CampusSupplies());
    }
}
