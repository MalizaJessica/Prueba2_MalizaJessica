package app004.flagquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity_MJ extends AppCompatActivity {
    EditText user;
    EditText clave;
    Button button_aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        user = (EditText) findViewById(R.id.user);
        clave = (EditText) findViewById(R.id.clave);
        button_aceptar = (Button) findViewById(R.id.button_aceptar);
        //
        button_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals("user") && clave.getText().toString().equals("123")) {
                    //Intent intent = new Intent(MainActivity.this, Principal.class);
                    //startActivity(intent);
                    startActivity(new Intent(LoginActivity_MJ.this, Principal_MJ.class));
                    Toast.makeText(LoginActivity_MJ.this, "Is OK!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(LoginActivity_MJ.this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    //

    //metodo de siguiente en aceptar, para que se me visualise la siguiente pantalla
    public  void aceptar(View view){
        Intent aceptar = new Intent(this,MainActivity_MJ.class);
        startActivity(aceptar);
    }
}
