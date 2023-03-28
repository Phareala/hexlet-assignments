package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>(Arrays.asList(0, -1, 456));
        System.out.println(App.take(test, -1));
    }
}
