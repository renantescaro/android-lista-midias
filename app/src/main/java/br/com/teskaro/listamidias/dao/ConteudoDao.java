package br.com.teskaro.listamidias.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.teskaro.listamidias.data.Contract;
import br.com.teskaro.listamidias.data.DbHelper;
import br.com.teskaro.listamidias.model.Conteudo;

public class ConteudoDao {
    private SQLiteDatabase bd;

    public ConteudoDao(Context context){
        DbHelper helper = new DbHelper(context);
        bd = helper.getWritableDatabase();
    }

    public void inserir(Conteudo conteudo){
        ContentValues values = new ContentValues();
        values.put(Contract.ConteudoEntry.COLUNA_NOME,conteudo.getNome());
        values.put(Contract.ConteudoEntry.COLUNA_DESCRICAO,conteudo.getDescricao());
        values.put(Contract.ConteudoEntry.COLUNA_NOTA,conteudo.getNota());

        bd.insert(Contract.ConteudoEntry.TABELA_NOME,null,values);
    }

    public void atualizar(Conteudo conteudo){
        ContentValues values = new ContentValues();
        values.put(Contract.ConteudoEntry.COLUNA_NOME,conteudo.getNome());
        values.put(Contract.ConteudoEntry.COLUNA_DESCRICAO,conteudo.getDescricao());
        values.put(Contract.ConteudoEntry.COLUNA_NOTA,conteudo.getNota());

        values.put(Contract.ConteudoEntry._ID,conteudo.getId());

        bd.update(Contract.ConteudoEntry.TABELA_NOME, values,
                Contract.ConteudoEntry._ID+"=?",
                new String[]{String.valueOf(conteudo.getId())});
    }

    public void excluir(Conteudo conteudo){
        bd.delete(Contract.ConteudoEntry.TABELA_NOME,
                Contract.ConteudoEntry._ID+"=?",
                new String[]{String.valueOf(conteudo.getId())});
    }

    public List<Conteudo> listar(){
        List<Conteudo> conteudos = new ArrayList<>();

        String[] colunas = {Contract.ConteudoEntry._ID,
                Contract.ConteudoEntry.COLUNA_NOME,
                Contract.ConteudoEntry.COLUNA_DESCRICAO};

        Cursor cursor = bd.query(Contract.ConteudoEntry.TABELA_NOME, colunas,
                null,
                null,
                null,
                null,
                Contract.ConteudoEntry.COLUNA_NOME + " ASC");

        // se tiver dados, cria list com o objeto
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Conteudo conteudo = new Conteudo();
                conteudo.setId(cursor.getInt(0));
                conteudo.setNome(cursor.getString(1));
                conteudo.setDescricao(cursor.getString(2));
                conteudos.add(conteudo);
            }while (cursor.moveToNext());
        }
        return conteudos;
    }

    public Conteudo selecionarPorId(int id){
        Conteudo conteudo = new Conteudo();

        if(id > 0){
            String[] colunas = {Contract.ConteudoEntry._ID,
                    Contract.ConteudoEntry.TABELA_NOME,
                    Contract.ConteudoEntry.COLUNA_DESCRICAO,
                    Contract.ConteudoEntry.COLUNA_NOTA,};

            Cursor cursor = bd.query(Contract.ConteudoEntry.TABELA_NOME, colunas,
                    Contract.ConteudoEntry._ID+"=?",
                    new String[]{String.valueOf(id)},
                    null,
                    null,
                    null);

            // se tiver dados, passa para objeto
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                conteudo.setId(cursor.getInt(0));
                conteudo.setNome(cursor.getString(1));
                conteudo.setDescricao(cursor.getString(2));
                conteudo.setNota(cursor.getInt(3));
            }
        }
        return conteudo;
    }
}