package himmat.crickme;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Himmat on 20-11-2017.
 */

public interface WeatherApi {

    @GET("data/2.5/weather")
    Call<WeatherResponse> GetWeatherDetails(@Query("q") String cityName,@Query("appid") String appId);
}
