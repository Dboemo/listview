package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    // Arrays com os dados dos 10 itens
    private String[] codigos = {"001", "002", "003", "004", "005", "006", "007", "008", "009", "010"};
    private String[] nomes = {
            "Classic Burger", "Cheese Bacon", "Double Smash", "Chicken Crispy", "BBQ Monster",
            "Veggie Burger", "Monster Double", "Egg Bacon", "Cheddar Melt", "Super Combo"
    };
    private String[] precos = {
            "R$ 22,00", "R$ 28,00", "R$ 32,00", "R$ 25,00", "R$ 35,00",
            "R$ 26,00", "R$ 38,00", "R$ 27,00", "R$ 30,00", "R$ 42,00"
    };
    private String[] descricoes = {
            "Hambúrguer de carne bovina 180g, queijo prato, alface, tomate e molho especial.",
            "Pão brioche, carne 180g, muito bacon crocante e queijo cheddar fatiado.",
            "Dois hambúrgueres smash de 90g cada, queijo duplo e maionese da casa.",
            "Filé de frango empanado crocante, salada coleslaw e maionese temperada.",
            "Carne 200g, bacon, anéis de cebola empanados, queijo e molho barbecue.",
            "Hambúrguer de grão de bico, queijo vegano, alface, tomate e maionese verde.",
            "Dois hambúrgueres 180g, cheddar duplo, bacon, cebola caramelizada.",
            "Carne 180g, ovo frito, bacon, queijo prato e maionese tradicional.",
            "Pão australiano, carne 180g, creme de cheddar e cebola ao molho shoyu.",
            "Hambúrguer artesanal triplo, bacon extra, cheddar duplo e batata frita."
    };

    // Array com as referências das imagens da pasta drawable
    private int[] imagens = {
            R.drawable.hamburguer_1, R.drawable.hamburguer_2, R.drawable.hamburguer_3,
            R.drawable.hamburguer_4, R.drawable.hamburguer_5, R.drawable.hamburguer_6,
            R.drawable.hamburguer_7, R.drawable.hamburguer_8, R.drawable.hamburguer_9,
            R.drawable.hamburguer_10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listViewProdutos);
        ProdutoAdapter adapter = new ProdutoAdapter(this, codigos, nomes, precos, imagens);
        listView.setAdapter(adapter);

        // Evento de clique no item da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, detalhe.class);
                intent.putExtra("codigo", codigos[position]);
                intent.putExtra("nome", nomes[position]);
                intent.putExtra("preco", precos[position]);
                intent.putExtra("descricao", descricoes[position]);
                intent.putExtra("imagem", imagens[position]);
                startActivity(intent);
            }
        });
    }
}