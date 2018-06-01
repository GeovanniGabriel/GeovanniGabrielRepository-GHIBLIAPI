package com.geovanni.studioghibli.views.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geovanni.studioghibli.R;
import com.geovanni.studioghibli.views.bussiness.models.ServiceFilmResponse;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<ServiceFilmResponse> films;
    private Context context;

    public FilmsAdapter(Context context) {
        this.films = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ServiceFilmResponse film = films.get(position);

        holder.nameFilmTextView.setText(film.getTitle());
        holder.txvDirector.setText("Director: " + film.getDirector());
        holder.txvReleaseDate.setText("Release date: " + film.getReleaseDate());
        holder.txvDescription.setText(film.getDescription());


        switch (film.getTitle()) {
            case "Castle in the Sky":
                setImageToFilm(holder, R.drawable.ic_castle_in_the_sky);
                break;

            case "Grave of the Fireflies":
                setImageToFilm(holder, R.drawable.ic_grave_of_the_fireflies);
                break;

            case "My Neighbor Totoro":
                setImageToFilm(holder, R.drawable.ic_my_neighbor_totoro);
                break;

            case "Kiki's Delivery Service":
                setImageToFilm(holder, R.drawable.ic_kikis_delivery_service);
                break;

            case "Only Yesterday":
                setImageToFilm(holder, R.drawable.ic_only_yesterday);
                break;

            case "Porco Rosso":
                setImageToFilm(holder, R.drawable.ic_porco_rosso);
                break;

            case "Pom Poko":
                setImageToFilm(holder, R.drawable.ic_pom_poko);
                break;

            case "Whisper of the Heart":
                setImageToFilm(holder, R.drawable.ic_whisper_of_the_heart);
                break;

            case "Princess Mononoke":
                setImageToFilm(holder, R.drawable.ic_princess_mononoke);
                break;

            case "My Neighbors the Yamadas":
                setImageToFilm(holder, R.drawable.ic_my_neighbors_the_yamadas);
                break;

            case "Spirited Away":
                setImageToFilm(holder, R.drawable.ic_spirited_away);
                break;

            case "The Cat Returns":
                setImageToFilm(holder, R.drawable.ic_the_cat_returns);
                break;

            case "Howl's Moving Castle":
                setImageToFilm(holder, R.drawable.ic_howls_moving_castle);
                break;

            case "Tales from Earthsea":
                setImageToFilm(holder, R.drawable.ic_tales_from_earthsea);
                break;

            case "Ponyo":
                setImageToFilm(holder, R.drawable.ic_ponyo);
                break;

            case "Arrietty":
                setImageToFilm(holder, R.drawable.ic_arrietty);
                break;

            case "From Up on Poppy Hill":
                setImageToFilm(holder, R.drawable.ic_from_on_poppy_hill);
                break;

            case "The Wind Rises":
                setImageToFilm(holder, R.drawable.ic_the_wind_rises);
                break;

            case "The Tale of the Princess Kaguya":
                setImageToFilm(holder, R.drawable.ic_tale_of_the_princess_kaguya);
                break;

            case "When Marnie Was There":
                setImageToFilm(holder, R.drawable.ic_when_marine_was_there);
                break;

            default:
                setImageToFilm(holder, R.drawable.ic_studio_ghibli);
                break;

        }

    }

    private void setImageToFilm(ViewHolder holder, int resourceId) {
        Picasso.get()
                .load(resourceId)
                .error(resourceId)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .placeholder(R.drawable.ic_studio_ghibli)
                .fit().centerCrop()
                .into(holder.imvFilm);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void replaceData(List<ServiceFilmResponse> films) {
        if (films != null) {
            this.films = films;
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imvFilm;
        private TextView txvDirector, nameFilmTextView, txvReleaseDate, txvDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            imvFilm = (ImageView) itemView.findViewById(R.id.imvFilm);
            txvDirector = (TextView) itemView.findViewById(R.id.txvDirector);
            nameFilmTextView = (TextView) itemView.findViewById(R.id.txvNameFilm);
            txvReleaseDate = (TextView) itemView.findViewById(R.id.txvReleaseDate);
            txvDescription = (TextView) itemView.findViewById(R.id.txvDescription);

        }
    }

}
