package com.treebricks.priceybd.adapters;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.treebricks.priceybd.R;

/**
 * Created by fahim on 8/25/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.SimpleViewHolder> {

    private Context context;
    private int[] images;
    private String[] texts;

    public RecyclerAdapter(Context context, int[] images, String[] texts) {
        this.context = context;
        this.images = images;
        this.texts = texts;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView cardImageView;
        public final TextView cardText;

        public SimpleViewHolder(View view) {
            super(view);
            cardImageView = (ImageView) view.findViewById(R.id.card_image_view);
            cardText = (TextView) view.findViewById(R.id.card_text);
        }


    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.recycler_card_layout,parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.cardImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), images[position], null));
        holder.cardText.setText(texts[position]);
        holder.cardImageView.setOnClickListener(new View.OnClickListener() {
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
