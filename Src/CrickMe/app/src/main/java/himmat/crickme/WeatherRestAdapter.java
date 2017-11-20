package himmat.crickme;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Himmat on 20-11-2017.
 */

public class WeatherRestAdapter {

    protected final String TAG = getClass().getSimpleName();
    protected Retrofit retrofit;
    protected WeatherApi weatherApi;
    static final String API_URL ="http://openweathermap.org/api/";


    public  WeatherRestAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
    }

    public Call<WeatherResponse> GetCityWeather(String cityName, String appId){

      return weatherApi.GetWeatherDetails(cityName,appId);

    }
}
