package com.treebricks.priceybd.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.treebricks.priceybd.R;
import java.util.ArrayList;

/**
 * Created by fahim on 8/29/16.
 */
public class DeviceDetailAdapter extends RecyclerView.Adapter<DeviceDetailAdapter.DeviceDetailsViewHolder> {

    Context context;
    ArrayList<String> specifications;

    public DeviceDetailAdapter(Context context, ArrayList<String> specifications) {
        this.specifications = specifications;
        this.context = context;
    }


    public static class DeviceDetailsViewHolder extends RecyclerView.ViewHolder {
        public final TextView cardText;

        public DeviceDetailsViewHolder(View view) {
            super(view);
            cardText = (TextView) view.findViewById(R.id.card_text);
        }


    }

    @Override
    public DeviceDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.specification_card, parent, false);
        return new DeviceDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceDetailsViewHolder holder, int position)
    {
        holder.cardText.setText(specifications.get(position));
    }

    @Override
    public int getItemCount() {
        return this.specifications.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
