package com.geovanni.studioghibli.views.views.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<ServicePeopleResponse> people;
    private List<ServiceImagesResponse> images;
    private Context context;
    private Typeface lightGhibli, boldGhibli;

    public PeopleAdapter(Context context) {
        this.people = new ArrayList<>();
        this.images = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people_row, parent, false);
        PeopleAdapter.ViewHolder viewHolder = new PeopleAdapter.ViewHolder(view);
        lightGhibli = Typeface.createFromAsset(context.getAssets(), "fonts/ghibli.ttf");
        boldGhibli = Typeface.createFromAsset(context.getAssets(), "fonts/ghibli_bold.ttf");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ServicePeopleResponse person = people.get(position);

        holder.txvNamePeople.setText("Name: " + people.get(position).getName());
        holder.txvGenderPeople.setText("Gender: " + people.get(position).getGender());
        holder.txvAgePeople.setText("Age: " + people.get(position).getAge());
        holder.txvEyeColor.setText("Eye Color: " + people.get(position).getEye_color());
        holder.txvHairColor.setText("Hair Color: " + people.get(position).getHair_color());

        if (images != null && images.size() > 0) {
            for (ServiceImagesResponse image : images) {
                if (image.getTitle().equals(person.getName())) {
                    setImageToPerson(holder, image.getUrl());
                }
            }
        } else {
            setImageToPerson(holder, "");
        }
    }

    private void setImageToPerson(ViewHolder holder, String url) {
        Picasso.get()
                .load(url)
                .error(R.drawable.ic_studio_ghibli)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .placeholder(R.drawable.ic_studio_ghibli)
                .fit().centerCrop()
                .into(holder.imvPerson);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void replaceData(List<ServicePeopleResponse> people, List<ServiceImagesResponse> images) {
        if (people != null) {
            this.people = people;
        }
        if (images != null) {
            this.images = images;
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txvNamePeople, txvGenderPeople, txvAgePeople, txvEyeColor, txvHairColor;
        private ImageView imvPerson;

        public ViewHolder(View itemView) {
            super(itemView);

            txvNamePeople = (TextView) itemView.findViewById(R.id.txvNamePeople);
            txvGenderPeople = (TextView) itemView.findViewById(R.id.txvGenderPeople);
            txvAgePeople = (TextView) itemView.findViewById(R.id.txvAgePeople);
            txvEyeColor = (TextView) itemView.findViewById(R.id.txvEyeColor);
            txvHairColor = (TextView) itemView.findViewById(R.id.txvHairColor);

            imvPerson = (ImageView) itemView.findViewById(R.id.imvPerson);
        }
    }
}
