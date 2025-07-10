package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BurgerBunTest extends BurgerBaseTest {
    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertNotNull(burger.bun);
        assertEquals("white bun", burger.bun.getName());
    }
}
