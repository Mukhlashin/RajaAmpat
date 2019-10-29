package com.example.rajaampat;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    Button btnEditProfile, btnListPengaduan, btnLogout;

    SharedPreferences.Editor editorLogin;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_menu, container, false);

        editorLogin = this.getActivity().getSharedPreferences("login", MODE_PRIVATE).edit();

        btnEditProfile = layout.findViewById(R.id.btn_edit_profile);
        btnListPengaduan = layout.findViewById(R.id.btn_list_pengaduan);
        btnLogout = layout.findViewById(R.id.btn_logout);
        btnListPengaduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReportActivity.class);
                startActivity(intent);
            }
        });
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogOut();
            }
        });
        return layout;
    }

    private void dialogLogOut() {
        AlertDialog.Builder logOut = new AlertDialog.Builder(getActivity());
        logOut.setTitle(R.string.logOut);
        logOut.setMessage(R.string.messageLogout);
        logOut.setPositiveButton("Logout", null);
        logOut.setNegativeButton("Cancel", null);
        logOut.setCancelable(false);
        AlertDialog dialog = logOut.create();
        logOut.show();

        logOut.setPositiveButton(R.string.logOut, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                editorLogin.remove("login");
                editorLogin.apply();

                Intent logOut = new Intent(getActivity(), LoginActivity.class);
                startActivity(logOut);
                getActivity().finish();
            }
        });
        logOut.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
    }
}
