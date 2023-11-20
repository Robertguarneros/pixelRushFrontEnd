package dsa.upc.edu.dsa_project_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import dsa.upc.edu.listapp.R;

public class MainActivity extends AppCompatActivity {
    //Variables
    Button logIn;
    Button signIn;
    View dialogView;
    boolean popUpType;
    private AlertDialog alertDialog;

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
        ImageView button_close;

        if (popUpType == true) {
            //Sing Up
            // Inflar el diseño del cuadro de diálogo personalizado
            dialogView = getLayoutInflater().inflate(R.layout.custom_sign_up_dialog, null);
            alertDialog= builder.create();
            setContentView(R.layout.custom_sign_up_dialog);
            // Obtener referencias a los EditText en el diseño personalizado
            EditText usernameEditText = dialogView.findViewById(R.id.usernameEditText);
            EditText passwordEditText = dialogView.findViewById(R.id.passwordEditText);

            // Establece el título y el mensaje del cuadro de diálogo
            builder.setTitle("Sign Up");
            builder.setView(dialogView);
            //builder.setMessage("Este es un mensaje de sing up");

            // Agrega el evento click al botón close dentro del cuadro de diálogo
            Button buttonClose = dialogView.findViewById(R.id.botoncerrar1);
            buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    // Inicia la actividad principal
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

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
            //Sing Up
            // Inflar el diseño del cuadro de diálogo personalizado
            dialogView = getLayoutInflater().inflate(R.layout.custom_log_in_dialog, null);
            setContentView(R.layout.custom_log_in_dialog);
            // Obtener referencias a los EditText en el diseño personalizado
            EditText usernameEditText = dialogView.findViewById(R.id.usernameEditText);
            EditText passwordEditText = dialogView.findViewById(R.id.passwordEditText);

            // Establece el título y el mensaje del cuadro de diálogo
            builder.setTitle("Sign Up");
            builder.setView(dialogView);
            //builder.setMessage("Este es un mensaje de sing up");

            // Agrega el evento click al botón close dentro del cuadro de diálogo
            Button buttonClose = dialogView.findViewById(R.id.botoncerrar);
            buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Cierra el cuadro de diálogo
                    alertDialog.dismiss();
                }
            });

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

        }

    }
    public void closeButton(){
        ImageView buttonClose = dialogView.findViewById(R.id.botoncerrar);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo
               // alertDialog.dismiss();

                // Cierra la actividad actual
                finish();

                // Inicia la actividad principal
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
