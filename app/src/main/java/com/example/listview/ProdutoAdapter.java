package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdutoAdapter extends BaseAdapter {

    private Context context;
    private String[] codigos;
    private String[] nomes;
    private String[] precos;
    private int[] imagens;

    public ProdutoAdapter(Context context, String[] codigos, String[] nomes, String[] precos, int[] imagens) {
        this.context = context;
        this.codigos = codigos;
        this.nomes = nomes;
        this.precos = precos;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return nomes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        ImageView imgProduto = convertView.findViewById(R.id.imgProduto);
        TextView txtCodigo = convertView.findViewById(R.id.txtCodigo);
        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtPreco = convertView.findViewById(R.id.txtPreco);

        imgProduto.setImageResource(imagens[position]);
        txtCodigo.setText("Cód: " + codigos[position]);
        txtNome.setText(nomes[position]);
        txtPreco.setText(precos[position]);

        return convertView;
    }
}