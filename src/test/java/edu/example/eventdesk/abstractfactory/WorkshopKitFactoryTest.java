package edu.example.eventdesk.abstractfactory;

import edu.example.eventdesk.abstractfactory.KitModels.CampusSchedule;
import edu.example.eventdesk.abstractfactory.KitModels.CampusSupplies;
import edu.example.eventdesk.abstractfactory.KitModels.Kit;
import edu.example.eventdesk.abstractfactory.KitModels.OnlineSchedule;
import edu.example.eventdesk.abstractfactory.KitModels.OnlineSupplies;
import edu.example.eventdesk.abstractfactory.KitModels.Schedule;
import edu.example.eventdesk.abstractfactory.KitModels.SupplyList;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopKitFactoryTest {
    @Test
    void eachFactoryCreatesTwoProductsFromTheSameFamily() throws ReflectiveOperationException {
        Class<?> contract = studentClass("IWorkshopKitFactory");
        assertTrue(contract.isInterface(), "IWorkshopKitFactory should be an interface");

        Method makeSchedule = contract.getMethod("makeSchedule");
        Method makeSupplies = contract.getMethod("makeSupplyList");
        assertEquals(Schedule.class, makeSchedule.getReturnType());
        assertEquals(SupplyList.class, makeSupplies.getReturnType());
        assertTrue(Modifier.isAbstract(makeSchedule.getModifiers()));
        assertTrue(Modifier.isAbstract(makeSupplies.getModifiers()));

        Object campus = newFactory(contract, "CampusKitFactory");
        assertInstanceOf(CampusSchedule.class, makeSchedule.invoke(campus));
        assertInstanceOf(CampusSupplies.class, makeSupplies.invoke(campus));

        Object online = newFactory(contract, "OnlineKitFactory");
        assertInstanceOf(OnlineSchedule.class, makeSchedule.invoke(online));
        assertInstanceOf(OnlineSupplies.class, makeSupplies.invoke(online));
    }

    @Test
    void workshopDeskStillSuppliesMatchingKits() {
        WorkshopDesk desk = new WorkshopDesk();
        Kit campus = desk.prepareKit(false);
        assertInstanceOf(CampusSchedule.class, campus.schedule());
        assertInstanceOf(CampusSupplies.class, campus.supplies());

        Kit online = desk.prepareKit(true);
        assertInstanceOf(OnlineSchedule.class, online.schedule());
        assertInstanceOf(OnlineSupplies.class, online.supplies());
    }

    private Class<?> studentClass(String name) {
        return assertDoesNotThrow(() -> Class.forName(getClass().getPackageName() + "." + name),
                "Create " + name);
    }

    private Object newFactory(Class<?> contract, String name) throws ReflectiveOperationException {
        Class<?> factoryType = studentClass(name);
        assertTrue(contract.isAssignableFrom(factoryType), name + " should implement IWorkshopKitFactory");
        return factoryType.getConstructor().newInstance();
    }
}
