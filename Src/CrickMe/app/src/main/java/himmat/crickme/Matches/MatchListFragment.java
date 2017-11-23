package himmat.crickme.Matches;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import himmat.crickme.R;

/**
 * Created by Himmat on 17-11-2017.
 */

public class MatchListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.match_list_content,container,false);

        /*
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
        */

        List<Match> matchList = MatchService.GetMatchList();
        MatchListAdapter adapter = new MatchListAdapter(getContext(),R.layout.match_list_item,matchList);

        ListView lv = (ListView)view.findViewById(R.id.lv_matches);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemView, int i, long l) {
                DialogFragment matchFragment = new MatchFragment();
                TextView tv_id = (TextView)itemView.findViewById(R.id.et_match_id);
                Bundle args = new Bundle();
                args.putInt("Id",Integer.valueOf(tv_id.getText().toString()));
                matchFragment.setArguments(args);
                matchFragment.show(getFragmentManager(),"Match");
            }
        });


        Button btnMatch = (Button)view.findViewById(R.id.btn_new_match);
        btnMatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DialogFragment matchFragment = new MatchFragment();
                matchFragment.show(getFragmentManager(),"Match");
            }
        });


        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.nav_match);
    }
}
