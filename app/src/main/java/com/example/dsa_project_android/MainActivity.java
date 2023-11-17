package com.example.dsa_project_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Variables
    Button logIn;
    Button signIn;
    View dialogView;
    boolean popUpType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logIn = findViewById(R.id.logIn);
        signIn = findViewById(R.id.signIn);

        LogIn();
        SingIn();
    }

    //Registro
    public void SingIn() {
        //SingIn button
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUpType = true;
                showPopup();
            }
        });
    }

    //Iniciar sesion
    public void LogIn() {
        //LogIn button
        // Configura el OnClickListener
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUpType = false;
                showPopup();
            }
        });
    }

    private void showPopup() {
        // Crea un constructor de AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (popUpType == true) {
            //Sing Up
            // Inflar el diseño del cuadro de diálogo personalizado
            dialogView = getLayoutInflater().inflate(R.layout.custom_sign_up_dialog, null);

            // Obtener referencias a los EditText en el diseño personalizado
            EditText usernameEditText = dialogView.findViewById(R.id.usernameEditText);
            EditText passwordEditText = dialogView.findViewById(R.id.passwordEditText);

            // Establece el título y el mensaje del cuadro de diálogo
            builder.setTitle("Sign Up");
            builder.setView(dialogView);
            //builder.setMessage("Este es un mensaje de sing up");

            // Agrega un botón "Aceptar" al cuadro de diálogo
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Obtener los valores de los campos de entrada
                    String username = usernameEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    // Puedes realizar acciones con el nombre de usuario y la contraseña aquí
                    // Por ejemplo, puedes mostrarlos en el LogCat
                    Log.d("SignUp", "Username: " + username + ", Password: " + password);

                    // Cierra el cuadro de diálogo
                    dialog.dismiss();
                }
            });
        } else {
            // Establece el título y el mensaje del cuadro de diálogo
            builder.setTitle("Log in")
                    .setMessage("Este es un mensaje de log in.");
            // Agrega un botón "Aceptar" al cuadro de diálogo
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Acciones a realizar cuando se hace clic en "Aceptar"
                    // Por ejemplo, cierra el cuadro de diálogo
                    dialog.dismiss();
                }
            });
            // Crea y muestra el cuadro de diálogo
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }
}