package br.com.teskaro.listamidias.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final int BD_VERSAO  = 1;
    private static final String BD_NOME = "listasdemidias.db";

    public DbHelper(Context context) {
        super(context, BD_NOME, null, BD_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTabelaMidias = "CREATE TABLE " + Contract.MidiaEntry.TABELA_NOME + "("+
                Contract.MidiaEntry._ID + " INTEGER PRIMARY KEY, " +
                Contract.MidiaEntry.COLUNA_NOME + " TEXT NOT NULL, "+
                Contract.MidiaEntry.COLUNA_DESCRICAO + " TEXT NOT NULL )";
        sqLiteDatabase.execSQL(sqlTabelaMidias);

        String sqlTabelaContatos = "CREATE TABLE " + Contract.ConteudoEntry.TABELA_NOME + "("+
                Contract.ConteudoEntry._ID + " INTEGER PRIMARY KEY, " +
                Contract.ConteudoEntry.COLUNA_NOME + " TEXT NOT NULL, "+
                Contract.ConteudoEntry.COLUNA_DESCRICAO + " TEXT NOT NULL, " +
                Contract.ConteudoEntry.COLUNA_NOTA + " INTEGER) ";
        sqLiteDatabase.execSQL(sqlTabelaContatos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {

    }
}
