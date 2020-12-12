package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dados
        List<Midia> midias = new ArrayList<>();
        midias.add(new Midia(2,"Livros","livros que eu li"));
        midias.add(new Midia(5,"Filmes","filmes indicados ao oscar"));
        midias.add(new Midia(6,"Séries","séries da netflix"));

        // adaptador
        MidiaArrayAdapter adaptador = new MidiaArrayAdapter(this,R.layout.midia_item,midias);

        // lista
        ListView ltv = findViewById(R.id.ltvListaMidia);
        ltv.setAdapter(adaptador);

        // click item
        ltv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent abrirTelaConteudos = new Intent(MainActivity.this, ConteudosActivity.class);
                abrirTelaConteudos.putExtra("idMidia",Integer.toString(i));
                startActivity(abrirTelaConteudos);
            }
        });
    }
}
