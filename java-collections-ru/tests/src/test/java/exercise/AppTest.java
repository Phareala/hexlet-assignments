package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> numbers1Cli = App.take(numbers1, 2);
        List<Integer> numbers1Answer = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(numbers1Cli).isEqualTo(numbers1Answer);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> numbers2Cli = App.take(numbers2, 0);
        assertThat(numbers2Cli).isEmpty();

        List<Integer> numbers3 = new ArrayList<>(Arrays.asList(1, 4, -23, 23));
        List<Integer> numbers3Cli = App.take(numbers3, 5);
        assertThat(numbers3).isEqualTo(numbers3);

        List<Integer> numbers4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> numbers4Cli = App.take(numbers2, -1);
        assertThat(numbers2Cli).isEmpty();
        // END
    }
}
