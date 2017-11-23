package himmat.crickme.Matches;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Created by Himmat on 23-11-2017.
 */

public class MatchService {

    static List<Match> matchList = new ArrayList<Match>();

    public static List<Match> Add(Match match){
        if(match!=null){
            //TODO: Handle duplicate match
            match.Id = matchList.size()+1;
            matchList.add(match);
        }
        return matchList;
    }

    public static Match Edit(int id){
        for(Match match:matchList)
            if(match.Id==id)
                return match;

        return null;
    }

    public static List<Match> Update(int id,Match m){
        if(id==m.Id){
            Match match= Edit(id);

            match.Title = m.Title;
            match.Series = m.Series;
            match.ScheduleDate = m.ScheduleDate;
            match.Team1Id = m.Team1Id;
            match.Team2Id = m.Team2Id;
            match.Description = m.Description;
        }

        return matchList;
    }

    public static List<Match> Remove(int id){
        if(id>0){
            Match match = Edit(id);
            matchList.remove(match);
        }

        return matchList;
    }


    public static List<Match> GetMatchList(){
        if(matchList!=null && matchList.size()==0){
            matchList.add(new Match(1,"Match 1","Series 1",new Date(),0,0,"Team A vs Team B"));
            matchList.add(new Match(2,"Match 2","Series 2",new Date(),0,0,"Team AA vs Team BB"));
            matchList.add(new Match(3,"Match 3","Series 3",new Date(),0,0,"Team AAA vs Team BBB"));
            matchList.add(new Match(4,"Match 4","Series 4",new Date(),0,0,"Team AAAA vs Team BBBB"));
            matchList.add(new Match(5,"Match 5","Series 5",new Date(),0,0,"Team AAAAA vs Team BBBBB"));
        }
        return matchList;
    }
}
