package himmat.crickme.Matches;

import java.util.Date;

/**
 * Created by Himmat on 23-11-2017.
 */

public class Match {
    public int Id;
    public String Title;
    public String Series;
    public Date ScheduleDate;
    public String Team1Id;
    public String Team2Id;
    public String Description;

    public Match(int id, String title, String series, Date scheduleDate, String team1Id, String team2Id, String description) {
        Id = id;
        Title = title;
        Series = series;
        ScheduleDate = scheduleDate;
        Team1Id = team1Id;
        Team2Id = team2Id;
        Description = description;
    }
}
