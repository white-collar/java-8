package functional.interface_;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PredicateFunctionalInterface {
    @Test
    public void shouldCheckThatTheTextIsGreaterThan5UsingAnonymousClass() throws Exception {
        Predicate<String> greaterThan5 = new Predicate<String>() {

            @Override
            public boolean test(String text) {
                return text.length() > 5;
            }
        };

        boolean isGreaterThan5 = greaterThan5.test("Java 8 - Guide");

        assertThat(isGreaterThan5, is(true));
    }

    @Test
    public void shouldCheckThatTheTextIsGreaterThan5UsingLambdaExpression() throws Exception {
        Predicate<String> greaterThan5 = text -> text.length() > 5;

        boolean isGreaterThan10 = greaterThan5.test("Coronavirus");

        assertThat(isGreaterThan10, is(true));
    }

    @Test
    public void shouldCheckThatTheTextIsGreaterThan5AndNegateIt() throws Exception {
        Predicate<String> greaterThan5 = text -> text.length() > 5;

        boolean isGreaterThan5 = greaterThan5.negate().test("Coronavirus");

        assertThat(isGreaterThan5, is(false));
    }


    @Test
    public void shouldCheckThatTheTextIsGreaterThan5AndLessThan10UsingAnonymousClass() throws Exception {
        Predicate<String> greaterThan5 = new Predicate<String>() {

            @Override
            public boolean test(String text) {
                return text.length() > 5;
            }
        };

        Predicate<String> lessThan10 = new Predicate<String>() {

            @Override
            public boolean test(String text) {
                return text.length() < 20;
            }
        };

        boolean isGreaterThan5AndLessThan10 = greaterThan5.and(lessThan10).test("Coronavirus");

        assertThat(isGreaterThan5AndLessThan10, is(true));
    }

    @Test
    public void shouldCheckThatTheTextIsGreaterThan5AndLessThan10UsingLambdaExpression() throws Exception {
        Predicate<String> greaterThan5 = text -> text.length() > 5;

        Predicate<String> lessThan10 = text -> text.length() < 20;

        boolean isGreaterThan5AndLessThan10 = greaterThan5.and(lessThan10).test("Coronavirus");

        assertThat(isGreaterThan5AndLessThan10, is(true));
    }
}
