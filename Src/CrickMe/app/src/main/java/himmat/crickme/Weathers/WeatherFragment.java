package himmat.crickme.Weathers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import himmat.crickme.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Himmat on 20-11-2017.
 */

public class WeatherFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.weather_content,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.nav_weather);
        final TextView tv = getActivity().findViewById(R.id.tv_weatherReport);


final Callback<WeatherResponse> cb = new Callback<WeatherResponse>() {
    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        if (response.body() == null)
            tv.setText("Weather response return NULL");
        else {
            WeatherResponse weatherResult = response.body();
            String result = String.valueOf(weatherResult.id)
                    + System.getProperty("line.separator") + String.valueOf(weatherResult.weather.get(0).main)
                    + System.getProperty("line.separator") + String.valueOf(weatherResult.weather.get(0).description);
            tv.setText(result);
        }
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        tv.setText("An error occur while retrieving data from Weather API");
    }
};

        Button btnWeather = getActivity().findViewById(R.id.btn_weather_report);
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context ctx = getActivity().getApplication().getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence toastText = "You city weather data loading...";
                Toast toast= Toast.makeText(ctx,toastText,duration);
                toast.show();

                EditText et_city = getActivity().findViewById(R.id.et_city);
                String cityName = et_city.getText().toString();

                if(cityName!=null && cityName.length()>0) {
                    WeatherRestAdapter restAdapter = new WeatherRestAdapter();
                    Call<WeatherResponse> apiCall = restAdapter.GetCityWeather(cityName);
                    apiCall.enqueue(cb);
                }
            }
        });





    }
}
