package exercise.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    private final WeatherService weatherService;

    // BEGIN
    @GetMapping("/cities/{id}")
    public Map<String, String> getCityWeather(@PathVariable("id") long id)
            throws JsonProcessingException {
        return weatherService.getWeather(id);
    }

    @GetMapping("/search")
    public List<Map<String, String>> getCities(@RequestParam(value = "name", required = false) String name) {
        List<City> cities = name == null ? cityRepository.findAllByOrderByNameAsc()
                : cityRepository.findByNameStartingWithIgnoreCase(name);

        return cities.stream()
                .map(x -> {
                    Map<String, String> fullWeatherData = null;
                    try {
                        fullWeatherData = weatherService.getWeather(x.getId());
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    Map<String, String> weatherData = new HashMap<>();
                    weatherData.put("temperature", fullWeatherData.get("temperature"));
                    weatherData.put("name", fullWeatherData.get("name"));
                    return weatherData;
                })
                .sorted(Comparator.comparing(x -> x.get("name")))
                .toList();
    }
    // END
}

