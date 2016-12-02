import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {

        int unitPrice = readNumber(1, Integer.MAX_VALUE, scanner);


        System.out.println("#\t$\tstate\tdiscount\ttax\tprice");
        System.out.println("1\t" + unitPrice +"\t-\t-\t-\t100");
    }

    private int readNumber(int minValue, int maxValue, Scanner scanner) {
        String line = scanner.nextLine();
        try {
            int number = Integer.parseInt(line);
            if(number < minValue || number > maxValue) {
                System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
                return readNumber(minValue, maxValue, scanner);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
            return readNumber(minValue, maxValue, scanner);
        }
    }
}
