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
import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.geovanni.studioghibli.views.bussiness.models.ServiceImagesDb;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<ServiceFilmResponse> films;
    private List<ServiceImagesDb> images;
    private Context context;
    private Typeface lightGhibli, boldGhibli;

    public FilmsAdapter(Context context) {
        this.films = new ArrayList<>();
        this.images = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        lightGhibli = Typeface.createFromAsset(context.getAssets(), "fonts/ghibli.ttf");
        boldGhibli = Typeface.createFromAsset(context.getAssets(), "fonts/ghibli_bold.ttf");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ServiceFilmResponse film = films.get(position);

        holder.txvNameFilm.setText(film.getTitle());
        holder.txvNameFilm.setTypeface(boldGhibli);

        holder.txvDirector.setText("Director: " + film.getDirector());
        holder.txvDirector.setTypeface(lightGhibli);

        holder.txvReleaseDate.setText("Release date: " + film.getRelease_date());
        holder.txvReleaseDate.setTypeface(lightGhibli);

        holder.txvDescription.setText(film.getDescription());
        holder.txvDescription.setTypeface(lightGhibli);

        if (images != null && images.size() > 0) {
            for (ServiceImagesDb image : images) {

                if (image.getSection().equals("Movies")) {
                    if (image.getTitle().equals(film.getTitle())) {
                        setImageToFilm(holder, image.getUrl());
                    }
                }
            }
        } else {
            setImageToFilm(holder, "");
        }

    }

    private void setImageToFilm(ViewHolder holder, String url) {
        Picasso.get()
                .load(url)
                .error(R.drawable.ic_studio_ghibli)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .placeholder(R.drawable.ic_studio_ghibli)
                .fit().centerCrop()
                .into(holder.imvFilm);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void replaceData(List<ServiceFilmResponse> films, List<ServiceImagesDb> images) {
        if (films != null) {
            this.films = films;
        }
        if (images != null) {
            this.images = images;
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imvFilm;
        private TextView txvDirector, txvNameFilm, txvReleaseDate, txvDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            imvFilm = (ImageView) itemView.findViewById(R.id.imvFilm);
            txvDirector = (TextView) itemView.findViewById(R.id.txvDirector);
            txvNameFilm = (TextView) itemView.findViewById(R.id.txvNameFilm);
            txvReleaseDate = (TextView) itemView.findViewById(R.id.txvReleaseDate);
            txvDescription = (TextView) itemView.findViewById(R.id.txvDescription);

        }
    }

}
