package edu.example.eventdesk.factorymethod;

import edu.example.eventdesk.factorymethod.PassModels.DayPass;
import edu.example.eventdesk.factorymethod.PassModels.Pass;
import edu.example.eventdesk.factorymethod.PassModels.WeekendPass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PassFactoryTest {
    @Test
    void bothFactoriesUseOneAbstractMakePassOperation() throws ReflectiveOperationException {
        Class<?> contract = factoryContract();
        Method makePass = contract.getMethod("makePass", String.class);
        assertEquals(Pass.class, makePass.getReturnType());
        assertTrue(Modifier.isAbstract(makePass.getModifiers()));
        long abstractOperations = Arrays.stream(contract.getDeclaredMethods())
                .filter(method -> Modifier.isAbstract(method.getModifiers()))
                .count();
        assertEquals(1, abstractOperations, "The contract should define one abstract creation operation");

        checkFactory(makePass, "DayPassFactory", DayPass.class, "Morgan");
        checkFactory(makePass, "WeekendPassFactory", WeekendPass.class, "Sam");
    }

    @Test
    void passDeskStillIssuesBothPasses() {
        PassDesk desk = new PassDesk();

        assertEquals(new DayPass("Leslie"), desk.issuePass("Leslie", false));
        assertEquals(new WeekendPass("Pat"), desk.issuePass("Pat", true));
    }

    private Class<?> factoryContract() {
        String packageName = getClass().getPackageName();
        // Accept either version of the contract and let the starter tests compile before it exists.
        try {
            Class<?> contract = Class.forName(packageName + ".IFactory");
            assertTrue(contract.isInterface(), "IFactory should be an interface");
            return contract;
        } catch (ClassNotFoundException noInterface) {
            Class<?> contract = assertDoesNotThrow(() -> Class.forName(packageName + ".AbsFactory"),
                    "Create IFactory or AbsFactory in the factorymethod package");
            assertTrue(!contract.isInterface() && Modifier.isAbstract(contract.getModifiers()),
                    "AbsFactory should be an abstract class");
            return contract;
        }
    }

    private void checkFactory(Method makePass, String name, Class<? extends Pass> product, String attendee)
            throws ReflectiveOperationException {
        Class<?> factoryType = assertDoesNotThrow(() -> Class.forName(getClass().getPackageName() + "." + name),
                "Create " + name);
        assertTrue(makePass.getDeclaringClass().isAssignableFrom(factoryType),
                name + " should use the shared factory contract");
        Object factory = factoryType.getConstructor().newInstance();
        Pass pass = assertInstanceOf(product, makePass.invoke(factory, attendee));
        assertEquals(attendee, pass.attendee());
    }
}
