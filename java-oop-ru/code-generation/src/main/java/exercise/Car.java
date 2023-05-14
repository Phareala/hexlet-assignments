package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Data
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
//    public static String serialize(Car car) throws JsonProcessingException {
    @SneakyThrows
    public static String serialize(Car car) {
        ObjectMapper json = new ObjectMapper();
        return json.writeValueAsString(car);
    }

    @SneakyThrows
    public static Car unserialize(String json) {
        ObjectMapper data = new ObjectMapper();
        return data.readValue(json, Car.class);
    }
    // END
}
