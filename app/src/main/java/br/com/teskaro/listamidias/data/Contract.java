package br.com.teskaro.listamidias.data;
import android.provider.BaseColumns;

public class Contract {

    // MIDIAS
    public static final class MidiaEntry implements BaseColumns{
        public static final String TABELA_NOME      = "midias";
        public static final String COLUNA_NOME      = "nome";
        public static final String COLUNA_DESCRICAO = "descricao";
    }

    // CONTEUDOS
    public static final class ConteudoEntry implements BaseColumns{
        public static final String TABELA_NOME      = "conteudos";
        public static final String COLUNA_NOME      = "nome";
        public static final String COLUNA_DESCRICAO = "descricao";
        public static final String COLUNA_NOTA      = "nota";
        public static final String COLUNA_ID_MIDIA  = "id_midia";
    }
}
