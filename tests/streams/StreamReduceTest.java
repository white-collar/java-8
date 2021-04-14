package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.*;


public class StreamReduceTest {

    @Test
    public void shouldReduceTheListOfNumbers() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 5);

        Optional<Integer> reduced = numbers
                .stream()
                .reduce(new BinaryOperator<Integer>() {

                    @Override
                    public Integer apply(Integer first, Integer second) {
                        return first + second;
                    }
                });

        assertThat(reduced.isPresent(), is(true));
        assertThat(reduced.get(), equalTo(8));
    }

    @Test
    public void shouldReduceTheListOfNumbersByUsingLambdaExpression() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 5);

        Optional<Integer> reduced = numbers
                .stream()
                .reduce((first, second) -> first + second);

        assertThat(reduced.isPresent(), is(true));
        assertThat(reduced.get(), equalTo(8));
    }
}
