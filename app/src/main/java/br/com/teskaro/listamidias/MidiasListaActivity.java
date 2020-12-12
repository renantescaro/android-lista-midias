package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.teskaro.listamidias.adapter.MidiaArrayAdapter;
import br.com.teskaro.listamidias.dao.MidiaDao;
import br.com.teskaro.listamidias.model.Midia;

public class MidiasListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midias);

        // dados
        List<Midia> midias = new MidiaDao(this).listar();

        // adaptador
        MidiaArrayAdapter adaptador = new MidiaArrayAdapter(this,R.layout.midia_item,midias);

        // lista
        ListView ltv = findViewById(R.id.ltvListaMidia);
        ltv.setAdapter(adaptador);

        // seleciona midia
        ltv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent abrirTelaConteudos = new Intent(MidiasListaActivity.this, ConteudosListaActivity.class);
                abrirTelaConteudos.putExtra("idMidia",Integer.toString(i));
                startActivity(abrirTelaConteudos);
            }
        });

        // nova midia
        FloatingActionButton fabMidia = findViewById(R.id.fabMidia);
        fabMidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirTelaCadastro = new Intent(MidiasListaActivity.this, MidiaDetalheActivity.class);
                startActivity(abrirTelaCadastro);
            }
        });
    }
}
