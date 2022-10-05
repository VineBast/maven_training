package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTest {

    @ParameterizedTest
    @CsvSource({
        "1, 3, 4",
        "3, 5, 8",
        "-1, -3, -4"
    })
    void put_ints_should_return_the_addition(int num1, int num2, int expectedResult) {
        var sample = new Sample();
        int addi = sample.op(Sample.Operation.ADD, num1, num2);
        Assertions.assertThat(addi).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "3, 3, 9",
        "-1, -3, 3"
    })
    void put_int_should_return_the_multiplication(int num1, int num2, int expectedResult) {
        var sample = new Sample();
        int multi = sample.op(Sample.Operation.MULT, num1, num2);
        Assertions.assertThat(multi).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "4, 24",
        "1, 1",
        "0, 1"
    })
    void put_int_should_return_the_factorisation(int int1, int expectedResult) {
        var sample = new Sample();
        int multi = sample.fact(int1);
        Assertions.assertThat(multi).isEqualTo(expectedResult);
    }

    @Test
    void put_int_under_zero_to_fact() {
        var sample = new Sample();
        Assertions
            .assertThatIllegalArgumentException()
            .isThrownBy(() ->sample.fact(-4));
    }
}
