package com.example.alejoaj.sesion1interfaces;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText eNombre,eApellido,eCelular,eEmail;
    private TextView tinfo;
    private Button bResgistrar;
    private String nombre,cell,email,apellido,sexo="Masculino",hobbie="",ciudad;
    private int numero;
    private  int numero2;
    private float hola;
    private CheckBox cCine, cComida , cDeporte, cMusica;
    private Spinner sCiudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = (EditText) findViewById(R.id.eNombre);
        eApellido = (EditText) findViewById(R.id.eApellido);
        bResgistrar = (Button) findViewById(R.id.bResgistrar);
        tinfo = (TextView) findViewById(R.id.tinfo);
        cCine = (CheckBox) findViewById(R.id.cCine);
        cComida = (CheckBox) findViewById(R.id.cComida);
        cMusica = (CheckBox) findViewById(R.id.cMusica);
        cDeporte = (CheckBox) findViewById(R.id.cDeporte);
        eCelular = (EditText) findViewById(R.id.eCelular);
        eEmail = (EditText) findViewById(R.id.eEmail);
        sCiudad = (Spinner) findViewById(R.id.sCiudad);

        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Ciudad_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sCiudad.setAdapter(adapter);
        /*
        lo siguiente se autocompletó con ctrol y espacio
         */
        sCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ciudad = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Registrar(View view) {
        bResgistrar.setText("se presiono esta mondá");
        hobbie = "";
        nombre = eNombre.getText().toString();
        apellido = eApellido.getText().toString();
        cell = eCelular.getText().toString();
        email = eEmail.getText().toString();
        if(cCine.isChecked()){
            hobbie = hobbie + " " + "Cine";
        }
        if(cComida.isChecked()){
            hobbie = hobbie+ " " + "Comida";
        }
        if(cDeporte.isChecked()){
            hobbie = hobbie+ " " + "Deporte";
        }
        if (cMusica.isChecked()){
            hobbie = hobbie+ " " + "Musica";
        }
        tinfo.setText("El nombre es: "+nombre+" \n Apellido: "+apellido + "\n sexo" + sexo+ "\n hobbies:" + hobbie+"" +
                "\n  Ciudad" + ciudad+
                "\n Email" + email+
                "\n Celular" + cell);

        /*
        hola = Float.parseFloat(s);
        numero2 = Integer.parseInt(apellido);
        numero = Integer.parseInt(nombre);
        numero = numero2 +numero;
        nombre  = Integer.toString(numero);
        tinfo.setText(nombre);
        */
    }

    public void onRadioButtonClicked(View view) {
        int id = view.getId();

        if( id == R.id.rMasculino){
            sexo = "Masculino";
        }
        if(id == R.id.rFemenino){
            sexo = "Femenino";
        }
    }

    public void onCheckboxClicked(View view) {
        /*int id = view.getId();
        switch (id){
            case R.id.cCine:
                if (((CheckBox) view).isChecked()) {
                    hobbie = hobbie + "cine";
                }
                break;
            case R.id.cComida: hobbie = hobbie + "comida";
                break;
            case  R.id.cDeporte: hobbie = hobbie + "Deporte";
                break;
            case  R.id.cMusica: hobbie = hobbie + "Musica";
                break;
        }
    */}
}
