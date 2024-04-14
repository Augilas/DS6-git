package com.example.applabs3irvingcamarena_rafaelchung_anaportugal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaramos las variables de los controles que vamos a utilizar
    EditText txtNum1;
    EditText txtNum2;
    RadioGroup radioGroup;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
    }

    private void InicializarControles() {
        txtNum1 = (EditText)findViewById(R.id.txtNum1);
        txtNum2 = (EditText)findViewById(R.id.txtNum2);
        radioGroup = findViewById(R.id.radioGroup);
        lblResultado = (TextView)findViewById(R.id.lblRes);
    }

    public void calcularOperacion(View view) {
        try {
            int n1 = Integer.parseInt(txtNum1.getText().toString());
            int n2 = Integer.parseInt(txtNum2.getText().toString());
            int resultado = 0;

            // Check which radio button is checked and perform the corresponding operation
            int selectedId = radioGroup.getCheckedRadioButtonId();
            switch (selectedId) {
                case R.id.radioSuma:
                    resultado = sumarNumeros(n1, n2);
                    break;
                case R.id.radioResta:
                    resultado = restarNumeros(n1, n2);
                    break;
                case R.id.radioMultiplicacion:
                    resultado = multiplicarNumeros(n1, n2);
                    break;
                case R.id.radioDivision:
                    resultado = dividirNumeros(n1, n2);
                    break;
            }

            // Set the result to the TextView
            lblResultado.setText(String.valueOf(resultado));
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
            Toast.makeText(this, "No se puede dividir por cero. Por favor, intente de nuevo", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }
}
