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
        for (LivingState livingState : values()) {
            v += v + ", " + livingState.name();
        }
        return v;
    }
}
