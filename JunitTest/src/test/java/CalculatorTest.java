import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith({TestWatcherExtension.class, CalculateExtension.class})
public class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
        System.out.println("before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "4, -5, -1",
            "9, -5, 4",
            "5, 10, 15"
    })
    public void testAdd(int num1,int num2, int res){
        assertEquals(res,calculator.add(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("divisionParameters")
    public void testDivision(int num1,int num2, int res){
        assertEquals(res,calculator.divide(num1,num2));
    }

    static Stream<Arguments> divisionParameters() {
        return Stream.of(
                arguments(20,5,4),
                arguments(6,2,3),
                arguments(9,3,3),
                arguments(-10,-5,2)
        );
    }

    @Test
    public void testDividingByZero(){
        assertThrows(ArithmeticException.class,()->calculator.divide(5,0));
    }

    @Test
    public void testSubtract() {
        assertEquals(12,calculator.subtract(17,5));
    }

    @Test
    public void testMultiply() {
        assertEquals(30,calculator.multiply(5,6));
    }
}
