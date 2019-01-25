package com.example.coder_kun.internshipapplicationsoleeklab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

    private List<CountryModel> countries ;
    public RecyclerAdapter(List<CountryModel> countries){
        this.countries = countries;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.Country.setText(countries.get(i).getCountry());
        viewHolder.Capital.setText(countries.get(i).getCountry());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Country,Capital;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Country = (TextView) itemView.findViewById(R.id.countryname);
            Capital = (TextView) itemView.findViewById(R.id.capitalname);
        }
    }
}
