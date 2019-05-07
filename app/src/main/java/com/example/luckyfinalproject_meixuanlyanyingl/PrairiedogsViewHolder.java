package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PrairiedogsViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView AnimalNameView;
    private TextView AnimalInfo1;
    private ImageView AnimalPhotoView;
    private Context context;

    public PrairiedogsViewHolder(View itemView, Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.prairiedog_card_view);
        AnimalInfo1 = (TextView) itemView.findViewById(R.id.prairiedog_info1);
        AnimalNameView = (TextView) itemView.findViewById(R.id.prairiedog_name);
        AnimalPhotoView = (ImageView) itemView.findViewById(R.id.prairiedog_photo);
        this.context = context;
    }

    public void bind(final prairiedogs prairiedogs) {
        AnimalNameView.setText(prairiedogs.prairiedogs_name);
        AnimalInfo1.setText(prairiedogs.prairiedogs_info);
        AnimalPhotoView.setImageResource(prairiedogs.prairiedogs_photoId);
    }
}