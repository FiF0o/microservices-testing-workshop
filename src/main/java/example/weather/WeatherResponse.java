package example.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private List<Weather> weather;

    public WeatherResponse() {}

    public WeatherResponse(String currentMain) {
        this.weather = Collections.singletonList(new Weather(currentMain));
    }

    public Weather getWeather() {
        return weather.get(0);
    }

    public String getMain() {
        return weather.get(0).getMain();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherResponse response = (WeatherResponse) o;

        return weather != null ? weather.equals(response.weather) : response.weather == null;
    }

    @Override
    public int hashCode() {
        return weather != null ? weather.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "weather=" + weather +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private String main;

        public Weather() {}

        public Weather(String main) {
            this.main = main;
        }

        public String getMain() {
            return main;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Weather weather = (Weather) o;

            return Objects.equals(main, weather.main);
        }

        @Override
        public int hashCode() {
            return main != null ? main.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "main='" + main + '\'' +
                    '}';
        }
    }
}
