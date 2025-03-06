package test;

import org.junit.jupiter.api.Test;

import main.Bill2;

import static org.junit.jupiter.api.Assertions.*;

public class BillTest {
    @Test
    public void testCase1_InvalidInput() {
        double result = Bill2.Bill(0, 101);
        assertEquals(-1, result, "Invalid Input");
    }

    @Test
    public void testCase2_QuantityDiscount() {
        double result = Bill2.Bill(6, 10);
        assertEquals(54, result, 0.01, "Quantity Discount 10%");
    }

    @Test
    public void testCase3_NoDiscount() {
        double result = Bill2.Bill(4, 50);
        assertEquals(190, result, 0.01, "No Discount");
    }

    @Test
    public void testCase4_NoDiscount() {
        double result = Bill2.Bill(2, 20);
        assertEquals(40, result, 0.01, "No Discount");
    }
}
