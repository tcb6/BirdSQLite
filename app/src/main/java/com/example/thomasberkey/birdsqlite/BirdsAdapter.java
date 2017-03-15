package com.example.thomasberkey.birdsqlite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BirdsAdapter extends RecyclerView.Adapter<BirdsAdapter.MyViewHolder> {

    private List<Bird> birdsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
        }
    }


    public BirdsAdapter(List<Bird> birdsList) {
        this.birdsList = birdsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bird_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Bird bird = birdsList.get(position);
        holder.name.setText(bird.getName());
        holder.description.setText(bird.getDescription());
    }

    @Override
    public int getItemCount() {
        return birdsList.size();
    }
}