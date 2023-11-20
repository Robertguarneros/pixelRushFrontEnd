package com.example.dsa_project_android;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dsa_project_android.Manager.Manager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ManagerImpl extends AppCompatActivity {
    private static String URL = "http://10.0.2.2:8080/dsaApp/pixelRush/";

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

        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();
        String name = nameTV.getText().toString();
        String surname = surnameTV.getText().toString();
        String mail = mailTV.getText().toString();
        int age = Integer.parseInt(ageTV.getText().toString());

        //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        //Initialize retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Create instance
        Manager manager = retrofit.create(Manager.class);

        //Call register method with all the parameters
        Call<Void> callRegister= manager.register(username,password,name,surname,mail,age);

        callRegister.enqueue(new Callback<Void>() {
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


}
