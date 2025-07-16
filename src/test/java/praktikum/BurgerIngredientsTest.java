package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BurgerIngredientsTest extends BurgerBaseTest {

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockSourCream);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockSourCream);
        burger.addIngredient(mockChiliSauce);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientInvalidIndex() {
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredientFirstToSecondPosition() {
        burger.addIngredient(mockSourCream);
        burger.addIngredient(mockChiliSauce);
        burger.moveIngredient(0, 1);
        assertEquals(mockSourCream, burger.ingredients.get(1));
    }

    @Test
    public void testMoveIngredientSecondToFirstPosition() {
        burger.addIngredient(mockSourCream);
        burger.addIngredient(mockChiliSauce);
        burger.moveIngredient(0, 1);
        assertEquals(mockChiliSauce, burger.ingredients.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientInvalidIndex() {
        burger.moveIngredient(0, 1);
    }
}
