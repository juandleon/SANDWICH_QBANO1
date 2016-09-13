package com.example.juand.sandwichqbano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class logginActivity extends AppCompatActivity {

    EditText usuario,contra;
    TextView error2;
    int b=0;
    Button ingresar,registro;
    String usernew,correo,paswordnew1,mensa2,mensaje2,dusuario,pasword;
    boolean comprobar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        usuario=(EditText) findViewById(R.id.usuario);
        error2=(TextView) findViewById(R.id.error2);
        contra=(EditText) findViewById(R.id.contra);
        ingresar=(Button) findViewById(R.id.ingresar);
        registro=(Button) findViewById(R.id.registro);


        comprobar=true;
        mensaje2="";
        mensa2="";
        error2.setText("");

        ingresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(usuario.getText().toString().isEmpty()){
                    comprobar=false;
                    mensa2="*Falta  usuario \n";
                    mensaje2=""+mensa2+"";
                }
                if(contra.getText().toString().isEmpty()){
                    comprobar=false;
                    mensa2="*Falta  contraseña \n";
                    mensaje2=mensaje2+""+mensa2+"";
                }
                dusuario=usuario.getText().toString();
                if(dusuario.equals(usernew)){
                    comprobar=true;
                }else{
                    mensaje2=mensa2+"usuario incorrecto \n";
                    comprobar=false;
                }


                pasword=contra.getText().toString();
                if(pasword.equals(paswordnew1)){
                    comprobar=true;
                }else{
                    mensaje2=mensa2+"contraseña incorrecta \n";
                    comprobar=false;
                }
                error2.setText(mensaje2);
                if (comprobar==true){
                    Intent d =new Intent().setClass(logginActivity.this, MainActivity.class);
                    d.putExtra("usuario",usuario.getText().toString());
                    d.putExtra("correo",correo.toString());
                    startActivityForResult(d,123);
                    finish();

                }
                comprobar=true;
            }
        });


        registro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent f =new Intent().setClass(logginActivity.this, ResgistroActivity.class);
                startActivityForResult(f,123);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            String t=data.getExtras().getString("usuario");
            usernew=data.getExtras().getString("usernew");
            correo=data.getExtras().getString("correo");
            paswordnew1=data.getExtras().getString("paswordnew1");

        }
    }
}
