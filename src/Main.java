import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {

        int amount = readInt("Amount", 0, Integer.MAX_VALUE, scanner);
        double unitPrice = readDouble("Unit price", 0, Integer.MAX_VALUE, scanner);
        Order order = new Order(amount, unitPrice);

        System.out.println("#\t$\tstate\tdiscount\ttax\tprice");
        System.out.println("1\t" + order.getUnitPrice() +"\t-\t-\t-\t" + order.total());
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
