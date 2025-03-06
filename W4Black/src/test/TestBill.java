package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import main.Bill;

public class TestBill {

    @Nested
    class TestNoQuantityDiscountAndNoPriceDiscount {
        @Test
        public void testMinQuantityMinPrice() {
            Bill bill = new Bill(1, 1);
            assertEquals(1, bill.getTotalPrice());
        }

        @Test
        public void testNomQuantityNomPrice() {
            Bill bill = new Bill(25, 50);
            assertEquals(50*25*0,90, bill.getTotalPrice());
        }

        @Test
        public void testMaxQuantityMaxPrice() {
            Bill bill = new Bill(50, 100);
            assertEquals(100*50*0,85, bill.getTotalPrice());
        }

        @Test
        public void testMaxMinusQuantityNomPrice() {
            Bill bill = new Bill(49, 50);
            assertEquals(50*49*0,9, bill.getTotalPrice());
        }

        @Test
        public void testNomQuantityMaxMinusPrice() {
            Bill bill = new Bill(25, 99);
            assertEquals(99*25*0,855, bill.getTotalPrice());
        }
    }

    
    @Nested
    class TestInvalidInput {
        @Test
        public void testNegativeQuantity() {
            try {
                new Bill(-1, 50);
                fail("Expected IllegalArgumentException for negative quantity");
            } catch (IllegalArgumentException e) {
                assertEquals("Invalid quantity", e.getMessage());
            }
        }


        @Test
        public void testZeroQuantity() {
            try {
                new Bill(0, 50);
                fail("Expected IllegalArgumentException for zero quantity");
            } catch (IllegalArgumentException e) {
                assertEquals("Invalid quantity", e.getMessage());
            }
        }
    }
}
