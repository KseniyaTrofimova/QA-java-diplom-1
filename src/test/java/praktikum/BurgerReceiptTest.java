package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerReceiptTest extends BurgerBaseTest {

    @Before
    public void setUp() {
        when(mockBun.getName()).thenReturn("white bun");
        when(mockSourCream.getName()).thenReturn("sour cream");
        when(mockSourCream.getType()).thenReturn(IngredientType.SAUCE);
        when(mockCutlet.getName()).thenReturn("cutlet");
        when(mockCutlet.getType()).thenReturn(IngredientType.FILLING);
    }

    private String buildExpectedReceipt(String bunName, String[] ingredients, float price) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("(==== %s ====)%n", bunName));

        for (String ingredient : ingredients) {
            sb.append(ingredient).append(String.format("%n"));
        }

        sb.append(String.format("(==== %s ====)%n", bunName));
        sb.append(String.format("%nPrice: %f%n", price));
        return sb.toString();
    }

    @Test
    public void testGetReceiptOnlyBun() {
        burger.setBuns(mockBun);

        String expected = buildExpectedReceipt("white bun", new String[]{}, 0.0f);
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void testGetReceiptWithOneSauce() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSourCream);

        String expected = buildExpectedReceipt("white bun",
                new String[]{"= sauce sour cream ="}, 0.0f);
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void testGetReceiptWithOneFilling() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockCutlet);

        String expected = buildExpectedReceipt("white bun",
                new String[]{"= filling cutlet ="}, 0.0f);
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void testGetReceiptWithMultipleIngredients() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSourCream);
        burger.addIngredient(mockCutlet);

        String expected = buildExpectedReceipt("white bun",
                new String[]{"= sauce sour cream =", "= filling cutlet ="}, 0.0f);
        assertEquals(expected, burger.getReceipt());
    }

    @Test
    public void testReceiptPriceFormat() {
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockSourCream.getPrice()).thenReturn(50.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSourCream);

        String expected = buildExpectedReceipt("white bun",
                new String[]{"= sauce sour cream ="}, 250.0f);
        assertEquals(expected, burger.getReceipt());
    }

    @Test(expected = NullPointerException.class)
    public void testGetReceiptWithoutBun() {
        new Burger().getReceipt();
    }
}