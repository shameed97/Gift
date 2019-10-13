package com.example.gift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText editTextId,editTextFam,editTextName,editTextCity,editTextPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editTextId=findViewById(R.id.upId);
        editTextFam=findViewById(R.id.upFamily);
        editTextName=findViewById(R.id.upName);
        editTextCity=findViewById(R.id.upCity);
        editTextPresent=findViewById(R.id.upPresent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void editDetail(View view) {

        String id=editTextId.getText().toString();
        String fam_name=editTextFam.getText().toString();
        String name=editTextName.getText().toString();
        String city=editTextCity.getText().toString();
        String present=editTextPresent.getText().toString();
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("update_info",id,fam_name,name,city,present);
        editTextId.setText("");
        editTextFam.setText("");
        editTextName.setText("");
        editTextCity.setText("");
        editTextPresent.setText("");

    }
}
