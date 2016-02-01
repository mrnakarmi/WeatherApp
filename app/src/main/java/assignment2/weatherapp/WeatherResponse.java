package assignment2.weatherapp;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Raman on 1/31/2016.
 */
public class WeatherResponse {


    @Generated("org.jsonschema2pojo")
    public class Conditions {

        @SerializedName("wind_gust_mph")
        @Expose
        public Integer windGustMph;
        @SerializedName("temp_f")
        @Expose
        public Double tempF;
        @SerializedName("observation_location")
        @Expose
        public ObservationLocation observationLocation;
        @SerializedName("temp_c")
        @Expose
        public Double tempC;
        @SerializedName("relative_humidity")
        @Expose
        public String relativeHumidity;
        @SerializedName("weather")
        @Expose
        public String weather;
        @SerializedName("dewpoint_c")
        @Expose
        public Integer dewpointC;
        @SerializedName("windchill_c")
        @Expose
        public String windchillC;
        @SerializedName("pressure_mb")
        @Expose
        public String pressureMb;
        @SerializedName("windchill_f")
        @Expose
        public String windchillF;
        @SerializedName("dewpoint_f")
        @Expose
        public Integer dewpointF;
        @SerializedName("wind_mph")
        @Expose
        public Double windMph;

    }

    @Generated("org.jsonschema2pojo")
    public class ObservationLocation {

        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("full")
        @Expose
        public String full;
        @SerializedName("elevation")
        @Expose
        public String elevation;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("longitude")
        @Expose
        public String longitude;
        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("country_iso3166")
        @Expose
        public String countryIso3166;
        @SerializedName("latitude")
        @Expose
        public String latitude;

    }

    @Generated("org.jsonschema2pojo")
    public class Response {

        @SerializedName("conditions")
        @Expose
        public Conditions conditions;
        @SerializedName("result")
        @Expose
        public String result;

    }

    @Generated("org.jsonschema2pojo")
    public class WeatherResponse {

        @SerializedName("response")
        @Expose
        public Response response;
    }
}