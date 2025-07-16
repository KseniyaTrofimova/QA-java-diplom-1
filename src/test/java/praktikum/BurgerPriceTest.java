package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceTest extends BurgerBaseTest {
    private final float bunPrice;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;

    public BurgerPriceTest(float bunPrice, List<Ingredient> ingredients, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        super.startUp();
        when(mockBun.getPrice()).thenReturn(bunPrice);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {5.0f, Collections.emptyList(), 10.0f},
                {3.5f, List.of(createMockIngredient(2.0f)), 9.0f},
                {4.0f, Arrays.asList(
                        createMockIngredient(1.5f),
                        createMockIngredient(2.5f),
                        createMockIngredient(3.0f)
                ), 15.0f}
        });
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        ingredients.forEach(burger::addIngredient);
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void testGetPriceWithoutBunThrowsException() {
        burger.getPrice();
    }

    @Test
    public void testGetPriceWithZeroBunPrice() {
        when(mockBun.getPrice()).thenReturn(0.0f);
        burger.setBuns(mockBun);
        assertEquals(0.0f, burger.getPrice(), 0.001);
    }
}
