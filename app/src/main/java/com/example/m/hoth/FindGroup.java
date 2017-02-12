package com.example.m.hoth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static com.example.m.hoth.R.id.classNumberMenu;
import static com.example.m.hoth.R.id.subjectMenu;

public class FindGroup extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner subjectMenu, classNumberMenu;
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        subjectMenu = (Spinner) findViewById(R.id.subjectMenu);
        classNumberMenu = (Spinner) findViewById(R.id.classNumberMenu);
        String subject = String.valueOf(subjectMenu.getSelectedItem());
        if (subject.contentEquals("Computer Science")) {
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.cs_courses_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            classNumberMenu.setAdapter(adapter);
        }
        else {
            classNumberMenu.setAdapter(new ArrayAdapter<String>(FindGroup.this,android.R.layout.simple_dropdown_item_1line));
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        // Clear the menu
        classNumberMenu.setAdapter(new ArrayAdapter<String>(FindGroup.this,android.R.layout.simple_dropdown_item_1line));
    }

    public void searchResults(View view) {
        Intent intent = new Intent(this, StudyGroups.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group);

        subjectMenu = (Spinner) findViewById(R.id.subjectMenu);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        subjectMenu.setAdapter(adapter);
        // Set subject menu to listen to selection
        subjectMenu.setOnItemSelectedListener(this);
    }
}
