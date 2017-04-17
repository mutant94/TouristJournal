package com.example.lukaszt.touristjournal.objects.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lukaszt.touristjournal.R;
import com.example.lukaszt.touristjournal.activity.MenuPlaceActivity;
import com.example.lukaszt.touristjournal.objects.TouristCity;

import java.util.List;

/**
 * Created by Gamer on 15.04.2017.
 */

public class AdapterRVCity extends RecyclerView.Adapter<AdapterRVCity.ViewHolderCity> {

    private List<TouristCity> touristCityList;
    private Activity activity;

    public AdapterRVCity(List<TouristCity> touristCityList, Activity activity) {
        this.touristCityList = touristCityList;
        this.activity = activity;
    }

    public static class ViewHolderCity extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        protected Activity activity;
        protected TouristCity city;
        protected TextView name;
        protected TextView desription;
        protected ImageView imageView;
        protected ViewHolderCity(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ViewHolderCity.this.onClick();
                }
            });
            this.name = (TextView) view.findViewById(R.id.cardview_city_title);
            this.desription = (TextView) view.findViewById(R.id.cardview_city_description);
            this.imageView = (ImageView) view.findViewById(R.id.cardview_city_image);
        }

        public void onClick() {
            Intent intent = new Intent(activity, MenuPlaceActivity.class);
            intent.putExtra(MenuPlaceActivity.CITY_INTENT_KEY, city.name());
            activity.startActivity(intent);
        }
    }

    @Override
    public ViewHolderCity onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_city, parent, false);
        return new ViewHolderCity(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderCity holder, int position) {
        TouristCity city = touristCityList.get(position);
        holder.name.setText(activity.getResources().getString(city.nameId));
        holder.desription.setText(activity.getResources().getString(city.descriptionId));
        holder.imageView.setImageBitmap(Bitmap.createBitmap(BitmapFactory.decodeResource(activity.getResources(), city.imageResource)));
        holder.activity = this.activity;
        holder.city = city;
    }

    @Override
    public int getItemCount() {
        return touristCityList.size();
    }
}
