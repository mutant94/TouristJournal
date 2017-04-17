package com.example.lukaszt.touristjournal.objects.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lukaszt.touristjournal.R;
import com.example.lukaszt.touristjournal.activity.MenuPlaceActivity;
import com.example.lukaszt.touristjournal.objects.TouristCity;
import com.example.lukaszt.touristjournal.objects.TouristPlace;

import java.util.List;

/**
 * Created by Gamer on 15.04.2017.
 */

public class AdapterRVPlace extends RecyclerView.Adapter<AdapterRVPlace.ViewHolderPlace> {

    private List<TouristPlace> touristPlaceList;
    private Activity activity;

    public AdapterRVPlace(List<TouristPlace> touristPlaceList, Activity activity) {
        this.touristPlaceList = touristPlaceList;
        this.activity = activity;
    }

    public static class ViewHolderPlace extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        protected Activity activity;
        protected TouristPlace place;
        protected TextView name;
        protected TextView desription;
        protected ImageView imageView;

        protected ViewHolderPlace(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AdapterRVPlace.ViewHolderPlace.this.onClick();
                }
            });
            this.name = (TextView) view.findViewById(R.id.cardview_city_title);
            this.desription = (TextView) view.findViewById(R.id.cardview_city_description);
            this.imageView = (ImageView) view.findViewById(R.id.cardview_city_image);
        }

        public void onClick() {
            Intent intent = new Intent(activity, MenuPlaceActivity.class);
            intent.putExtra(MenuPlaceActivity.CITY_INTENT_KEY, place.name());
            activity.startActivity(intent);
        }
    }

    @Override
    public AdapterRVPlace.ViewHolderPlace onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_city, parent, false);
        return new AdapterRVPlace.ViewHolderPlace(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterRVPlace.ViewHolderPlace holder, int position) {
        TouristPlace place = touristPlaceList.get(position);
        holder.name.setText(activity.getResources().getString(place.nameId));
        holder.desription.setText(activity.getResources().getString(place.shortDescriptionId));
        holder.imageView.setImageBitmap(Bitmap.createBitmap(BitmapFactory.decodeResource(activity.getResources(), place.imageResource)));
        holder.activity = this.activity;
        holder.place = place;
    }

    @Override
    public int getItemCount() {
        return touristPlaceList.size();
    }

}