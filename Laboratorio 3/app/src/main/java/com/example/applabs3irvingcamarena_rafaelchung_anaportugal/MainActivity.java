package com.example.applabs3irvingcamarena_rafaelchung_anaportugal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applabs3irvingcamarena_rafaelchung_anaportugal.Helpers.CustomDialog;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //declaramos las variables de los controles que vamos a utilizar
    EditText txtNum1;
    EditText txtNum2;
    RadioGroup radiGroup;
    TextView lblResultado;

    CheckBox cDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        this.InicializarControles();
    }

    private void InicializarControles() {
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);
        radiGroup = (RadioGroup) findViewById(R.id.radioGroup);
        lblResultado = (TextView)findViewById(R.id.lblRes);
        cDialogo = (CheckBox)findViewById(R.id.dialog);
    }

    public void calcularOperaciones(View view) {
        float resultado;
        try {
            //El controlador de radio
            int IdBotonRadio = radiGroup.getCheckedRadioButtonId();
            RadioButton botonRad = findViewById(IdBotonRadio);
            if (botonRad != null) {
                String selector = botonRad.getText().toString();
                switch (selector) {
                    case "Suma":
                        resultado = Float.parseFloat(txtNum1.getText().toString()) + Float.parseFloat(txtNum2.getText().toString());
                        Dialogo(selector, resultado, cDialogo.isChecked());
                        break;
                    case "Resta":
                        resultado = Float.parseFloat(txtNum1.getText().toString()) - Float.parseFloat(txtNum2.getText().toString());
                        Dialogo(selector, resultado, cDialogo.isChecked());
                        break;
                    case "Multiplicacion":
                        resultado = (Float.parseFloat(txtNum1.getText().toString())) * (Float.parseFloat(txtNum2.getText().toString()));
                        Dialogo(selector, resultado, cDialogo.isChecked());
                        break;
                    case "Division":
                        if (Float.parseFloat(txtNum2.getText().toString()) != 0) {
                            resultado = Float.parseFloat(txtNum1.getText().toString()) / Float.parseFloat(txtNum2.getText().toString());
                        } else {
                            Toast.makeText(this, "No se puede dividir por cero. Por favor, intente de nuevo", Toast.LENGTH_SHORT).show();
                            resultado = 0;
                        }
                        Dialogo(selector, resultado, cDialogo.isChecked());
                        break;

                    default:
                        resultado = Float.parseFloat(txtNum1.getText().toString()) % Float.parseFloat(txtNum2.getText().toString());
                        Dialogo(selector, resultado, cDialogo.isChecked());
                        break;
                }
            }  else {
                Toast.makeText(this, "Ninguna opción ha sido seleccionada. Por favor, escoja alguna de las operaciones disponibles", Toast.LENGTH_SHORT).show();
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }


    protected void Dialogo(String titulo, float resultado, Boolean res) {
        if(res) {
            lblResultado.setText("");
            CustomDialog dialog = new CustomDialog(titulo, resultado);
            dialog.show(getSupportFragmentManager(), "dialogo");
        } else {
            lblResultado.setText(String.format(Locale.getDefault(), "%.3f", resultado));
        }
    }
}
