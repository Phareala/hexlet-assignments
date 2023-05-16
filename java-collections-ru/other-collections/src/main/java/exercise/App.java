package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> data : map1.entrySet()) {
            if (map2.containsKey(data.getKey())) {
                if (map2.containsValue(data.getValue())) {
                    result.put(data.getKey(), "unchanged");
                } else {
                    result.put(data.getKey(), "changed");
                }
            } else {
                result.put(data.getKey(), "deleted");
            }
        }
        for (Map.Entry<String, Object> data2 : map2.entrySet()) {
            if (!map1.containsKey(data2.getKey())) {
                result.put(data2.getKey(), "added");
            }
        }
        AssertionError sd = new AssertionError();
        return result;
        psvm

    }
}
//END
