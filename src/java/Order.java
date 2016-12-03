package java;

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
        double totalWithoutTax = unitPrice * amount;
        if(totalWithoutTax >= 50000) return totalWithoutTax * 0.85;
        if(totalWithoutTax >= 10000) return totalWithoutTax * 0.90;
        if(totalWithoutTax >= 7000) return totalWithoutTax * 0.93;
        if(totalWithoutTax >= 5000) return totalWithoutTax * 0.95;
        if(totalWithoutTax >= 1000) return totalWithoutTax * 0.97;
        return totalWithoutTax;
    }


    public double discount() {
        return (amount * unitPrice) - total();
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
