package main;

public class Bill2 {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 50;
    private static final double MIN_PRICE = 1;
    private static final double MAX_PRICE = 100;

    public static double Bill(int quantity, double priceOfItem) {
        if (!(quantity >= MIN_QUANTITY && quantity <= MAX_QUANTITY) ||
                !(priceOfItem >= MIN_PRICE && priceOfItem <= MAX_PRICE)) {
            return -1; // Trả về -1 nếu invalid input
        }
        double total = quantity * priceOfItem;
        // Giảm giá 10% nếu số lượng >= 5
        if (quantity >= 5) {
            total *= 0.9;
        }

        // Giảm giá 5% nếu giá sản phẩm >=50
        if (priceOfItem >= 50) {
            total *= 0.95;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(Bill(3, 40)); // 3 * 40 = 120 (Không giảm giá)
        System.out.println(Bill(5, 40)); // 5 * 40 * 0.9 = 180
        System.out.println(Bill(3, 60)); // 3 * 60 * 0.95 = 171
        System.out.println(Bill(5, 60)); // 5 * 60 * 0.9 * 0.95 = 256.5
        System.out.println(Bill(0, 60)); // -1 (Invalid input)
    }
}
