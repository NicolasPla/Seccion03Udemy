package com.example.seccion03;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names;
    private int layout;
    private OnItemClickListener listener;

    public MyAdapter(List<String> names, int layout, OnItemClickListener listener){

        this.names = names;
        this.layout = layout;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(names.get(i), listener);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;

        // CONSTRUCTOR
        public  ViewHolder(View itemView){
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);

        }

        public  void bind(final String name, final OnItemClickListener listener) {
            this.textViewName.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }

    public  interface OnItemClickListener{
        void onItemClick(String name, int position);

    }

}
