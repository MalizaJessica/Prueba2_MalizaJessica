package app004.flagquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

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
    }
}
