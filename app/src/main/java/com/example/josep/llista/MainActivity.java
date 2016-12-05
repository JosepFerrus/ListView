package com.example.josep.llista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String nombre_seleccionado = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l = (ListView) findViewById(R.id.Lista);

        //Creamos el vector con los nombres (objetos que pintar)
        ArrayList<String> mis_nombres = new ArrayList<>();
        mis_nombres.add("Victor");
        mis_nombres.add("Silvia");
        mis_nombres.add("Manolo");
        mis_nombres.add("Carlos");
        mis_nombres.add("Ana");


        //Creamos un array simple (YA QUE LA LISTA CON 1 ITEM ESTA HECHA EN ANDROID)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mis_nombres);

        //SETEAMOS EL ADAPTER CONSTRUIDO A LA LISTA
        l.setAdapter(adapter);

        registerForContextMenu(l);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater infl = getMenuInflater();
        infl.inflate(R.menu.mimenu, menu);

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        this.nombre_seleccionado = ((TextView) info.targetView).getText().toString();

        menu.setHeaderTitle(nombre_seleccionado);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.Mostrar:
                Toast.makeText(getApplicationContext(), this.nombre_seleccionado + ": Opcion Mostrar", Toast.LENGTH_LONG).show();
                break;
            case R.id.Eliminar:
                Toast.makeText(getApplicationContext(), this.nombre_seleccionado + ": Opcion Eliminar", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


}
