package himmat.crickme.Players;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import himmat.crickme.R;

/**
 * Created by Himmat on 17-11-2017.
 */

public class PlayerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.player_list_content,container,false);

        String[] players = new String[]{
                "Player 1",
                "Player 2",
                "Player 3",
                "Player 4",
                "Player 5"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                players
        );

        ListView lv = (ListView)view.findViewById(R.id.lv_players);
        lv.setAdapter(adapter);

        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.nav_player);
    }
}
