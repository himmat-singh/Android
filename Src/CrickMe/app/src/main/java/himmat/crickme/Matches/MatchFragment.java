package himmat.crickme.Matches;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import himmat.crickme.R;
import himmat.crickme.Teams.Team;
import himmat.crickme.Teams.TeamService;

/**
 * Created by Himmat on 23-11-2017.
 */

public class MatchFragment extends DialogFragment {

    static int matchId;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(getArguments()!=null)
            matchId = getArguments().getInt("Id");
        return dialog;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_content,container,false);

        final TextView tv_id = (TextView)view.findViewById(R.id.et_id);
        final TextView tv_title=(TextView)view.findViewById(R.id.et_title);
        final TextView tv_series=(TextView)view.findViewById(R.id.et_series);
        final TextView tv_schedule_date=(TextView)view.findViewById(R.id.et_schedule_date);
        final Spinner spinner_team1=(Spinner) view.findViewById(R.id.spinner_team1);
        final Spinner spinner_team2=(Spinner) view.findViewById(R.id.spinner_team2);
        final TextView tv_description=(TextView)view.findViewById(R.id.et_description);

        List<Team> teamList = TeamService.GetTeamList();
        String[] teams = new String[teamList.size()];
        int i=0;
        for(Team team : teamList){
            teams[i++]=team.Name;
        }
        ArrayAdapter<String> teamAdapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,teams);
        spinner_team1.setAdapter(teamAdapter);
        spinner_team2.setAdapter(teamAdapter);

        Button btnReset = (Button)view.findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(),"Match details are resetting...",Toast.LENGTH_SHORT);
                toast.show();

                tv_id.setText("0");
                tv_title.setText("");
                tv_series.setText("");
                tv_schedule_date.setText("");
                //spinner_team1.setSelection(0);
                //spinner_team2.setSelection(0);
                tv_description.setText("");
            }
        });

        Button btnSave = (Button)view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(),"Match details are saving...",Toast.LENGTH_SHORT);
                toast.show();

                /*
                Match match = new Match(
                        0
                ,""
                ,""
                ,new Date("12-12-12")
                ,0
                ,0
                ,"");
*/

                //TODO: Save match details

                //TODO: After match details saved, load match list
                Fragment fragment = getFragmentManager().findFragmentByTag("Match");
                if(fragment!=null){
                    DialogFragment dialogFragment = (DialogFragment)fragment;
                    dialogFragment.dismiss();
                }

                //TODO: Below written code for calling a fragment from another fragment
                Fragment fragmentMatchList = new MatchListFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main,fragmentMatchList);
                fragmentTransaction.commit();


            }
        });

        return view;
    }
}
