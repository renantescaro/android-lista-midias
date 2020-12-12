package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.teskaro.listamidias.dao.ConteudoDao;
import br.com.teskaro.listamidias.dao.MidiaDao;
import br.com.teskaro.listamidias.model.Conteudo;
import br.com.teskaro.listamidias.model.Midia;

public class ConteudoDetalheActivity extends AppCompatActivity {

    private int idConteudo = 0;
    private int idMidia    = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);
        Button btnExcluir = findViewById(R.id.btnExcluir);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        // ID CONTEUDO
        Intent intentRecebida = getIntent();
        if(intentRecebida.hasExtra("id")){
            this.idConteudo = intentRecebida.getIntExtra("id",0);

            if(this.idConteudo!=0){
                Conteudo conteudo = new ConteudoDao(this).selecionarPorId(this.idConteudo);
                EditText edtNome      = findViewById(R.id.edtNome);
                EditText edtDescricao = findViewById(R.id.edtDescricao);
                EditText edtNota      = findViewById(R.id.edtNota);

                edtNome.setText(conteudo.getNome());
                edtDescricao.setText(conteudo.getDescricao());
                edtNota.setText(String.valueOf(conteudo.getNota()));

                btnExcluir.setVisibility(View.VISIBLE);
            }
        }

        // ID MIDIA
        if(intentRecebida.hasExtra("idMidia")){
            this.idMidia = intentRecebida.getIntExtra("idMidia",0);
        }

        // parametro não recebido - update
        else{
            btnExcluir.setVisibility(View.GONE);
        }

        // salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNome      = findViewById(R.id.edtNome);
                EditText edtDescricao = findViewById(R.id.edtDescricao);
                EditText edtNota      = findViewById(R.id.edtNota);
                String nome           = edtNome.getText().toString();
                String descricao      = edtDescricao.getText().toString();
                int idMidia           = ConteudoDetalheActivity.this.idMidia;
                int nota              = edtNota.getText().toString().isEmpty() ? 10 : Integer.parseInt(edtNota.getText().toString());

                if(nome.isEmpty() || descricao.isEmpty()){
                    Toast.makeText(ConteudoDetalheActivity.this, "Preencha todos os campo!", Toast.LENGTH_SHORT).show();
                }else{
                    Conteudo conteudo  = new Conteudo(ConteudoDetalheActivity.this.idConteudo ,nome,descricao,nota,idMidia);
                    ConteudoDao dao = new ConteudoDao(ConteudoDetalheActivity.this);

                    if(ConteudoDetalheActivity.this.idConteudo==0){
                        dao.inserir(conteudo);
                        Toast.makeText(ConteudoDetalheActivity.this, "Novo registro criado!", Toast.LENGTH_SHORT).show();
                    }else{
                        dao.atualizar(conteudo);
                        Toast.makeText(ConteudoDetalheActivity.this, "Registro atualizado!", Toast.LENGTH_SHORT).show();
                    }

                    edtNome.setText("");
                    edtDescricao.setText("");
                    edtNota.setText("");
                }
            }
        });


        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idConteudo > 0){
                    new ConteudoDao(ConteudoDetalheActivity.this).excluir(idConteudo);
                    Toast.makeText(ConteudoDetalheActivity.this, "Registro Excluido!", Toast.LENGTH_SHORT).show();

                    EditText edtNome      = findViewById(R.id.edtNome);
                    EditText edtDescricao = findViewById(R.id.edtDescricao);
                    EditText edtNota      = findViewById(R.id.edtNota);
                    edtNome.setText("");
                    edtDescricao.setText("");
                    edtNota.setText("");
                }else{
                    Toast.makeText(ConteudoDetalheActivity.this, "Erro ao excluir!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
