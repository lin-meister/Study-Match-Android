package com.example.m.hoth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudyGroups extends AppCompatActivity {

    public void goToPiedPiper(View view) {
        Intent intent = new Intent(this, PiedPiper.class);
        startActivity(intent);
    }

    public void goToBikiniBottomSquad(View view) {
        Intent intent = new Intent(this, BikiniBottomSquad.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_groups);
    }
}
