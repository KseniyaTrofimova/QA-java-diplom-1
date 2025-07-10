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
    @Mock protected Ingredient mockIngredient1;
    @Mock protected Ingredient mockIngredient2;
    @Mock protected Ingredient mockIngredient3;

    @Before
    public void startUp() {
        mockCloseable = MockitoAnnotations.openMocks(this);

        burger = new Burger();

        when(mockBun.getName()).thenReturn("white bun");
        when(mockIngredient1.getName()).thenReturn("sour cream");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getName()).thenReturn("chili sauce");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient3.getName()).thenReturn("cutlet");
        when(mockIngredient3.getType()).thenReturn(IngredientType.FILLING);
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