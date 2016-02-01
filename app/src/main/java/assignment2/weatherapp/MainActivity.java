package assignment2.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    private String user_id;
    private Conditions conditions;

    public static String LOG_TAG = "My log tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getWeather(View V){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        //conditions = settings.getString("response",null);

        String result="";

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://luca-teaching.appspot.com/weather/default/get_weather/")
                .addConverterFactory(GsonConverterFactory.create())    //parse Gson string
                .client(httpClient)    //add logging
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        Call<Response> queryResponseCall =
                service.WeatherResponse(conditions, result);

        //Call retrofit asynchronously
        queryResponseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Response<Response> response) {
                Log.i(LOG_TAG, "Code is: " + response.code());
                Log.i(LOG_TAG, "The result is: " + response.body().toString());// response.body().response in class example
            }

            @Override
            public void onFailure(Throwable t) {
                // Log error here since request failed
            }
        });

        Gson gson = new Gson();
        String s = gson.toJson(conditions);
        Log.i(LOG_TAG,"Json string: "+ s);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor e = prefs.edit();
        e.putString("myprefs",s);
        e.commit();
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public interface WeatherService {
     @GET("default/get_weather")
        Call<Response> WeatherResponse(@Query("conditions") Conditions conditions,
                                @Query("result") String result);
    }
}
