package pl.beata.springbootweatherclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.beata.springbootweatherclient.model.CurrentTemperature;

@Repository
public interface CurrentTemperatureRepository extends JpaRepository<CurrentTemperature, Long> {
}
