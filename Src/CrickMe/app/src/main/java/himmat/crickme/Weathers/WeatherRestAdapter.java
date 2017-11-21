package himmat.crickme.Weathers;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Himmat on 20-11-2017.
 */

public class WeatherRestAdapter {

    protected final String TAG = getClass().getSimpleName();
    protected Retrofit retrofit;
    protected WeatherApi weatherApi;
    static final String API_URL ="http://samples.openweathermap.org/";
    static  final  String API_KEY ="ff3d09fe32a9f3cb653a9b12cac5f297";


    public  WeatherRestAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
    }

    public Call<WeatherResponse> GetCityWeather(String cityName){

      return weatherApi.GetWeatherDetails(cityName,API_KEY);

    }



}
