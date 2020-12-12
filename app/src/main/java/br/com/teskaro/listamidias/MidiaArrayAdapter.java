package br.com.teskaro.listamidias;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class MidiaArrayAdapter extends ArrayAdapter<Midia> {
    private LayoutInflater inflater;
    private int layout;

    public MidiaArrayAdapter(Activity activity, int layout, List<Midia> itens){
        super(activity,layout,itens);
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    public View getView(int posicao, View item, ViewGroup lista) {
        ViewHolder holder;

        // primeira vez chamando
        if(item == null){
            item   = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txvNome      = item.findViewById(R.id.txvNome);
            holder.txvDescricao = item.findViewById(R.id.txvDescricao);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }

        Midia midia = getItem(posicao);
        holder.txvNome.setText(midia.getNome());
        holder.txvDescricao.setText(midia.getDescricao());

        return item;
    }

    static class ViewHolder{
        private TextView txvNome;
        private TextView txvDescricao;
    }
}
