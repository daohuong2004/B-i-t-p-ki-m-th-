package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.Bill;

public class TestBill2 {

    @Nested
    class InvalidQuantity {
        @Test
        public void testZeroQuantityZeroPrice() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Bill(0, 0);
            }, "Invalid quantity");
        }

        @Test
        public void testZeroQuantityLowPrice() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Bill(0, 25);
            }, "Invalid quantity");
        }

        @Test
        public void testZeroQuantityHighPrice() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Bill(0, 75);
            }, "Invalid quantity");
        }

    }

    @Nested
    class NoDiscountQuantity {
        @Test
        public void testLowQuantityLowPrice() {
            Bill bill = new Bill(3, 25);
            assertEquals(3 * 25, bill.getTotalPrice());
        }

        @Test
        public void testLowQuantityHighPrice() {
            Bill bill = new Bill(3, 75);
            assertEquals(3 * 75 * 0.95, bill.getTotalPrice());
        }
    }

    @Nested
    class DiscountQuantity {
        @Test
        public void testHighQuantityLowPrice() {
            Bill bill = new Bill(10, 25);
            assertEquals(10 * 25 * 0.9, bill.getTotalPrice());
        }

        @Test
        public void testHighQuantityHighPrice() {
            Bill bill = new Bill(10, 75);
            assertEquals(10 * 75 * 0.9 * 0.95, bill.getTotalPrice());
        }
    }
}
