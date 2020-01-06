package pl.beata.springbootweatherclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.beata.springbootweatherclient.model.Parent;
import pl.beata.springbootweatherclient.model.Weather;

@Controller
public class WeatherController {

    private final RestTemplate restTemplate = new RestTemplate();



    @GetMapping
    public String index() {
        return "weather";
    }

    @GetMapping("/location")
    public String getCity(@RequestParam String city, Model model) {
        model.addAttribute("countries", getCities(city));

        return "weather";
    }

    @GetMapping("/actual_weather")
    public String getActualWeather(@RequestParam String city, Model model) {
        Parent[] parent = getCities(city);
        Weather weather = null;

        if(parent != null && parent.length == 1) {
            weather = getactualWeather(parent[0].getWoeid());

        } else {
            model.addAttribute("error", "Invalidate city!");
        }

        if(weather != null) {
            model.addAttribute("title", weather.getTitle());
            if(weather.getConsolidatedWeather() != null && weather.getConsolidatedWeather().size() > 0) {
                model.addAttribute("actualWeather", weather.getConsolidatedWeather().get(0));
            }
        }

        return "weather";
    }

    private Parent[] getCities(String city) {

        return restTemplate.getForObject("https://www.metaweather.com/api/location/search/?query={city}",
                Parent[].class,
                city);
    }

    private Weather getactualWeather(Integer woeid) {

        return restTemplate.getForObject("https://www.metaweather.com/api/location/{woeid}",
                Weather.class,
                woeid);
    }
}
