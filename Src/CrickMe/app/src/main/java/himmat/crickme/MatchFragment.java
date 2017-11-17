package himmat.crickme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Himmat on 17-11-2017.
 */

public class MatchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.match_list_content,container,false);

        String[] matches = new String[]{
                "Match 1: Team 1 Vs Team 2",
                "Match 2: Team 1 Vs Team 2",
                "Match 3: Team 1 Vs Team 2",
                "Match 4: Team 1 Vs Team 2"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                matches
        );

        ListView lv = (ListView)view.findViewById(R.id.lv_matches);
        lv.setAdapter(adapter);


        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.nav_match);
    }
}
