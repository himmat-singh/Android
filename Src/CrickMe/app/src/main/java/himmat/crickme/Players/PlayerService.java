package himmat.crickme.Players;

import android.support.annotation.NonNull;

import java.util.ArrayList;



/**
 * Created by Himmat on 21-11-2017.
 */

public class PlayerService {

   ArrayList<Player> playerList = null;

    public PlayerService() {
        playerList = new ArrayList<Player>();
    }

    public ArrayList<Player> Add(Player player) {
        if (player != null) {
            //TODO: Handle duplicate player
            player.Id = playerList.size() + 1;
            playerList.add(player);
        }
        return playerList;
    }

    public Player Edit(int id){

        for(Player player: playerList)
            if(player.Id == id)
                return player;

        return  null;
    }

    public ArrayList<Player> Update(int id,Player player){
        if(id==player.Id){
            Player p = Edit(id);

            p.NickName = player.NickName;
            p.FirstName = player.FirstName;
            p.LastName = player.LastName;
            p.FullName = player.FullName;
            p.Description = player.Description;
            p.Role = player.Role;
            p.Position = player.Position;
            p.IsActive = player.IsActive;

        }
        return playerList;
    }

    public ArrayList<Player> Remove(int id) {
        Player player = Edit(id);
        if (player != null)
            playerList.remove(player);
        return playerList;
    }

    public static Integer[] GetPlayerPositions(){
        return new Integer[]{1,2,3,4,5,6,7,8,9,10};
    }
}
