package praktikum;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public abstract class BurgerBaseTest {
    protected Burger burger;
    private AutoCloseable mockCloseable;

    @Mock protected Bun mockBun;
    @Mock protected Ingredient mockSourCream;
    @Mock protected Ingredient mockChiliSauce;
    @Mock protected Ingredient mockCutlet;

    @Before
    public void startUp() {
        mockCloseable = MockitoAnnotations.openMocks(this);

        burger = new Burger();

        when(mockBun.getName()).thenReturn("white bun");
        when(mockSourCream.getName()).thenReturn("sour cream");
        when(mockSourCream.getType()).thenReturn(IngredientType.SAUCE);
        when(mockChiliSauce.getName()).thenReturn("chili sauce");
        when(mockChiliSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockCutlet.getName()).thenReturn("cutlet");
        when(mockCutlet.getType()).thenReturn(IngredientType.FILLING);
    }

    protected static Ingredient createMockIngredient(float price) {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        when(ingredient.getPrice()).thenReturn(price);
        when(ingredient.getName()).thenReturn("test");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        return ingredient;
    }

    @After
    public void tearDown() throws Exception {
        if (mockCloseable != null) {
            mockCloseable.close();
        }
    }
}
