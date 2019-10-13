package com.example.gift;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ContentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

    }

    public void addInfo(View view) {
        startActivity(new Intent(this, AddActivity.class));
    }

    public void deleteInfo(View view) {
        startActivity(new Intent(this, DeleteActivity.class));
    }

    public void viewInfo(View view) {
        startActivity(new Intent(this, ViewActivity.class));
    }

    public void editInfo(View view) {
        startActivity(new Intent(this, EditActivity.class));
    }
}
