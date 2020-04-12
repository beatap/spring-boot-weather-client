package pl.beata.springbootweatherclient.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.beata.springbootweatherclient.model.CurrentTemperature;
import pl.beata.springbootweatherclient.model.Parent;
import pl.beata.springbootweatherclient.model.Weather;
import pl.beata.springbootweatherclient.service.CurrentTemperatureService;

@Component
public class WeatherComponent {

    private final RestTemplate restTemplate = new RestTemplate();
    private CurrentTemperatureService currentTemperatureService;


    public WeatherComponent(CurrentTemperatureService currentTemperatureService) {
        this.currentTemperatureService = currentTemperatureService;
    }


    @Scheduled(cron = "0 */1 * * *")
    public void saveActualTemp() {
        getActualWeather("London");
    }

    public void getActualWeather(String city) {
        Parent[] parent = getCities(city);
        Weather weather = null;

        if(parent != null && parent.length == 1) {
            weather = getactualWeather(parent[0].getWoeid());

        }

        if(weather != null) {
            if(weather.getConsolidatedWeather() != null && weather.getConsolidatedWeather().size() > 0) {
                saveToDB(weather);
            }
        }

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

    private void saveToDB(Weather weather) {
        CurrentTemperature currentTemperature = new CurrentTemperature();
        currentTemperature.setCity(weather.getTitle());
        currentTemperature.setTemperature(weather.getConsolidatedWeather().get(0).getTheTemp());

        currentTemperatureService.saveCurrentTemp(currentTemperature);
    }
}
