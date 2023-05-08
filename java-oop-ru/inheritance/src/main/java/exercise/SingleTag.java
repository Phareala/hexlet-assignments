package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    SingleTag(String name, Map<String, String> attr) {
        super(name, attr);
    }

    public String toString() {
        return String.format("<%s%s>", getName(), attributesToString());
    }
}
// END
