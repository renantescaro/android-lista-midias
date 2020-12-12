package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNome      = findViewById(R.id.edtNome);
                EditText edtDescricao = findViewById(R.id.edtDescricao);
                EditText edtNota      = findViewById(R.id.edtNota);
                String nome           = edtNome.getText().toString();
                String descricao      = edtDescricao.getText().toString();
                int nota              = edtNota.getText().toString().isEmpty() ? 10 : Integer.parseInt(edtNota.getText().toString());

                if(nome.isEmpty() || descricao.isEmpty()){
                    Toast.makeText(ConteudoDetalheActivity.this, "Preencha todos os campo!", Toast.LENGTH_SHORT).show();
                }else{
                    Conteudo midia  = new Conteudo(0,nome,descricao,nota);
                    ConteudoDao dao = new ConteudoDao(ConteudoDetalheActivity.this);
                    dao.inserir(midia);

                    Toast.makeText(ConteudoDetalheActivity.this, "salvo!", Toast.LENGTH_SHORT).show();

                    edtNome.setText("");
                    edtDescricao.setText("");
                }
            }
        });
    }
}
