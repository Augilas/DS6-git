package com.example.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InstagramListviewAdapter extends ArrayAdapter<Chat> {
    private List<Chat> opciones = new ArrayList<>();
    public List<Chat> getOpciones() {
        return opciones;
    }

    public InstagramListviewAdapter(Context context, List<Chat> datos) {
        super(context, R.layout.listview_layouttemplate, datos);
        opciones = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_layouttemplate, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(opciones.get(position).getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.lblSubTitulo);
        lblSubtitulo.setText(opciones.get(position).getSubtitulo());

        TextView lblNota = (TextView)item.findViewById(R.id.lblNota);
        lblNota.setText(opciones.get(position).getNota());

        return(item);
    }
}
