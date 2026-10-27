package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detalhe extends AppCompatActivity {
    ImageView imgDetalhe;
    TextView txtCodigo ;
    TextView txtNome ;
    TextView txtPreco;
    TextView txtDescricao ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         imgDetalhe = findViewById(R.id.imgDetalhe);
         txtCodigo = findViewById(R.id.txtDetalheCodigo);
         txtNome = findViewById(R.id.txtDetalheNome);
         txtPreco = findViewById(R.id.txtDetalhePreco);
         txtDescricao = findViewById(R.id.txtDetalheDescricao);
        Intent intent = getIntent();
        if (intent != null) {
            String codigo = intent.getStringExtra("codigo");
            String nome = intent.getStringExtra("nome");
            String preco = intent.getStringExtra("preco");
            String descricao = intent.getStringExtra("descricao");
            int imagemResId = intent.getIntExtra("imagem", 0);

            txtCodigo.setText("Código: " + codigo);
            txtNome.setText(nome);
            txtPreco.setText(preco);
            txtDescricao.setText(descricao);
            imgDetalhe.setImageResource(imagemResId);
        }
    }
}