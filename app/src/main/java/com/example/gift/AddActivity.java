package com.example.gift;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddActivity extends AppCompatActivity {

    private EditText editFam, editName, editCity, editPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editFam = findViewById(R.id.editFamily);
        editName = findViewById(R.id.editName);
        editCity = findViewById(R.id.editCity);
        editPresent = findViewById(R.id.editPresent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void addDetail(View view) {

        String F_name = editFam.getText().toString();
        String name = editName.getText().toString();
        String city = editCity.getText().toString();
        String present = editPresent.getText().toString();
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", name, F_name, city, present);
        editName.setText("");
        editFam.setText("");
        editCity.setText("");
        editPresent.setText("");
    }
}
