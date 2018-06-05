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
import com.geovanni.studioghibli.views.bussiness.models.ServicePeopleResponse;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Broxel Labs.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<ServicePeopleResponse> people;
    private Context context;

    public PeopleAdapter(Context context) {
        this.people = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people_row, parent, false);
        PeopleAdapter.ViewHolder viewHolder = new PeopleAdapter.ViewHolder(view);
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

        switch (person.getName()) {
            case "Ashitaka":
                setImageToPerson(holder, R.drawable.ic_ashitaka);
                break;

            case "San":
                setImageToPerson(holder, R.drawable.ic_san);
                break;

            case "Eboshi":
                setImageToPerson(holder, R.drawable.ic_eboshi);
                break;

            case "Jigo":
                setImageToPerson(holder, R.drawable.ic_jigo);
                break;

            case "Kohroku":
                setImageToPerson(holder, R.drawable.ic_kohroku);
                break;

            case "Gonza":
                setImageToPerson(holder, R.drawable.ic_gonza);
                break;

            case "Hii-sama":
                setImageToPerson(holder, R.drawable.ic_hiisama);
                break;

            case "Yakul":
                setImageToPerson(holder, R.drawable.ic_yakul);
                break;

            case "Shishigami":
                setImageToPerson(holder, R.drawable.ic_shishigami);
                break;

            case "Moro":
                setImageToPerson(holder, R.drawable.ic_moro);
                break;

            case "Jiji":
                setImageToPerson(holder, R.drawable.ic_jiji);
                break;

            case "Satsuki Kusakabe":
                setImageToPerson(holder, R.drawable.ic_satsukikusakobe);
                break;

            case "Mei Kusakabe":
                setImageToPerson(holder, R.drawable.ic_meikusakabe);
                break;

            case "Tatsuo Kusakabe":
                setImageToPerson(holder, R.drawable.ic_tatsuokusakabe);
                break;

            case "Yasuko Kusakabe":
                setImageToPerson(holder, R.drawable.ic_yasukokusakabe);
                break;

            case "Granny":
                setImageToPerson(holder, R.drawable.ic_granny);
                break;

            case "Kanta Ogaki":
                setImageToPerson(holder, R.drawable.ic_kantaogaki);
                break;

            case "Totoro":
                setImageToPerson(holder, R.drawable.ic_totoro);
                break;

            case "Chu Totoro":
                setImageToPerson(holder, R.drawable.ic_chutotoro);
                break;

            case "Chibi Totoro":
                setImageToPerson(holder, R.drawable.ic_chibi_totoro);
                break;

            case "Catbus":
                setImageToPerson(holder, R.drawable.ic_catbus);
                break;

            case "Niya":
                setImageToPerson(holder, R.drawable.ic_niya);
                break;

            case "Renaldo Moon aka Moon aka Muta":
                setImageToPerson(holder, R.drawable.ic_renaldomoonakamoonakamuta);
                break;

            case "Cat King":
                setImageToPerson(holder, R.drawable.ic_catking);
                break;

            case "Yuki":
                setImageToPerson(holder, R.drawable.ic_yuki);
                break;

            case "Haru":
                setImageToPerson(holder, R.drawable.ic_haru);
                break;

            case "Baron Humbert von Gikkingen":
                setImageToPerson(holder, R.drawable.ic_baronhumbertvongikkingen);
                break;

            case "Natori":
                setImageToPerson(holder, R.drawable.ic_natori);
                break;

            case "Colonel Muska":
                setImageToPerson(holder, R.drawable.ic_colonelmuska);
                break;

            case "Porco Rosso":
                setImageToPerson(holder, R.drawable.ic_porkorosso);
                break;

            case "Sosuke":
                setImageToPerson(holder, R.drawable.ic_sosuke);
                break;


            default:
                setImageToPerson(holder, R.drawable.ic_studio_ghibli);
                break;

        }
    }

    private void setImageToPerson(PeopleAdapter.ViewHolder holder, int resourceId) {
        Picasso.get()
                .load(resourceId)
                .error(resourceId)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .placeholder(R.drawable.ic_studio_ghibli)
                .fit().centerCrop()
                .into(holder.imvPerson);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void replaceData(List<ServicePeopleResponse> people) {
        if (people != null) {
            this.people = people;
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
