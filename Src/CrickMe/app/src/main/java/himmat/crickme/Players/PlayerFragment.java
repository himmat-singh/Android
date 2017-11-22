package himmat.crickme.Players;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.Switch;
import android.widget.TextView;
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

        final TextView tv_firstname = (TextView) view.findViewById(R.id.et_first_name);
        final TextView tv_lastname = (TextView) view.findViewById(R.id.et_last_name);
        final TextView tv_fullname = (TextView) view.findViewById(R.id.et_full_name);
        final TextView tv_nickname = (TextView) view.findViewById(R.id.et_nick_name);
        final Switch sw_active = (Switch) view.findViewById(R.id.sw_active);

        Integer[] positions = PlayerService.GetPlayerPositions();
        final Spinner spinnerPosition = (Spinner) view.findViewById(R.id.spinner_position);
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(
                view.getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                positions);

        spinnerPosition.setAdapter(spinnerAdapter);

        String[] roles = PlayerService.GetPlayerRoles();
        final Spinner spinnerRole = (Spinner) view.findViewById(R.id.spinner_role);
        ArrayAdapter<String> spinnerRoleAdapter = new ArrayAdapter<String>(
                view.getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                roles
        );
        spinnerRole.setAdapter(spinnerRoleAdapter);

        Button btnSave = (Button) view.findViewById(R.id.btn_player_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Saving player data...", Toast.LENGTH_SHORT);
                toast.show();

                //TODO: Save player details
                Player player = new Player(
                        0,
                        tv_nickname.getText().toString(),
                        tv_firstname.getText().toString(),
                        tv_lastname.getText().toString(),
                        tv_fullname.getText().toString(),
                        "",
                        spinnerRole.getSelectedItem().toString(),
                        spinnerPosition.getSelectedItem().toString(),
                        String.valueOf(sw_active.isChecked())
                );

                PlayerService.Add(player);


                //TODO: After details saved, load player list
                Fragment fragment = getFragmentManager().findFragmentByTag("Player");
                if (fragment != null) {
                    DialogFragment dialogFragment = (DialogFragment) fragment;
                    dialogFragment.dismiss();
                }



                //TODO: Below written code for calling fragment from another fragment
                Fragment fragmentPlayerList = new PlayerListFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main,fragmentPlayerList);
                fragmentTransaction.commit();


            }
        });


        Button btnReset = (Button) view.findViewById(R.id.btn_palyer_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Resetting player details", Toast.LENGTH_SHORT).show();

                //TODO: Reset player details
                tv_nickname.setText("");
                tv_firstname.setText("");
                tv_lastname.setText("");
                tv_fullname.setText("");
                spinnerPosition.setSelection(0);
                spinnerRole.setSelection(0);
                sw_active.setChecked(false);

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
