package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage another) {
        Map<String, String> tempMap = another.toMap();
        for (Entry<String, String> entry : tempMap.entrySet()) {
            another.unset(entry.getKey());
            another.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
