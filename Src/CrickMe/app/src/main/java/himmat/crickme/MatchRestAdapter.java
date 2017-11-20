package himmat.crickme;


import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by Himmat on 20-11-2017.
 */

public class MatchRestAdapter {
    protected final String TAG = getClass().getSimpleName();
    protected Retrofit retrofit;
    protected MatchApi matchApi;
    static final String API_URL ="";


    public  MatchRestAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .build();

        matchApi = retrofit.create(MatchApi.class);
    }

    public  void GetMatchDetails(String title, Callback<MatchResponse> cb){

        matchApi.getMatchDetailsFromApi(title,cb);

    }


    public  void GetMatchList(Callback<MatchResponse> cb){
        matchApi.getMatcheListFromApi(cb);
    }

}
