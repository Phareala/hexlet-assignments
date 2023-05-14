package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> defect = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            try {
                field.setAccessible(true);
                if (notNull != null && field.get(address) == null) {
                    defect.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return defect;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
//            String temp = (String) field.get(address);
            try {
                field.setAccessible(true);
                if (notNull != null && field.get(address) == null) {
                    result.put(field.getName(), List.of("Can`t be NULL"));
                }
                if (minLength != null) {
                    String temp = (String) field.get(address);
                    if (temp.length() < minLength.minLength()) {
                        result.put(field.getName(), List.of("length less than " + minLength.minLength()));
                    }

                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

}
// END
