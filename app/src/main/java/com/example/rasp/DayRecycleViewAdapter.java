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

public class DayRecycleViewAdapter extends RecyclerView.Adapter<DayRecycleViewAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Day> days;

    public DayRecycleViewAdapter(Context context, List<Day> days){
        this.days = days;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycle_item_day, parent, false);
        return new DayRecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Day day = days.get(position);
        holder.title_day.setText(day.getTitle_day());
        ParaRecycleViewAdapter adapter = new ParaRecycleViewAdapter(inflater.getContext(), day.getParas());
        holder.recycleView_day.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title_day;
        private RecyclerView recycleView_day;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_day = itemView.findViewById(R.id.title_day);
            recycleView_day = itemView.findViewById(R.id.recycleView_day);
        }
    }
}
