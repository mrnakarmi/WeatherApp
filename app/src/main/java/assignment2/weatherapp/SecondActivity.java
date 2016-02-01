package assignment2.weatherapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by Raman on 2/1/2016.
 */
public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String s = prefs.getString("myprefs", null);
        Gson gson = new Gson();
        if (s != null) {
            Conditions c = gson.fromJson(s, Conditions.class);
            TextView tv2 = (TextView) findViewById(R.id.textView2);
            TextView tv3 = (TextView) findViewById(R.id.textView3);
            tv2.setText(c.windGustMph.toString());
            tv3.setText(c.tempC.toString());
        }
    }

}
