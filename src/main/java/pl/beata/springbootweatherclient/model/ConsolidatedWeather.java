
package pl.beata.springbootweatherclient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "weather_state_name",
    "weather_state_abbr",
    "wind_direction_compass",
    "created",
    "applicable_date",
    "min_temp",
    "max_temp",
    "the_temp",
    "wind_speed",
    "wind_direction",
    "air_pressure",
    "humidity",
    "visibility",
    "predictability"
})
@Getter
@Setter
@ToString
public class ConsolidatedWeather {

    @JsonProperty("id")
    private BigDecimal id;
    @JsonProperty("weather_state_name")
    private String weatherStateName;
    @JsonProperty("weather_state_abbr")
    private String weatherStateAbbr;
    @JsonProperty("wind_direction_compass")
    private String windDirectionCompass;
    @JsonProperty("created")
    private String created;
    @JsonProperty("applicable_date")
    private String applicableDate;
    @JsonProperty("min_temp")
    private Double minTemp;
    @JsonProperty("max_temp")
    private Double maxTemp;
    @JsonProperty("the_temp")
    private Double theTemp;
    @JsonProperty("wind_speed")
    private Double windSpeed;
    @JsonProperty("wind_direction")
    private Integer windDirection;
    @JsonProperty("air_pressure")
    private Integer airPressure;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("visibility")
    private Double visibility;
    @JsonProperty("predictability")
    private Integer predictability;

}
