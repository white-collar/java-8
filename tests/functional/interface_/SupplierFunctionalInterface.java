package functional.interface_;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SupplierFunctionalInterface {

    @Test
    public void shouldGetTheTextByUsingSupplierWithoutLambdaExpression() throws Exception {
        Supplier<String> supplier = new Supplier<String>() {

            @Override
            public String get() {
                return "Justice League";
            }
        };

        String guide = supplier.get();

        assertThat(guide, equalTo("Justice League"));
    }

    @Test
    public void shouldGetTheTextByUsingSupplierWithLambdaExpression() throws Exception {
        Supplier<String> supplier = () -> "Justice League";

        String guide = supplier.get();

        assertThat(guide, equalTo("Justice League"));
    }
}
