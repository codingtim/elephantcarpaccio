public class Order {
    private final int amount;
    private final double unitPrice;
    private double taxRate;

    public Order(int amount, double unitPrice, double taxRate) {
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.taxRate = taxRate;
    }

    public double total() {
        return unitPrice * amount;
    }

    public double totalWithTax() {
        return total() * ((100 + taxRate) / 100);
    }

    public int getAmount() {
        return amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}