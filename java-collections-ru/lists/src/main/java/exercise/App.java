package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        word = word.toLowerCase();
        List<String> list = new ArrayList<>();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < letters.length(); i++) {
            var index =  String.valueOf(letters.charAt(i));
            list.add(index);
        }
        for (int i = 0; i < word.length(); i++) {
            var index =  String.valueOf(word.charAt(i));
            words.add(index);
        }
        for (var i = 0; i < word.length(); i++) {
            if (list.contains(words.get(i))) {
                list.remove(words.get(i));
                System.out.println(list);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
