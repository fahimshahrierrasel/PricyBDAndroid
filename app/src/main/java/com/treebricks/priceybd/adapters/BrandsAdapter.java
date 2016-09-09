package com.treebricks.priceybd.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.activities.AllDevice;
import com.treebricks.priceybd.models.Brand;
import java.util.ArrayList;

/**
 * Created by fahim on 9/1/16.
 */
public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.SimpleViewHolder> {
    private static final String TITLE = "TITLE";
    private static final String CATAGORY = "CATAGORY";

    ArrayList<Brand> allBrands;
    Context context;
    int size;

    public BrandsAdapter(Context context, ArrayList<Brand> allBrands, int size) {
        this.allBrands = allBrands;
        this.context = context;
        this.size = size;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView cardImageView;
        public final TextView cardText;
        private final CardView brandCard;

        public SimpleViewHolder(View view) {
            super(view);
            brandCard = (CardView) view.findViewById(R.id.short_device_card);
            cardImageView = (ImageView) view.findViewById(R.id.card_image_view);
            cardText = (TextView) view.findViewById(R.id.network_header);
        }
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.short_detail_card,parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {

        Glide.with(context)
                .load(allBrands.get(position).getBrandImage())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.cardImageView);
        holder.cardText.setText(allBrands.get(position).getBrandName());

        holder.brandCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allDevicesIntent = new Intent(context, AllDevice.class);
                allDevicesIntent.putExtra(TITLE, allBrands.get(position).getBrandName());
                allDevicesIntent.putExtra(CATAGORY,"Brand");
                context.startActivity(allDevicesIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
