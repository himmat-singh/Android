package himmat.crickme;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Himmat on 20-11-2017.
 */

public interface MatchApi {

    @GET("data/match/list")
    void getMatcheListFromApi(Callback<MatchResponse> callback);

    @GET("data/match/{title}/get")
    void getMatchDetailsFromApi(@Path("title") String title, Callback<MatchResponse> callback);
}
