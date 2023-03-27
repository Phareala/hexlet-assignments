package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {

    public static List findWhere(List<Map<String, String>> sd, Map wwe) {
        List<Map> result = new ArrayList<>();
        for (Map s : sd) {
            var tittleList = s.get("title");
            var tittleMap = wwe.get("title");
            var authorList = s.get("author");
            var authorMap = wwe.get("author");
            var yearList = s.get("year");
            var yearMap = wwe.get("year");
            if (wwe.containsKey("title")) {
                if (yearList.equals(yearMap) && authorList.equals(authorMap) && tittleList.equals(tittleMap)) {
                    result.add(s);
                }
            } else {
                if (yearList.equals(yearMap) && authorList.equals(authorMap)) {
                    result.add(s);
                }
            }
        }
            return result;
    }
}
//END
