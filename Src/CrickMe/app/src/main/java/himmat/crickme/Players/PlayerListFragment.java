package himmat.crickme.Players;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
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

public class PlayerListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.player_list_content,container,false);

        /*
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
        */

        List<Player> playerList = PlayerService.GetPlayerList();

        PlayerListAdapter adapter = new PlayerListAdapter(getContext(),R.layout.player_list_item,playerList);

        ListView lv = (ListView)view.findViewById(R.id.lv_players);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemView, int i, long l) {
                TextView tv_id = (TextView)itemView.findViewById(R.id.tv_player_id);
                Bundle args = new Bundle();
                args.putInt("Id",Integer.valueOf(tv_id.getText().toString()));
                DialogFragment playerFragment = new PlayerFragment();
                playerFragment.setArguments(args);
                playerFragment.show(getFragmentManager(),"Player");
            }
        });

        Button btnPlayer = (Button)view.findViewById(R.id.btn_new_player);
        btnPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment playerFragment = new PlayerFragment();
                playerFragment.show(getFragmentManager(),"Player");
            }
        });

        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.nav_player);
    }
}
