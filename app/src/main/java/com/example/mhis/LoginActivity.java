package com.example.mhis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginActivity extends AppCompatActivity
{
    TextInputEditText textInputEditTextUsername,textInputEditTextPassword;
    Button loginButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername = findViewById(R.id.usernameLogin);
        textInputEditTextPassword = findViewById(R.id.passwordLogin);
        loginButton = findViewById(R.id.loginBtn);
        progressBar = findViewById(R.id.progressbar);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username, p_password;
                username = String.valueOf(textInputEditTextUsername.getText());
                p_password = String.valueOf(textInputEditTextPassword.getText());

                if(!username.equals("") && !p_password.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "p_password";
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = p_password;
                            PutData putData = new PutData("http://10.0.11.119/mhis/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intentLogin = new Intent(getApplicationContext(), MenuActivity.class);
                                        Intent intentUserData = new Intent(getApplicationContext(), DoctorActivity.class);
                                        intentUserData.putExtra("username", username);
                                        startActivity(intentLogin);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    Log.i("PutData", result);
                                }
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
