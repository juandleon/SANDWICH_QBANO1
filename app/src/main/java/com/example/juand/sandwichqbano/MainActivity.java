package com.example.juand.sandwichqbano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    String nombre,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle d =getIntent().getExtras();
        nombre=d.getString("usuario");
         correo=d.getString("correo");

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
            case R.id.MiPerfil:
                Intent intent = new Intent (this,MiperfilActivity.class);
                intent.putExtra("nombre",nombre.toString());
                intent.putExtra("correo",correo.toString());
                startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
