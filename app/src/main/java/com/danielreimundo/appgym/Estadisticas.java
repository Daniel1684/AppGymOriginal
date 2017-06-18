package com.danielreimundo.appgym;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import com.danielreimundo.appgym.Adapter.GymAdapter;
import com.danielreimundo.appgym.bd.DatabaseManager;

public class Estadisticas extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DatabaseManager db;
    private Spinner spinner;
    private GymAdapter gymAdapter;
    private ListView listView;
    public Button borrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Listas");
        setContentView(R.layout.activity_estadisticas);
        db = new DatabaseManager(this);
        listView = (ListView) findViewById(R.id.listview_estadisticas);


        spinner = (Spinner) findViewById(R.id.spinner_estadistica_spinni);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp=null;

                switch (position){
                    case  0:
                        break;
                    case 1://abdominales
                        temp = "Abdominales";
                        break;
                    case 2://Correr
                        temp = "Correr";
                        break;
                    case 3://Flexiones
                        temp = "Flexiones";
                        break;
                    case 4://sentadillas
                        temp = "Sentadillas";
                        break;
                }
                gymAdapter = new GymAdapter(getApplicationContext(),db.getRutinas(temp));
                listView.setAdapter(gymAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        db.borrar(id);

    }

}