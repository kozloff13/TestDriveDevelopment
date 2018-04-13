public class Calculator {

    public enum Command {
        SUM,
        DIV,
        SUBSTRACT
    }

    public int calculate(Command command, int argument1, int argument2) {
        int argAbs1 = Math.abs(argument1);
        int argAbs2 = Math.abs(argument2);
        switch (command) {
            case SUM:
                return sum(argAbs1, argAbs2);
            case DIV:
                return div(argAbs1, argAbs2);
            default:
                throw new UnsupportedOperationException("Unknown operation = " + command);
        }
    }

    private int sum(int argument1, int argument2) {
        return argument1 + argument2;
    }

    private int div(int divined, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Divisor can not be zero!");
        else
            return divined / divisor;
    }
}
