package com.example.rasp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class PredmetRecycleViewAdapter extends RecyclerView.Adapter<PredmetRecycleViewAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Predmet> predmets;

    public PredmetRecycleViewAdapter(Context context, List<Predmet> predmets) {
        this.predmets = predmets;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle_item_predmet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Predmet predmet = predmets.get(position);
        holder.name_predmet.setText(predmet.getNamePredmet());
        holder.name_prepod.setText(predmet.getNamePrepod());
    }

    @Override
    public int getItemCount() {
        return predmets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name_predmet;
        TextView name_prepod;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_predmet = itemView.findViewById(R.id.name_predmet);
            name_prepod = itemView.findViewById(R.id.name_prepod);
        }
    }
}
