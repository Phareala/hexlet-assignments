package exercise;

import java.util.HashMap;
import java.util.Map;


// BEGIN


public class App {
    public static Map getWordCount(String text) {
        Map<String, Integer> list = new HashMap<>();
        if (text.equals("")) {
            return list;
        }
        String[] array = text.split(" ");
        for (var i = 0; i < array.length; i++) {
            String name = array[i];
            if (list.containsKey(name)) {
                int value = list.get(name);
                list.put(name, value + 1);
            } else {
                list.put(name, 1);
            }
        }
        return list;
    }
    public static String toString(Map list) {
        String result = "";
        if (list.isEmpty()) {
            return "{}";
        }
        Map<String, Integer> map;
        map = list;
        result += "{\n";
        for(String s : map.keySet()) {
            result += ("  " + s + ": " + list.get(s) + "\n");
//            System.out.println("  " + s + ": " + list.get(s));
        }
        result += "}";
        return result;
    }
//END
