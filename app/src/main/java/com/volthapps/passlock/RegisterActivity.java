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

public class RegisterActivity extends AppCompatActivity {

    Button registerbtn;
    EditText txtedit1;
    EditText txtedit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        registerbtn = findViewById(R.id.registerButton);
        txtedit1 = findViewById(R.id.txtedit1);
        txtedit2 = findViewById(R.id.txtedit2);
        final SharedPreferences preferencias = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtedit1.getText().toString().equals(txtedit2.getText().toString())){
                    txtedit1.setBackgroundResource(R.drawable.input_box);
                    txtedit2.setBackgroundResource(R.drawable.input_box);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("password", txtedit1.getText().toString());
                    editor.commit();
                    Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    txtedit1.setBackgroundResource(R.drawable.input_text_error);
                    txtedit2.setBackgroundResource(R.drawable.input_text_error);
                    Toast test = Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT);
                    test.show();
                }
            }
        });
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }

}
