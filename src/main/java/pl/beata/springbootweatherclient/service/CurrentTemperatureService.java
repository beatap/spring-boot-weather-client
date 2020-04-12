package pl.beata.springbootweatherclient.service;

import org.springframework.stereotype.Service;
import pl.beata.springbootweatherclient.model.CurrentTemperature;
import pl.beata.springbootweatherclient.repository.CurrentTemperatureRepository;

@Service
public class CurrentTemperatureService {

    CurrentTemperatureRepository currentTemperatureRepository;

    public CurrentTemperatureService(CurrentTemperatureRepository currentTemperatureRepository) {
        this.currentTemperatureRepository = currentTemperatureRepository;
    }

    public void saveCurrentTemp(CurrentTemperature currentTemperature) {
        currentTemperatureRepository.save(currentTemperature);
    }
}
