package himmat.crickme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


Callback<WeatherResponse> cb = new Callback<WeatherResponse>() {
    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        if (response.body() == null)
            tv.setText("Weather response return NULL");
        else {
            String result = response.body().base + response.body().cod;
            tv.setText(result);
        }
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        tv.setText("An error occur while retrieving data from Weather API");
    }
};


WeatherRestAdapter restAdapter = new WeatherRestAdapter();
Call<WeatherResponse> apiCall = restAdapter.GetCityWeather("London,UK", "b1b15e88fa797225412429c1c50c122a1");

apiCall.enqueue(cb);


    }
}
