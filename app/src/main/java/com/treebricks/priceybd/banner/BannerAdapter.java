package com.treebricks.priceybd.banner;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.treebricks.priceybd.R;

/**
 * Created by fahim on 8/25/16.
 */
public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.SimpleViewHolder> {

    private Context context;
    private int[] images;

    public BannerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;

        public SimpleViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.banner_image);

        }


    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.banner_layout,parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), images[position], null));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Position =" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.images.length;
    }

}
