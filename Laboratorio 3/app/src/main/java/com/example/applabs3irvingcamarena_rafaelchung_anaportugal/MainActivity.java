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

    // declaramos las variables de los controles que vamos a utilizar
    EditText txtNum1, txtNum2;
    RadioButton radioSuma, radioResta, radioMultiplicacion, radioDivision;
    Button btnCalcular, btnDiologResultado;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        this.InicializarControles();
    }

    private void InicializarControles() {
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        radioSuma = findViewById(R.id.radioSuma);
        radioResta = findViewById(R.id.radioResta);
        radioMultiplicacion = findViewById(R.id.radioMultiplicacion);
        radioDivision = findViewById(R.id.radioDivision);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblResultado = (TextView) findViewById(R.id.lblRes);
    }

    public void calcularOperacion(View view) {
        try {
            int n1 = Integer.parseInt(txtNum1.getText().toString());
            int n2 = Integer.parseInt(txtNum2.getText().toString());
            int resultado = 0;

            if (radioSuma.isChecked()) {
                resultado = sumarNumeros(n1, n2);
                Dialogo(resultado);
            }
            if (radioResta.isChecked()) {
                resultado = restarNumeros(n1, n2);
                Dialogo(resultado);
            }
            if (radioMultiplicacion.isChecked()) {
                resultado = multiplicarNumeros(n1, n2);
                Dialogo(resultado);
            }
            if (radioDivision.isChecked()) {
                resultado = dividirNumeros(n1, n2);
                Dialogo(resultado);
            } else {
                Toast.makeText(this,
                        "Ninguna opción ha sido seleccionada. Por favor, escoja alguna de las operaciones disponibles",
                        Toast.LENGTH_SHORT).show();
            }
            
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private int sumarNumeros(int n1, int n2) {
        return n1 + n2;
    }

    private int restarNumeros(int n1, int n2) {
        return n1 - n2;
    }

    private int multiplicarNumeros(int n1, int n2) {
        return n1 * n2;
    }

    private int dividirNumeros(int n1, int n2) {
        if (n2 != 0) {
            return n1 / n2;
        } else {
            Toast.makeText(this, "No se puede dividir por cero. Por favor, intente de nuevo", Toast.LENGTH_SHORT)
                    .show();
            return 0;
        }
    }

    protected void Dialogo(String titulo, float resultado, Boolean res) {
        if (res) {
            lblResultado.setText("");
            CustomDialog dialog = new CustomDialog(titulo, resultado);
            dialog.show(getSupportFragmentManager(), "dialogo");
        } else {
            lblResultado.setText(String.format(Locale.getDefault(), "%.3f", resultado));
        }
    }

}
