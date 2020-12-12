package br.com.teskaro.listamidias.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.teskaro.listamidias.data.Contract;
import br.com.teskaro.listamidias.data.DbHelper;
import br.com.teskaro.listamidias.model.Midia;

public class MidiaDao {
    private SQLiteDatabase bd;

    public MidiaDao(Context context){
        DbHelper helper = new DbHelper(context);
        bd = helper.getWritableDatabase();
    }

    public void inserir(Midia midia){
        ContentValues values = new ContentValues();
        //values.put(Contract.MidiaEntry._ID,midia.getId());
        values.put(Contract.MidiaEntry.COLUNA_NOME,midia.getNome());
        values.put(Contract.MidiaEntry.COLUNA_DESCRICAO,midia.getDescricao());

        bd.insert(Contract.MidiaEntry.TABELA_NOME,null,values);
    }

    public void atualizar(Midia midia){
        ContentValues values = new ContentValues();
        values.put(Contract.MidiaEntry.COLUNA_NOME,midia.getNome());
        values.put(Contract.MidiaEntry.COLUNA_DESCRICAO,midia.getDescricao());

        values.put(Contract.MidiaEntry._ID,midia.getId());

        bd.update(Contract.MidiaEntry.TABELA_NOME, values,
                Contract.MidiaEntry._ID+"=?",
                new String[]{String.valueOf(midia.getId())});
    }

    public void excluir(Midia midia){
        bd.delete(Contract.MidiaEntry.TABELA_NOME,
                Contract.MidiaEntry._ID+"=?",
                new String[]{String.valueOf(midia.getId())});
    }

    public List<Midia> listar(){
        List<Midia> midias = new ArrayList<>();

        String[] colunas = {Contract.MidiaEntry._ID,
                            Contract.MidiaEntry.COLUNA_NOME,
                            Contract.MidiaEntry.COLUNA_DESCRICAO};

        Cursor cursor = bd.query(Contract.MidiaEntry.TABELA_NOME, colunas,
                                    null,
                                 null,
                                     null,
                                      null,
                                     Contract.MidiaEntry.COLUNA_NOME + " ASC");

        // se tiver dados, cria list com o objeto
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Midia midia = new Midia();
                midia.setId(cursor.getInt(0));
                midia.setNome(cursor.getString(1));
                midia.setDescricao(cursor.getString(2));
                midias.add(midia);
            }while (cursor.moveToNext());
        }
        return midias;
    }

    public Midia selecionarPorId(int id){
        Midia midia = new Midia();

        if(id > 0){
            String[] colunas = {Contract.MidiaEntry._ID,
                    Contract.MidiaEntry.TABELA_NOME,
                    Contract.MidiaEntry.COLUNA_DESCRICAO};

            Cursor cursor = bd.query(Contract.MidiaEntry.TABELA_NOME, colunas,
                    Contract.MidiaEntry._ID+"=?",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null);

            // se tiver dados, passa para objeto
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                midia.setId(cursor.getInt(0));
                midia.setNome(cursor.getString(1));
                midia.setDescricao(cursor.getString(2));
            }
        }
        return midia;
    }
}