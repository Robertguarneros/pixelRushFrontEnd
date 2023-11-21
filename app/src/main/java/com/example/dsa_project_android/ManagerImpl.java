package com.example.dsa_project_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dsa_project_android.Manager.LoginCredentials;
import com.example.dsa_project_android.Manager.Manager;
import com.example.dsa_project_android.Manager.RegisterCredentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ManagerImpl extends AppCompatActivity {
    private static String URL = "http://localhost:8080/dsaApp/pixelRush/";
    Manager manager;

    @Override
    public void onCreate(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.nose);

        TextView usernameTV = findViewById(R.id.username);
        TextView passwordTV = findViewById(R.id.password);
        TextView nameTV = findViewById(R.id.name);
        TextView surnameTV = findViewById(R.id.surname);
        TextView mailTV = findViewById(R.id.mail);
        TextView ageTV = findViewById(R.id.age);

        Button registerBT = findViewById(R.id.register);
        Button loginBT = findViewById(R.id.login);

        //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        //Initialize retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Create instance
        manager = retrofit.create(Manager.class);

        registerBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTV.getText().toString();
                String password = passwordTV.getText().toString();
                String name = nameTV.getText().toString();
                String surname = surnameTV.getText().toString();
                String mail = mailTV.getText().toString();
                int age = Integer.parseInt(ageTV.getText().toString());

                RegisterCredentials registerCredentials = new RegisterCredentials(username,password,name,surname,mail,age);

                performRegistration(registerCredentials);
            }
        });

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTV.getText().toString();
                String password = passwordTV.getText().toString();

                LoginCredentials loginCredentials = new LoginCredentials(username,password);

                performLogin(loginCredentials);
            }
        });
    }

    private void performRegistration(RegisterCredentials credentials){
        Call<Void> call = manager.register(credentials);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ManagerImpl.this,"User registered successfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ManagerImpl.this,"Error: " + response.code() + " " + response.message(),Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ManagerImpl.this,"Error: " +t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void performLogin(LoginCredentials credentials){

        Call<Void> call = manager.login(credentials);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ManagerImpl.this,"User logged successfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ManagerImpl.this,"Error: " + response.code() + " " + response.message(),Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
