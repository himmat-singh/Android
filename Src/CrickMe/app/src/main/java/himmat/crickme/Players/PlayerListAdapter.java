package himmat.crickme.Players;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import himmat.crickme.R;

/**
 * Created by Himmat on 22-11-2017.
 */

public class PlayerListAdapter extends ArrayAdapter<Player> {

    List<Player> playerList;
    Context context;
    int resource;

    public PlayerListAdapter(@NonNull Context context, int resource, List<Player> playerList) {
        super(context, resource,playerList);
        this.playerList = playerList;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(resource,null,false);

        if(playerList!=null) {
            TextView tv_full_name = (TextView) view.findViewById(R.id.tv_player_full_name);
            TextView tv_description = (TextView) view.findViewById(R.id.tv_player_description);
            TextView tv_id = (TextView)view.findViewById(R.id.tv_player_id);

            Player player = playerList.get(position);

            tv_full_name.setText(player.FullName);
            tv_description.setText("Playing as " + String.valueOf(player.Role + " at position " + String.valueOf(player.Position)));
            tv_id.setText(String.valueOf( player.Id));
        }

        return  view;

    }
}
