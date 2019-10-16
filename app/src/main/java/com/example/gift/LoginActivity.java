package com.example.gift;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText EditUser, EditPass;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditUser = findViewById(R.id.editUser);
        EditPass = findViewById(R.id.editPass);
        builder = new AlertDialog.Builder(this);

        EditPass.setTransformationMethod(new PasswordTransformationMethod());
    }

    public void signIn(View view) {
        Log.d("sha", "Its Working...");
        String username = EditUser.getText().toString();
        String password = EditPass.getText().toString();
        if (username.equals("") || password.equals("")) {
            builder.setTitle("Something Went Wrong...");
            builder.setMessage("Please Fill All The Fields...");
            displayAlerts("input_error");
        } else if (username.equals("Username") && password.equals("Password")) {
            builder.setTitle("Login Information :");
            builder.setMessage("Login Successful Welcome " + username);
            displayAlerts("Login Success...");

        } else {
            builder.setTitle("Login Information :");
            builder.setMessage("Login Failed,Please Try Again Later...");
            displayAlerts("Login Failed...");
        }

    }

    public void displayAlerts(final String message) {
        //Code For Alert Dialog
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (message.equals("input_error")) {
                    EditUser.setText("");
                    EditPass.setText("");
                }
                if (message.equals("Login Success...")) {
                    EditUser.setText("");
                    EditPass.setText("");
                    startActivity(new Intent(LoginActivity.this, ContentActivity.class));
                }
                if (message.equals("Login Failed...")) {
                    EditUser.setText("");
                    EditPass.setText("");
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
