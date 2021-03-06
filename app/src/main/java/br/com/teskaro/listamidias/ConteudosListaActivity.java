package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.teskaro.listamidias.adapter.ConteudoArrayAdapter;
import br.com.teskaro.listamidias.adapter.MidiaArrayAdapter;
import br.com.teskaro.listamidias.dao.ConteudoDao;
import br.com.teskaro.listamidias.dao.MidiaDao;
import br.com.teskaro.listamidias.model.Conteudo;
import br.com.teskaro.listamidias.model.Midia;

public class ConteudosListaActivity extends AppCompatActivity {

    private int idMidia = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudos);

        // midia dos conteudos atuais
        Intent intentRecebida = getIntent();
        if(intentRecebida.hasExtra("idMidia")){
            this.idMidia = intentRecebida.getIntExtra("idMidia",0);
        }

        // lista
        ListView ltvConteudo = findViewById(R.id.ltvListaConteudo);

        // editar
        ltvConteudo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Conteudo conteudo = (Conteudo) adapterView.getItemAtPosition(i);
                Intent abrirTelaCadastro = new Intent(ConteudosListaActivity.this, ConteudoDetalheActivity.class);
                abrirTelaCadastro.putExtra("idConteudo",conteudo.getId());
                startActivity(abrirTelaCadastro);
            }
        });

        // novo
        FloatingActionButton fabConteudo = findViewById(R.id.fabConteudo);
        fabConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirTelaCadastro = new Intent(ConteudosListaActivity.this, ConteudoDetalheActivity.class);
                abrirTelaCadastro.putExtra("idMidia",ConteudosListaActivity.this.idMidia);
                startActivity(abrirTelaCadastro);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        criarListaConteudos();
    }

    private void criarListaConteudos(){
        // dados
        List<Conteudo> conteudos = new ConteudoDao(this).listar();

        // adaptador
        final ConteudoArrayAdapter adaptador = new ConteudoArrayAdapter(this,R.layout.conteudo_item,conteudos);

        // lista
        ListView ltv = findViewById(R.id.ltvListaConteudo);
        ltv.setAdapter(adaptador);
    }
}
