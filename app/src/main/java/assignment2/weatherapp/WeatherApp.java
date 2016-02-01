package assignment2.weatherapp;

/**
 * Created by Raman on 2/1/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherApp {

    @SerializedName("response")
    @Expose
    public Response response;

}
