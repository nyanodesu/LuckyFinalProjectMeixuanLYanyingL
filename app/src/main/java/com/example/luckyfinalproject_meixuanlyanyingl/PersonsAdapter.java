package com.example.luckyfinalproject_meixuanlyanyingl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private List<Person> persons;
    private Context context;

    public PersonsAdapter(List<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_presidents, parent, false);
        return new PersonViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {

        Person person = persons.get(position);
        holder.bind(person);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}