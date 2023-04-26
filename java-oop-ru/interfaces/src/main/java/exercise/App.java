package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> objects, int number) {
        return objects.stream()
                .sorted(Home::compareTo)
                .limit(number)
                .map(Object::toString)
                .collect(Collectors.toList());
    }

}
// END
