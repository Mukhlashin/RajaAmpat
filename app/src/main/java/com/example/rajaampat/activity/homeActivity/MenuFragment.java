package com.example.rajaampat.activity.homeActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.rajaampat.activity.logRegActivity.LoginActivity;
import com.example.rajaampat.R;
import com.example.rajaampat.activity.editProfileActivity.EditProfileActivity;
import com.example.rajaampat.activity.reportActivity.ReportActivity;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    Button btnEditProfile, btnListPengaduan, btnLogout;

    SharedPreferences.Editor editorLogin;
    SharedPreferences.Editor editorUser1;
    SharedPreferences.Editor editorUser2;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_menu, container, false);

        editorLogin = this.getActivity().getSharedPreferences("login", MODE_PRIVATE).edit();
        editorUser1 = this.getActivity().getSharedPreferences("userInfo", MODE_PRIVATE).edit();
        editorUser2 = this.getActivity().getSharedPreferences("com.example.rajaampat_preferences", MODE_PRIVATE).edit();

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
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(R.string.logOut);
        dialog.setMessage(R.string.messageLogout);
        dialog.setPositiveButton("Logout", null);
        dialog.setNegativeButton("Cancel", null);
        dialog.setCancelable(false);

        dialog.setPositiveButton(R.string.logOut, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "Berhasil Logout", Toast.LENGTH_SHORT).show();
                editorLogin.remove("login");
                editorUser1.remove("picture");
                editorLogin.apply();
                editorUser1.apply();
                Intent logOut = new Intent(getActivity(), LoginActivity.class);
                startActivity(logOut);
                getActivity().finish();
            }
        });
        dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.create();
        }
        dialog.show();
    }
}
