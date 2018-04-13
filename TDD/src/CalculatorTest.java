import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private static final int ZERO = 0;

    private int argument1;
    private int argument2;

    private Calculator calculator;

    private Calculator.Command command;

    private int result;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }
    @Test
    public void test_sum() {
        given_arguments(2, 2);
        when_command_is(Calculator.Command.SUM);
        then_result_is(4);
    }
    @Test
    public void test_sum_abs() {
        given_arguments(5, -3);
        when_command_is(Calculator.Command.SUM);
        then_result_is(8);
    }

    @Test
    public void test_sum1() {
        given_arguments(3, 3);
        when_command_is(Calculator.Command.SUM);
        then_result_is(6);
    }

    @Test
    public void test_div() {
        given_arguments(20, 5);
        when_command_is(Calculator.Command.DIV);
        then_result_is(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_div_on_zero() {
        given_arguments(100, ZERO);
        when_command_is(Calculator.Command.DIV);
        then_result_throw_exception();
    }

    @Test
    public void test_div_abs() {
        given_arguments(10, -2);
        when_command_is(Calculator.Command.DIV);
        then_result_is(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_substract() {
        given_arguments(10, 10);
        when_command_is(Calculator.Command.SUBSTRACT);
        then_result_throw_exception();
    }

    private void given_arguments(int arg1, int arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    private void when_command_is(Calculator.Command command) {
        this.result = calculator.calculate(command, argument1, argument2);
    }

    private void then_result_is(int expectedResult) {
        Assert.assertThat(result, Is.is(expectedResult));
    }

    private void then_result_throw_exception() {
        Assert.fail();
    }
}
