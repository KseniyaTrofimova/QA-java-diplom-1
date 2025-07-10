package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class BurgerReceiptTest extends BurgerBaseTest {
    @Test
    public void testGetReceiptWithNoIngredients() {
        burger.setBuns(mockBun);
        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("(==== white bun ===="));
        assertTrue(receipt.contains("Price:"));
    }

    @Test
    public void testGetReceiptWithIngredients() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient3);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("(==== white bun ===="));
        assertTrue(receipt.contains("= sauce sour cream ="));
        assertTrue(receipt.contains("= filling cutlet ="));
        assertTrue(receipt.contains("Price:"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetReceiptWithoutBunThrowsException() {
        burger.getReceipt();
    }

    @Test
    public void testReceiptPriceFormat() {
        burger.setBuns(mockBun);
        when(mockBun.getPrice()).thenReturn(100.0f);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getPrice()).thenReturn(50.0f);

        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Price: 250"));
    }
}