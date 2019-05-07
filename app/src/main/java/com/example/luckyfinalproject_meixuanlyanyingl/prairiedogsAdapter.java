package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class prairiedogsAdapter extends RecyclerView.Adapter<PrairiedogsViewHolder> {

       private List<prairiedogs>prairiedogs;
       private Context context;

       public prairiedogsAdapter(List<prairiedogs> prairiedogs, Context context) {
           this.prairiedogs = prairiedogs;
           this.context = context;
       }

       @Override
       public PrairiedogsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_prairiedog, parent, false);
           return new PrairiedogsViewHolder(view, context);
       }

       @Override
       public void onBindViewHolder(PrairiedogsViewHolder holder, int position) {
           prairiedogs prairiedog = prairiedogs.get(position);
           holder.bind(prairiedog);
       }

       @Override
       public int getItemCount() {
           return prairiedogs.size();
       }
   }