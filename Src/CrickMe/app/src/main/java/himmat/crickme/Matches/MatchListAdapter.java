package himmat.crickme.Matches;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import himmat.crickme.R;

/**
 * Created by Himmat on 23-11-2017.
 */

public class MatchListAdapter extends ArrayAdapter<Match> {
    Context context;
    int resource;
    List<Match> matchList;

    public MatchListAdapter(@NonNull Context context, int resource, @NonNull List<Match> matchList) {
        super(context, resource, matchList);
        this.context = context;
        this.resource = resource;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(resource,null,false);

        if(matchList!=null) {

            final TextView tv_id = (TextView) view.findViewById(R.id.et_match_id);
            final TextView tv_title = (TextView) view.findViewById(R.id.tv_match_title);
            final TextView tv_description = (TextView) view.findViewById(R.id.tv_match_description);

            Match match = matchList.get(position);

            tv_id.setText(String.valueOf(match.Id));
            tv_title.setText(match.Title);
            tv_description.setText(match.Description);
        }

        return  view;
    }
}
