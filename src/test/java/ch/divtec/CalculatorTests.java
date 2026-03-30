package ch.divtec;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    private static Calculator calculator = new Calculator();

    // Variables to store the message for a negative number and store the result
    private static String factorialMustBeIntegerMessage;

    // Method to perform setup operations before any of the test methods in the class
    @BeforeAll
    static void init() {
        // Check the exception message for a negative number and store the result
        try {
            calculator.factorial(1.5);
        } catch (Exception e) {
            factorialMustBeIntegerMessage = e.getMessage();
            System.err.println(factorialMustBeIntegerMessage);
        }
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Cleanup after all tests");
    }

    @BeforeEach
    void setUp() {
        // Instance of Calculator class
        calculator = new Calculator();
    }

    @AfterEach
    public void cleanCheck() {
        System.out.println("Running in CleanCheck ");
        System.out.println("------------------------------------------------------");
    }

    @RepeatedTest(3)
    public void multiplyByTwo(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Test " + testInfo.getTestMethod().get().getName()
                + " running:  " + repetitionInfo.getCurrentRepetition());
        assertEquals(8,calculator.multiply(4,2));
    }

    @Test
    void factorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-5);
        });
        String actualMessage = exception.getMessage();
        assertEquals(Calculator.ERROR_MSG_NEGATIVE_NUMBER, actualMessage);
    }

    @Test
    void addNormal() {
        assertEquals(4, calculator.add(2,2));
    }

    @Test
    void addNegative() {
        assertEquals(-1, calculator.add(2,-3));
    }

    @Test
    void subtractNormal() {
        assertEquals(1, calculator.subtract(3,2));
    }

    @Test
    void subtractNegative() {
        assertEquals(-4, calculator.subtract(3,7));
    }

    @Test
    void subtractBothNegative() {
        assertEquals(-3, calculator.subtract(-8,-5));
    }

    @Test
    void multiplyNormal() {
        assertEquals(15, calculator.multiply(3,5));
    }

    @Test
    void multiplyNegative() {
        assertEquals(-12, calculator.multiply(-3,4));
    }

    @Test
    void multiplyFirstZero() {
        assertEquals(0, (int)calculator.multiply(0,-5649687));
        assertEquals(0, calculator.multiply(0,-5649687), 0.00000000000000000000000000000000000001);
    }

    @Test
    void divideNormal() {
        assertEquals(0.6, calculator.divide(3,5));
    }

    @Test
    void divideNegative() {
        assertEquals(-0.8, calculator.divide(-4,5));
    }

    @Test
    void divideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(-4,0);
        });

        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void factorialNormal() {
        assertEquals(6, calculator.factorial(3));
    }

    @Test
    void factorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorialDecimal() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(3.2);
        });

        String actualMessage = exception.getMessage();
        assertEquals(factorialMustBeIntegerMessage, actualMessage);
    }
}
