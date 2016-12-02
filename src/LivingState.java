import java.util.Arrays;

public enum LivingState {
    UT(6.85),
    NV(8.0),
    TX(6.25),
    AL(4.00),
    CA(8.25);

    private double taxRate;

    LivingState(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public static String printValues() {
        String v =  "";
        LivingState[] values = values();
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

    @Override
    public String toString() {
        return name() + "(" + taxRate +"%)";
    }
}
