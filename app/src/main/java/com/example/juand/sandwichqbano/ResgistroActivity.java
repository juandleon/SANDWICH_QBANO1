package com.example.juand.sandwichqbano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResgistroActivity extends AppCompatActivity {


    EditText usernew,paswordnew1,paswordnew2,correo;
    Button aceptar,cancelar;
    TextView error;
    String mensa,mensaje,vpasword,bpasword;
    boolean verifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);
        error=(TextView)findViewById(R.id.error);
        usernew=(EditText) findViewById(R.id.usernew);
        paswordnew1=(EditText) findViewById(R.id.paswordnew1);
        correo=(EditText) findViewById(R.id.correo);
        paswordnew2=(EditText) findViewById(R.id.paswordnew2);
        aceptar=(Button) findViewById(R.id.aceptar);
        cancelar=(Button) findViewById(R.id.cancelar);

        aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                error.setText("");
                mensa="";
                verifi=true;
                if(usernew.getText().toString().isEmpty()){
                    verifi=false;
                    mensa="*Falta  usuario \n";
                    mensaje=""+mensa+"";
                }
                if(paswordnew1.getText().toString().isEmpty()){
                    verifi=false;
                    mensa="*Falta  contraseña \n";
                    mensaje=""+mensa+"";
                }
                if(paswordnew2.getText().toString().isEmpty()){
                    verifi=false;
                    mensa="*Falta  repetir contraseña \n";
                    mensaje=""+mensa+"";
                }
                if(correo.getText().toString().isEmpty()){
                    verifi=false;
                    mensa="*Falta correo \n";
                    mensaje=""+mensa+"";
                }

                vpasword=paswordnew2.getText().toString();
                bpasword=paswordnew1.getText().toString();
                if(bpasword.equals(vpasword)){

                }else{
                    mensaje=mensa+"*Las Contraseñas No Coinciden \n";
                    verifi=false;
                }
                error.setText(mensaje);
                if (verifi==true){
                    Intent f=getIntent();
                    f.putExtra("usernew",usernew.getText().toString());
                    f.putExtra("correo",correo.getText().toString());
                    f.putExtra("paswordnew1",paswordnew1.getText().toString());
                    setResult(RESULT_OK,f);
                    finish();
                }



            }
        });

        cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent f=getIntent();
                f.putExtra("usuario",usernew.getText().toString());
                setResult(RESULT_OK,f);
                finish();
            }
        });
    }
}
