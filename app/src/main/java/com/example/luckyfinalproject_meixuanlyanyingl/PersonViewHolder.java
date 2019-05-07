package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView AnimalNameView;
    private TextView AnimalInfo1;
    private ImageView AnimalPhotoView;
    private Context context;

    public PersonViewHolder(View itemView, Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        AnimalInfo1 = (TextView) itemView.findViewById(R.id.animal_info1);
        AnimalNameView = (TextView) itemView.findViewById(R.id.animal_name);
        AnimalPhotoView = (ImageView) itemView.findViewById(R.id.animal_photo);
        this.context = context;
    }

    public void bind(final Person person) {
        AnimalNameView.setText(person.name);
        AnimalInfo1.setText(person.info1);
        AnimalPhotoView.setImageResource(person.photoId);
    }
}