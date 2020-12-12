package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.teskaro.listamidias.dao.MidiaDao;
import br.com.teskaro.listamidias.model.Midia;

public class MidiaDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midia);

        EditText edtNome = findViewById(R.id.edtNome);
        EditText edtDescricao = findViewById(R.id.edtDescricao);

        Intent intentRecebida = getIntent();

        // verifica o id midia recebido
        if(intentRecebida.hasExtra("idMidia")){
            int idMidia = intentRecebida.getIntExtra ("idMidia",0);
        }

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtNome      = findViewById(R.id.edtNome);
                EditText edtDescricao = findViewById(R.id.edtDescricao);
                String nome      = edtNome.getText().toString();
                String descricao = edtDescricao.getText().toString();

                if(nome.isEmpty() || descricao.isEmpty()){
                    Toast.makeText(MidiaDetalheActivity.this, "Preencha todos os campo!", Toast.LENGTH_SHORT).show();
                }else{
                    Midia midia  = new Midia(0,nome,descricao);
                    MidiaDao dao = new MidiaDao(MidiaDetalheActivity.this);
                    dao.inserir(midia);

                    Toast.makeText(MidiaDetalheActivity.this, "salvo!", Toast.LENGTH_SHORT).show();

                    edtNome.setText("");
                    edtDescricao.setText("");
                }
            }
        });

    }
}
