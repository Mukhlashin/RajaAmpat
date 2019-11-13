package com.example.rajaampat.reportActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rajaampat.ContactActivity;
import com.example.rajaampat.R;

public class ReportActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, ReportInterface.View {

    ImageButton btnBack, btnContact, btnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        btnBack = findViewById(R.id.btn_back);
        btnContact = findViewById(R.id.btn_contact);
        btnMore = findViewById(R.id.btn_more);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToContact();
            }

            private void goToContact() {
                Intent goToContact = new Intent(ReportActivity.this,  ContactActivity.class);
                startActivity(goToContact);
            }
        });
    }

    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.main_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.tester :
                Toast.makeText(this, "Tester Berhasil", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tester2 :
                Toast.makeText(this, "Tester2 Berhasil", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tester3 :
                Toast.makeText(this, "Tester3 Berhasil", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    @Override
    public void setDataReport() {

    }

    @Override
    public void addNewReport() {

    }
}