package org.mowitnow.tondeuse.controle;

import org.junit.jupiter.api.Test;
import org.mowitnow.tondeuse.model.PlanDeTonte;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class PlansDeTonteTest {

    @Test
    public void testGetReturnsNonNullPlanDeTonte() {
        PlanDeTonte mockPlanDeTonte = mock(PlanDeTonte.class);

        PlansDeTonte testImplementation = () -> mockPlanDeTonte;

        PlanDeTonte result = testImplementation.get();

        assertNotNull(result, "The returned PlanDeTonte should not be null");
    }

}
