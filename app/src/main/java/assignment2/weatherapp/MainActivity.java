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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://luca-teaching.appspot.com/weather/default/get_weather")
                .addConverterFactory(GsonConverterFactory.create())	//parse Gson string
                .client(httpClient)	//add logging
                .build();

        NicknameService service = retrofit.create(NicknameService.class);

        Call<RegistrationResponse> queryResponseCall =
                service.registerUser(user_id, nickname);

        //Call retrofit asynchronously
        queryResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Response<RegistrationResponse> response) {
                Log.i(LOG_TAG, "Code is: " + response.code());
                Log.i(LOG_TAG, "The result is: " + response.body().response);
            }

            @Override
            public void onFailure(Throwable t) {
                // Log error here since request failed
            }
    }

    public void getWeather(View V){
        Intent intent = new Intent(this,WeatherStatus.class);
        startActivity(intent);

    }
    public interface NicknameService {
        @GET("default/register_user")
        Call<RegistrationResponse> registerUser(@Query("user_id") String user_id,
                                                @Query("nickname") String nickname);
    }
}
