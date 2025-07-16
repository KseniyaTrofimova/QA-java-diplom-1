package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BurgerBunTest extends BurgerBaseTest {
    private static final String EXPECTED_BUN_NAME = "white bun";

    @Test
    public void shouldSetBunReference() {
        burger.setBuns(mockBun);
        assertNotNull(burger.bun);
    }

    @Test
    public void shouldSetCorrectBunName() {
        burger.setBuns(mockBun);
        assertEquals(EXPECTED_BUN_NAME, burger.bun.getName());
    }
}

