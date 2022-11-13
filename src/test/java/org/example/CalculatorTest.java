package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Requirements:
 * Able to do simple arithmetic operation
 * Only calculates with positive number
 * Returns IllegalArgument exception if divide into 0
 * Uses MVC(Model-View-Controller) pattern to implement it
 */
public class CalculatorTest {

    @DisplayName("Implement addition and subtraction")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator,
                new PositiveNumber(operand2));

        assertThat(result).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }
    
    @DisplayName("Throw errors if divide into zero")
    @Test
    void calculateExceptionTest() {
        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/",
                new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Zero or negative number cannot be sent");
    }
}
