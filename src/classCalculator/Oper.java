package classCalculator;

enum Oper {
    ADD("+"),
    SUBTRACT("-"),
    MULTI("*"),
    DIVIDE("/");

    private String oper;

    private Oper(String oper) {
        this.oper = oper;
    }

    public String getOper() {
        return oper;
    }
}
