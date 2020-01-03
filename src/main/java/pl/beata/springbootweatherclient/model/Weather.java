
package pl.beata.springbootweatherclient.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "consolidated_weather",
    "time",
    "sun_rise",
    "sun_set",
    "timezone_name",
    "parent",
    "sources",
    "title",
    "location_type",
    "woeid",
    "latt_long",
    "timezone"
})
@Getter
@Setter
@ToString
public class Weather {

    @JsonProperty("consolidated_weather")
    private List<ConsolidatedWeather> consolidatedWeather = null;
    @JsonProperty("time")
    private String time;
    @JsonProperty("sun_rise")
    private String sunRise;
    @JsonProperty("sun_set")
    private String sunSet;
    @JsonProperty("timezone_name")
    private String timezoneName;
    @JsonProperty("parent")
    private Parent parent;
    @JsonProperty("sources")
    private List<Source> sources = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("location_type")
    private String locationType;
    @JsonProperty("woeid")
    private Integer woeid;
    @JsonProperty("latt_long")
    private String lattLong;
    @JsonProperty("timezone")
    private String timezone;

}
