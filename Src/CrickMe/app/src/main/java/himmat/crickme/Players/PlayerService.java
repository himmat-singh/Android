package himmat.crickme.Players;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Himmat on 21-11-2017.
 */

public class PlayerService {

   static List<Player> playerList = new ArrayList<Player>();


    public static List<Player> Add(Player player) {
        if (player != null) {
            //TODO: Handle duplicate player
            player.Id = playerList.size() + 1;
            playerList.add(player);
        }
        return playerList;
    }

    public static Player Edit(int id){

        for(Player player: playerList)
            if(player.Id == id)
                return player;

        return  null;
    }

    public static List<Player> Update(int id,Player player){
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

    public List<Player> Remove(int id) {
        Player player = Edit(id);
        if (player != null)
            playerList.remove(player);
        return playerList;
    }



    public static Integer[] GetPlayerPositions(){
        return new Integer[]{1,2,3,4,5,6,7,8,9,10};
    }

    public static String[] GetPlayerRoles(){
        return new String[]{"All Rounder","Batsman","Bowler"};
    }

    public static List<Player> GetPlayerList() {

        if (playerList != null && playerList.size()==0) {
            playerList.add(new Player(1, "", "Player 1 FN", "LN", "Player 1 FN LN", "", "Batsman", "1", "Yes"));
            playerList.add(new Player(2, "", "Player 2 FN", "LN", "Player 2 FN LN", "", "Batsman", "2", "Yes"));
            playerList.add(new Player(3, "", "Player 3 FN", "LN", "Player 3 FN LN", "", "Batsman", "3", "Yes"));
            playerList.add(new Player(4, "", "Player 4 FN", "LN", "Player 4 FN LN", "", "Batsman", "4", "Yes"));
            playerList.add(new Player(5, "", "Player 5 FN", "LN", "Player 5 FN LN", "", "Batsman", "5", "Yes"));
            playerList.add(new Player(6, "", "Player 6 FN", "LN", "Player 6 FN LN", "", "Batsman", "6", "Yes"));
        }
        return playerList;
    }
}
