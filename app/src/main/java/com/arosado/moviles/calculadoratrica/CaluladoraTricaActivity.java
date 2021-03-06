package com.arosado.moviles.calculadoratrica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CaluladoraTricaActivity extends AppCompatActivity {

    EditText editTextTeo1, editTextTeo2;
    EditText editTextLab1,editTextLab2,editTextLab3,editTextLab4;
    TextView textViewPromedioT, textViewPromedioL, textViewPromedioF, textViewCondicion;
    Spinner spinnerTipoEv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caluladora_trica);

        spinnerTipoEv = findViewById(R.id.spinner);

        editTextTeo1 = findViewById(R.id.editTextTeo1);
        editTextTeo2 = findViewById(R.id.editTextTeo2);

        editTextLab1 = findViewById(R.id.editTextLab1);
        editTextLab2 = findViewById(R.id.editTextLab2);
        editTextLab3 = findViewById(R.id.editTextLab3);
        editTextLab4 = findViewById(R.id.editTextLab4);

        textViewPromedioT = findViewById(R.id.textViewPromedioT);
        textViewPromedioL = findViewById(R.id.textViewPromedioL);
        textViewPromedioF = findViewById(R.id.textViewPromedioF);

        textViewCondicion = findViewById(R.id.textViewCondicion);
    }

    public void calcularTotal(View view) {
        double teo1 = 0, teo2 = 0;
        double lab1 = 0, lab2 = 0, lab3 = 0, lab4 = 0;
        double promT, promL, promF = 0;
        int tipo = spinnerTipoEv.getSelectedItemPosition();

        try {
            teo1 = Double.parseDouble(editTextTeo1.getText().toString());
            teo2 = Double.parseDouble(editTextTeo2.getText().toString());

        }catch (Exception e) {
            Toast.makeText(this, "Falta agregar notas de teoría.", Toast.LENGTH_SHORT).show();
        }

        try {
            lab1 = Double.parseDouble(editTextLab1.getText().toString());
            lab2 = Double.parseDouble(editTextLab2.getText().toString());
            lab3 = Double.parseDouble(editTextLab3.getText().toString());
            lab4 = Double.parseDouble(editTextLab4.getText().toString());
        }catch (Exception e) {
            Toast.makeText(this, "Faltan notas de laboratorio", Toast.LENGTH_SHORT).show();
        }

        promT = (teo1 + teo2) / 2;
        promL = (lab1 + lab2 + lab3 + lab4) / 4;

        switch (tipo) {
            case 0:
                promF = promT * 0.3 + promL * 0.7;
                break;
            case 1:
                promF = promT * 0.5 + promL * 0.5;
                break;
            case 2:
                promF = promT * 0.4 + promL * 0.6;
        }
        String condicion = promF >=13 ? "Aprobado" : "Desaprobado";

        textViewPromedioT.setText(String.valueOf(String.format("%.2f",promT)));
        textViewPromedioL.setText(String.valueOf(String.format("%.2f",promL)));
        if (promF != 0) {
            textViewPromedioF.setText("Promedio: " + String.valueOf(String.format("%.2f",promF)));
            textViewCondicion.setText(condicion);
        }
    }
}
