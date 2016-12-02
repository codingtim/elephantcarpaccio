public class Order {
    private final int amount;
    private final double unitPrice;

    public Order(int amount, double unitPrice) {
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public double total() {
        return unitPrice * amount;
    }

    public int getAmount() {
        return amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
