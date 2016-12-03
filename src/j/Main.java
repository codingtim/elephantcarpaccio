package j;

import java.util.Scanner;

public class Main {

    private final Reader reader = new Reader(new Scanner(System.in));

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {

        int amount = reader.readInt("Amount", 0, Integer.MAX_VALUE);
        double unitPrice = reader.readDouble("Unit price", 0, Integer.MAX_VALUE);
        LivingState livingState = reader.readEnum("State");
        Order order = new Order(amount, unitPrice, livingState.getTaxRate());

        System.out.println("#\t$\tstate\tdiscount\ttax\ttotal\ttotalWithTax");
        System.out.println(order.getAmount()+"\t" + order.getUnitPrice() +"\t"+ livingState
                +"\t" + order.discount() +"\t" + livingState.getTaxRate() + "%\t" + order.total() +"\t" + order.totalWithTax());
    }
}
