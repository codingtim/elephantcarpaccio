import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {

        double unitPrice = readDouble(0, Integer.MAX_VALUE, scanner);
        Order order = new Order(1, unitPrice);

        System.out.println("#\t$\tstate\tdiscount\ttax\tprice");
        System.out.println("1\t" + order.getUnitPrice() +"\t-\t-\t-\t" + order.total());
    }

    private double readDouble(int minValue, int maxValue, Scanner scanner) {
        String line = scanner.nextLine();
        try {
            double number = Double.parseDouble(line);
            if(number < minValue || number > maxValue) {
                System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
                return readDouble(minValue, maxValue, scanner);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
            return readDouble(minValue, maxValue, scanner);
        }
    }
}
