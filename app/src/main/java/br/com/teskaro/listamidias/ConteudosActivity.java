package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConteudosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudos);

        // dados
        List<Conteudo> conteudos = new ArrayList<>();
        conteudos.add(new Conteudo(1,"Livros","livros que eu li",8));
        conteudos.add(new Conteudo(2,"Filmes","filmes indicados ao oscar",5));
        conteudos.add(new Conteudo(4,"Séries","séries da netflix",9));
        conteudos.add(new Conteudo(5,"Séries","séries da netflix",10));

        // adaptador
        ConteudoArrayAdapter adaptadorConteudo = new ConteudoArrayAdapter(this,R.layout.conteudo_item,conteudos);

        // lista
        ListView ltvConteudo = findViewById(R.id.ltvListaConteudo);
        ltvConteudo.setAdapter(adaptadorConteudo);

        // click item
        ltvConteudo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // CONTINUAR DAQUI
                // pegar nome do conteudo

                EditText edtNome = view.findViewById(R.id.edtNome);
                Toast.makeText(ConteudosActivity.this, edtNome.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
