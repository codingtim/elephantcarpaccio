package j;

import java.util.Scanner;

public class Reader {

    private Scanner scanner;

    public Reader(Scanner scanner) {
        this.scanner = scanner;
    }

    public LivingState readEnum(String field) {
        System.out.println("Enter your " + field);
        System.out.println("Valid values are: " + printValues());
        String line = scanner.nextLine();
        try {
            return LivingState.valueOf(line);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid value given.");
            return readEnum(field);
        }
    }

    private String printValues() {
        String v =  "";
        LivingState[] values = LivingState.values();
        for (int i = 0; i < values.length; i++) {
            LivingState livingState = values[i];
            if(i != 0) {
                v += ", " + livingState.toString();
            } else {
                v  = livingState.toString();
            }
        }
        return v;
    }

    public int readInt(String field, int minValue, int maxValue) {
        System.out.println("Enter the " + field);
        String line = scanner.nextLine();
        try {
            int number = Integer.parseInt(line);
            if(number < minValue || number > maxValue) {
                System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
                return readInt(field, minValue, maxValue);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
            return readInt(field, minValue, maxValue);
        }

    }

    public double readDouble(String field, int minValue, int maxValue) {
        System.out.println("Enter the " + field);
        String line = scanner.nextLine();
        try {
            double number = Double.parseDouble(line);
            if(number < minValue || number > maxValue) {
                System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
                return readDouble(field, minValue, maxValue);
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, expected number >= " + minValue + " and <= " + maxValue);
            return readDouble(field, minValue, maxValue);
        }
    }
}
