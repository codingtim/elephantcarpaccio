public enum LivingState {
    UT,
    NV,
    TX,
    AL,
    CA;

    public static String printValues() {
        String v =  "";
        for (LivingState livingState : values()) {
            v += v + ", " + livingState.name();
        }
        return v;
    }
}
