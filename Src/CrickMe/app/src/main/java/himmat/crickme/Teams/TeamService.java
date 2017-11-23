package himmat.crickme.Teams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himmat on 23-11-2017.
 */

public class TeamService {

    static List<Team> teamList = new ArrayList<Team>();

public static List<Team> GetTeamList(){
    if(teamList!=null && teamList.size()==0){
        teamList.add(new Team(1,"Team A","Team AA"));
        teamList.add(new Team(2,"Team B","Team BB"));
        teamList.add(new Team(3,"Team C","Team CC"));
        teamList.add(new Team(4,"Team D","Team DD"));
        teamList.add(new Team(5,"Team E","Team EE"));
    }
    return teamList;
}
}
