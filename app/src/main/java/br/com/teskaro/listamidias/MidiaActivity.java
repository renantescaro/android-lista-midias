package br.com.teskaro.listamidias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MidiaActivity extends AppCompatActivity {

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

        
    }
}
