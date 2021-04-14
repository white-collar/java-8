package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StreamCountTest {
    @Test
    public void shouldCountNumbersInTheList() throws Exception {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);

        long quantity = listOfNumbers
                .stream()
                .count();

        assertThat(quantity, equalTo(5L));
    }
}
