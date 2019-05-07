package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class catsViewHolder  extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView AnimalNameView;
    private TextView AnimalInfo1;
    private ImageView AnimalPhotoView;
    private Context context;

    public catsViewHolder(View itemView, Context context) {
        super (itemView);
        cardView = (CardView) itemView.findViewById(R.id.cat_card_view);
        AnimalInfo1 = (TextView) itemView.findViewById(R.id.cat_info1);
        AnimalNameView = (TextView) itemView.findViewById(R.id.cat_name);
        AnimalPhotoView = (ImageView) itemView.findViewById(R.id.cat_photo);
        this.context = context;
    }

    public void bind(final cats cats) {
        AnimalNameView.setText(cats.cat_name);
        AnimalInfo1.setText(cats.cat_info);
        AnimalPhotoView.setImageResource(cats.cat_photoId);
    }
}
