package functional.interface_;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FunctionalInterfaceTest {

    @Test
    public void shouldConvertANumberAsStringToIntegerUsingFunctionsWithAnonymousClass() throws Exception {
        Function<String, Integer> convertToInteger = new Function<String, Integer>() {

            @Override
            public Integer apply(String numberAsString) {
                return Integer.valueOf(numberAsString);
            }
        };

        Integer number = convertToInteger.apply("10");

        assertThat(number, equalTo(10));
    }

    @Test
    public void shouldConvertANumberAsStringToIntegerUsingFunctionsWithLambdaExpression() throws Exception {
        Function<String, Integer> convertToInteger = numberAsString -> Integer.valueOf(numberAsString);

        Integer number = convertToInteger.apply("10");

        assertThat(number, equalTo(10));
    }

    @Test
    public void shouldConvertANumberAsStringToIntegerAndMultiplyItUsingAnonymousClass() throws Exception {
        Function<String, Integer> convertToInteger = new Function<String, Integer>() {

            @Override
            public Integer apply(String numberAsString) {
                return Integer.valueOf(numberAsString);
            }
        };

        Function<Integer, Integer> multiplyBy10 = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer number) {
                return number * 10;
            }
        };

        Integer number = convertToInteger.andThen(multiplyBy10).apply("10");

        assertThat(number, equalTo(100));
    }


    @Test
    public void shouldConvertANumberAsStringToIntegerAndMultiplyItByUsingLambdaExpression() throws Exception {
        Function<String, Integer> convertToInteger = numberAsString -> Integer.valueOf(numberAsString);

        Function<Integer, Integer> multiplyBy10 = number -> number * 10;

        Integer number = convertToInteger.andThen(multiplyBy10).apply("10");

        assertThat(number, equalTo(100));
    }

    @Test
    public void shouldUseRealFunctionalInterface() throws Exception {
        ExampleFunctionalInterface functionalInterface = new ExampleFunctionalInterface() {

            @Override
            public void doSomething() {
                System.out.println("Doing Something");
            }
        };

        functionalInterface.doSomething();
    }

    @Test
    public void shouldUseRealFunctionalInterfaceWithJava8LambdaExpression() throws Exception {
        ExampleFunctionalInterface functionalInterface = () -> System.out.println("Doing Something");

        functionalInterface.doSomething();
    }

}
