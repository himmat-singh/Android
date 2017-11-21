package himmat.crickme.Players;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import javax.xml.datatype.Duration;

import himmat.crickme.R;

/**
 * Created by Himmat on 21-11-2017.
 */

public class PlayerFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_content, container, false);

        Integer[] positions = PlayerService.GetPlayerPositions();
        Spinner spinnerPosition = (Spinner) view.findViewById(R.id.spinner_position);
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(
                view.getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                positions);

        spinnerPosition.setAdapter(spinnerAdapter);

        String[] roles = PlayerService.GetPlayerRoles();
        Spinner spinnerRole =(Spinner)view.findViewById(R.id.spinner_role);
        ArrayAdapter<String> spinnerRoleAdapter = new ArrayAdapter<String>(
                view.getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                roles
        );
        spinnerRole.setAdapter(spinnerRoleAdapter);

        Button btnSave = (Button)view.findViewById(R.id.btn_player_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(),"Saving player data...", Toast.LENGTH_SHORT);
                toast.show();

                //TODO: Save player details

                //TODO: After details saved, load player list
            }
        });


        Button btnReset = (Button)view.findViewById(R.id.btn_palyer_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Resetting player details",Toast.LENGTH_SHORT).show();

                //TODO: Reset player details
            }
        });


        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog= super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
