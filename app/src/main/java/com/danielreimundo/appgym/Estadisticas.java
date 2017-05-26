package com.danielreimundo.appgym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Estadisticas extends AppCompatActivity {

    //Datos de ejemplo para la gráfica
    float rainfall[] = {98.8f,123.8f,16.6f,24.2f,52f,58.2f,35.4f,15.8f,78.4f,
            205.4f,240.2f,159.7f};
    String monthName[] = {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
    //-----------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Gráficas");
        setContentView(R.layout.activity_estadisticas);


        // Crea el metodo
        setupPieChart();
        //------
    }
    // Metodo creado  para el funcionamiento y puesta en marcha de la grádica
    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i < rainfall.length; i++){
            pieEntries.add(new PieEntry(rainfall[i],monthName[i]));
        }

        PieDataSet dateSet = new PieDataSet(pieEntries,"El más grande");
        dateSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData date = new PieData(dateSet);

        // Get the chart;
        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(date);
        chart.animateY(1000);
        chart.invalidate();
        chart.setCenterText("> > AppGym < <");
    }
    //------------------------

}
