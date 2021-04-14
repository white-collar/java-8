package functional.interface_;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class ComparatorFunctionalInterface {
    @Test
    public void shouldCompareTwoGuidesByUsingComparator() throws Exception {
        JusticeLeagueHero mockito = new JusticeLeagueHero("Mockito");
        JusticeLeagueHero java = new JusticeLeagueHero("Java 8");

        Comparator<JusticeLeagueHero> comparator = new Comparator<JusticeLeagueHero>() {

            @Override
            public int compare(JusticeLeagueHero first, JusticeLeagueHero second) {
                return first.getName().compareTo(second.getName());
            }
        };

        int compared = comparator.compare(mockito, java);

        assertThat(compared, greaterThan(0));
    }

    @Test
    public void shouldCompareTwoGuidesByUsingComparatorWithLambdaExpression() throws Exception {
        JusticeLeagueHero mockito = new JusticeLeagueHero("Mockito");
        JusticeLeagueHero java = new JusticeLeagueHero("Java 8");

        Comparator<JusticeLeagueHero> comparator = (first, second) -> first.getName().compareTo(second.getName());

        int compared = comparator.compare(mockito, java);

        assertThat(compared, greaterThan(0));
    }
}



