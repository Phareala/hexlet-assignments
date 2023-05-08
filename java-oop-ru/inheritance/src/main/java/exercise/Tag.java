   package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> attr;

    Tag(String name, Map<String, String> attr) {
        this.name = name;
        this.attr = attr;
    }

    public String attributesToString() {
        return attr.keySet().stream()
                .map(key -> {
                    String value = attr.get(key);
                    return String.format(" %s=\"%s\"", key, value);
                })
                .collect(Collectors.joining(""));
    }

    public String getName() {
        return this.name;
    }

}
// END
