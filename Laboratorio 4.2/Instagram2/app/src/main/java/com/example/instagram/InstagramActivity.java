package com.example.instagram;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class InstagramActivity extends AppCompatActivity {

    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        this.InitializeControls();
        //this.LoadListView();
        this.LoadListViewTemplate();
    }

    private void InitializeControls()
    {
        lstOpciones = (ListView)findViewById(R.id.lstOpciones);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String opcionSeleccionada =
                        ((Chat)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //      ((TextView)v.findViewById(R.id.LblTitulo))
                //          .getText().toString();

                Toast.makeText(InstagramActivity.this,"Opción seleccionada: " + opcionSeleccionada, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void LoadListView()
    {
        List<String> opciones = this.GetElementsToListView();

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);

        lstOpciones.setAdapter(adaptador);

    }

    private void LoadListViewTemplate()
    {
        List<Chat> opciones = this.GetElementsToListViewTemplate();

        InstagramListviewAdapter adapter = new InstagramListviewAdapter(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    private List<String> GetElementsToListView()
    {
        List<String> opciones = new ArrayList<>();

        opciones.add("Parciales");
        opciones.add("Laboratorios");
        opciones.add("Quices");
        opciones.add("Practicas");
        opciones.add("Asistencia");
        opciones.add("Portafolio");

        return  opciones;

    }

    private List<Chat> GetElementsToListViewTemplate()
    {
        List<Chat> opciones = new ArrayList<Chat>();

        opciones.add(new Chat("Parciales", "Dificles", "A"));
        opciones.add(new Chat("Laboratorios", "Haganlos todos","D"));
        opciones.add(new Chat("Quices", "Usamos Kahoot","F"));
        opciones.add(new Chat("Asistencia", "no falten","B"));
        opciones.add(new Chat("Portafolio", "Lastimosamente hay que hacerlo","F"));

        return  opciones;

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.newItem) {
            this.AgregarNuevoElemento();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void AgregarNuevoElemento() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Agregar nuevo elemento");
            View viewInflated = LayoutInflater.from(this).inflate(R.layout.dialog_nuevoitem, (ViewGroup) findViewById(android.R.id.content), false);

            EditText Titulo = viewInflated.findViewById(R.id.titulo);
            EditText Subtitulo = viewInflated.findViewById(R.id.subtitulo);
            EditText Nota = viewInflated.findViewById(R.id.nota);
            builder.setView(viewInflated);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    Chat nuevoItem = new Chat(Titulo.getText().toString(), Subtitulo.getText().toString(), Nota.getText().toString());
                    List<Chat> listaOpciones = ((InstagramListviewAdapter) lstOpciones.getAdapter()).getOpciones();
                    listaOpciones.add(nuevoItem);
                    ((InstagramListviewAdapter) lstOpciones.getAdapter()).notifyDataSetChanged();
                    dialog.cancel();
                }
            });
            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}