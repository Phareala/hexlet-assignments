package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

       // System.out.println(Arrays.deepToString(image)); // =>
// [
//     [*, *, *, *],
//     [*,  ,  , *],
//     [*,  ,  , *],
//     [*, *, *, *],
// ]

        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));
    }

    public static String[][] enlargeArrayImage(String[][] imageSquare) {
        String[][] result = Arrays.stream(imageSquare)
                .flatMap(image -> Stream.of(image, image))
                .toArray(String[][]::new);

        return result;
    }

}
// END
