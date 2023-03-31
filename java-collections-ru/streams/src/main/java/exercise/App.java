package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static Integer getCountOfFreeEmails(List emailss) {
        List<String> emails = emailss;
        int i = 0;
        for (String email : emails) {
            if (email.endsWith("gmail.com") || email.endsWith("yandex.ru") || email.endsWith("hotmail.com")) {
                ++i;
            }
        }
        return i;
    }
}
// END
