package main;
public class Bill {
  private static final int MIN_QUANTITY = 1;
  private static final int MAX_QUANTITY = 50;
  private static final double MIN_PRICE = 1;
  private static final double MAX_PRICE = 100;

  private int quantity;
  private double priceOfItem;

  public Bill(int quantity, double priceOfItem) {
    if (!isValidQuantity(quantity, priceOfItem)) {
      throw new IllegalArgumentException("Invalid quantity");
    }
    this.quantity = quantity;
    this.priceOfItem = priceOfItem;
  }

  public double getTotalPrice() {
    double originalPrice = quantity * priceOfItem;
    originalPrice = applyDiscounts(originalPrice);
    return originalPrice;
  }

  private double applyDiscounts(double originalPrice) {
    double discountedPrice = applyQuantityDiscount(originalPrice);
    discountedPrice = applyItemPriceDiscount(discountedPrice);
    return discountedPrice;
  }

  private double applyQuantityDiscount(double originalPrice) {
    if (quantity >= 5) {
      return originalPrice * 0.9;
    }
    return originalPrice;
  }

  private double applyItemPriceDiscount(double originalPrice) {
    if (priceOfItem > 50) {
      return originalPrice * 0.95;
    }
    return originalPrice;
  }

  private boolean isValidQuantity(int quantity, double priceOfItem) {
    return quantity >= MIN_QUANTITY
        && quantity <= MAX_QUANTITY
        && priceOfItem >= MIN_PRICE
        && priceOfItem <= MAX_PRICE;
  }
}