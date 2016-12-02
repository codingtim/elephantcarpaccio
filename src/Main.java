import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {

        int amount = readInt("Amount", 0, Integer.MAX_VALUE, scanner);
        double unitPrice = readDouble("Unit price", 0, Integer.MAX_VALUE, scanner);
        LivingState livingState = readEnum("State", scanner);
        Order order = new Order(amount, unitPrice, livingState.getTaxRate());

        System.out.println("#\t$\tstate\tdiscount\ttax\ttotal\ttotalWithTax");
        System.out.println(order.getAmount()+"\t" + order.getUnitPrice() +"\t"+ livingState
                +"\t-\t" + livingState.getTaxRate() + "\t" + order.total() +"\t" + order.totalWithTax());
    }

    private LivingState readEnum(String field, Scanner scanner) {
        System.out.println("Enter your " + field);
        String line = scanner.nextLine();
        try {
            LivingState livingState = LivingState.valueOf(line);
            return livingState;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid state given, valid values: " + LivingState.printValues());
            return readEnum(field, scanner);
        }
    }

    private int readInt(String field, int minValue, int maxValue, Scanner scanner) {
        System.out.println("Enter the " + field);
        String line = scanner.nextLine();
        try {
            int number = Integer.parseInt(line);
            if(number < minValue || number > maxValue) {
                System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
                return readInt("Unit price", minValue, maxValue, scanner);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
            return readInt("Unit price", minValue, maxValue, scanner);
        }

    }

    private double readDouble(String field, int minValue, int maxValue, Scanner scanner) {
        System.out.println("Enter the " + field);
        String line = scanner.nextLine();
        try {
            double number = Double.parseDouble(line);
            if(number < minValue || number > maxValue) {
                System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
                return readDouble("Unit price", minValue, maxValue, scanner);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
            return readDouble("Unit price", minValue, maxValue, scanner);
        }
    }
}
