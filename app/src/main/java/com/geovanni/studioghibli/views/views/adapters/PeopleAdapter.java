package com.geovanni.studioghibli.views.views.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesDb;
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.geovanni.studioghibli.views.customViews.CustomTypefaceSpan;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<ServicePeopleResponse> people;
    private List<ServiceImagesDb> images;
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

        holder.txvNamePeople.setText(setTypeFaceToText("Name: ", people.get(position).getName()));
        holder.txvGenderPeople.setText(setTypeFaceToText("Gender: ", people.get(position).getGender()));
        holder.txvAgePeople.setText(setTypeFaceToText("Age: ", people.get(position).getAge()));
        holder.txvEyeColor.setText(setTypeFaceToText("Eye Color: ", people.get(position).getEye_color()));
        holder.txvHairColor.setText(setTypeFaceToText("Hair Color: ", people.get(position).getHair_color()));

        if (images != null && images.size() > 0) {
            for (ServiceImagesDb image : images) {

                if (image.getSection().equals("People")) {
                    if (image.getTitle().equals(person.getName())) {
                        setImageToPerson(holder, image.getUrl());
                    }
                }
            }
        } else {
            setImageToPerson(holder, "");
        }
    }

    private Spannable setTypeFaceToText(String field, String value) {
        SpannableStringBuilder spannableString = new SpannableStringBuilder(field + value);

        int dots = field.indexOf(":");

        spannableString.setSpan(new CustomTypefaceSpan("", boldGhibli), 0, dots, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new CustomTypefaceSpan("", lightGhibli), dots, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        return spannableString;
    }

    private void setImageToPerson(final ViewHolder holder, String url) {

        Picasso.get()
                .load(url)
                .error(R.drawable.ic_studio_ghibli)
                .placeholder(R.drawable.ic_studio_ghibli)
                .fit()
                .centerCrop()
                .into(holder.civPerson, new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap imageBitmap = ((BitmapDrawable) holder.civPerson.getDrawable()).getBitmap();
                        RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), imageBitmap);
                        imageDrawable.setCircular(true);
                        imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                        holder.civPerson.setImageDrawable(imageDrawable);
                    }

                    @Override
                    public void onError(Exception e) {
                        holder.civPerson.setImageResource(R.drawable.ic_studio_ghibli);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void replaceData(List<ServicePeopleResponse> people, List<ServiceImagesDb> images) {
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
        private AppCompatImageView civPerson;

        public ViewHolder(View itemView) {
            super(itemView);

            txvNamePeople = itemView.findViewById(R.id.txvNamePeople);
            txvGenderPeople = itemView.findViewById(R.id.txvGenderPeople);
            txvAgePeople = itemView.findViewById(R.id.txvAgePeople);
            txvEyeColor = itemView.findViewById(R.id.txvEyeColor);
            txvHairColor = itemView.findViewById(R.id.txvHairColor);

            civPerson = itemView.findViewById(R.id.civPerson);

        }
    }
}
