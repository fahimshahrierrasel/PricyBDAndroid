package com.treebricks.priceybd.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.treebricks.priceybd.activities.DeviceActivity;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.models.MobileShortDetail;
import java.util.ArrayList;

/**
 * Created by fahim on 8/25/16.
 */
public class DeviceShortDetailAdapter extends RecyclerView.Adapter<DeviceShortDetailAdapter.SimpleViewHolder> {

    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String DEVICE_IMAGE = "DEVICE_IMAGE";
    public static final String MOBILE_ID = "MOBILE_ID";
    private Context context;
    ArrayList<MobileShortDetail> allDevices;
    int size;

    public DeviceShortDetailAdapter(Context context, ArrayList<MobileShortDetail> allDevices, int size) {
        this.context = context;
        this.allDevices = allDevices;
        this.size = size;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView cardImageView;
        public final TextView cardText;

        public SimpleViewHolder(View view) {
            super(view);
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
        Glide.with(context).load(allDevices.get(position).getPhoto())
                .error(R.drawable.smartphone)
                .placeholder(R.drawable.smartphone)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.cardImageView);

        holder.cardText.setText(allDevices.get(position).getModelName());
        holder.cardImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Position =" + position, Toast.LENGTH_SHORT).show();
                Bundle sentBundle = new Bundle();
                sentBundle.putString(DEVICE_NAME, allDevices.get(position).getModelName());
                sentBundle.putString(DEVICE_IMAGE, allDevices.get(position).getPhoto());
                sentBundle.putInt(MOBILE_ID, position+1);
                Intent deviceIntent = new Intent(context, DeviceActivity.class);
                deviceIntent.putExtras(sentBundle);
                context.startActivity(deviceIntent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return size;
    }

}
