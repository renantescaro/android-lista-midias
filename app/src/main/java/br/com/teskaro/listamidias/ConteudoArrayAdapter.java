package br.com.teskaro.listamidias;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ConteudoArrayAdapter extends ArrayAdapter<Conteudo> {
    private LayoutInflater inflater;
    private int layout;

    public ConteudoArrayAdapter(Activity activity, int layout, List<Conteudo> itens){
        super(activity,layout,itens);
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    public View getView(int posicao, View item, ViewGroup lista) {
        ViewHolderConteudo holder;

        // primeira vez chamando
        if(item == null){
            item   = inflater.inflate(layout,null);
            holder = new ViewHolderConteudo();
            holder.txvNome      = item.findViewById(R.id.txvNome);
            holder.txvDescricao = item.findViewById(R.id.txvDescricao);
            holder.txvNota      = item.findViewById(R.id.txvNota);
            item.setTag(holder);
        }else{
            holder = (ViewHolderConteudo) item.getTag();
        }

        Conteudo conteudo = getItem(posicao);
        holder.txvNome.setText(conteudo.getNome());
        holder.txvDescricao.setText(conteudo.getDescricao());
        holder.txvNota.setText(String.valueOf(conteudo.getNota()));

        return item;
    }

    static class ViewHolderConteudo{
        private TextView txvNome;
        private TextView txvDescricao;
        private TextView txvNota;
    }
}
