package com.example.juand.sandwichqbano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MiperfilActivity extends AppCompatActivity {

    TextView nomb;

String nombre,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miperfil);
        nomb=(TextView) findViewById(R.id.nomb);
        Bundle d =getIntent().getExtras();
       nombre=d.getString("nombre");
        correo=d.getString("correo");
        nomb.setText(nombre+"\n correo: "+correo);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.mPrincipal:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
