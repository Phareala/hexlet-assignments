package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String script) {
        return Arrays.stream(script.split("\n"))
                .filter(text -> text.startsWith("environment"))
                .map(text -> text.replace("\"", ""))
                .map(text -> text.replace("environment=", ""))
                .flatMap(text -> Stream.of(text.split(",")))
                .filter(text -> text.startsWith("X_FORWARDED_"))
                .map(text -> text.replace("X_FORWARDED_", ""))

                .collect(Collectors.joining(","));
    }
}
//END
