package com.volthapps.passlock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText txtedit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences preferencias = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        if(preferencias.getString("password","").equals("")){
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        }
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.loginButton);
        txtedit1 = findViewById(R.id.editText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtedit1.getText().toString().equals(preferencias.getString("password","*/*/GT*454/*/2dfs34A*/*+554+dssdfFSf*/*54/*/C*dfFDs++GGF*43dfs/*/*454/*+-gfdf-*+"))){
                    txtedit1.setBackgroundResource(R.drawable.input_box);
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    txtedit1.setBackgroundResource(R.drawable.input_text_error);
                    Toast test = Toast.makeText(getApplicationContext(), "La contraseña es errónea", Toast.LENGTH_SHORT);
                    test.show();
                }
            }
        });
    }

    //Esta funcion hace que se cierre la app cuando le das atras en el login activity
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}
