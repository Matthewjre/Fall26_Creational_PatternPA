package edu.example.eventdesk.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventPlanBuilderTest {
    @Test
    void titleIsEnoughToBuildWithDefaults() {
        EventPlan plan = new EventPlanBuilder("Meet and greet").build();

        assertEquals(new EventPlan("Meet and greet", "TBD", 20, false, false), plan);
    }

    @Test
    void plansKeepTheirOwnChoices() {
        EventPlan first = new EventPlanBuilder("Welcome session")
                .room("Union 210")
                .seats(40)
                .withProjector()
                .build();
        EventPlan second = new EventPlanBuilder("Volunteer lunch")
                .withRefreshments()
                .build();

        assertEquals(new EventPlan("Welcome session", "Union 210", 40, true, false), first);
        assertEquals(new EventPlan("Volunteer lunch", "TBD", 20, false, true), second);
    }
}
