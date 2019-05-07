package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class catsAdapter extends RecyclerView.Adapter<catsViewHolder> {

    private List<cats> cats;
    private Context context;

    public catsAdapter(List<cats> cats, Context context) {
        this.cats = cats;
        this.context = context;
    }

    @Override
    public catsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cat, parent, false);
        return new catsViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(catsViewHolder holder, int position) {
        cats cat=cats.get(position);
        holder.bind(cat);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }
}
