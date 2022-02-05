package com.example.rasp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParaRecycleViewAdapter extends RecyclerView.Adapter<ParaRecycleViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Para> paras;

    public ParaRecycleViewAdapter(Context context, List<Para> paras) {
        this.paras = paras;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle_item_para, parent, false);
        return new ParaRecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Para para = paras.get(position);
        holder.para_number.setText(para.getParaNumber());
        PredmetRecycleViewAdapter adapter = new PredmetRecycleViewAdapter(inflater.getContext(), para.getPredmets());
        holder.recycleView_forPredmet.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return paras.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recycleView_forPredmet;
        TextView para_number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recycleView_forPredmet = itemView.findViewById(R.id.recycleView_forPredmet);
            para_number = itemView.findViewById(R.id.paraNumber);
        }
    }
}
