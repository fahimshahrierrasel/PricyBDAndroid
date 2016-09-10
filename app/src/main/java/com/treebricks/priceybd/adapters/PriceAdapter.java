package com.treebricks.priceybd.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.activities.ShopActivity;
import com.treebricks.priceybd.models.MobilePrice;
import com.treebricks.priceybd.models.Shop;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahim on 8/29/16.
 */
public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.PriceViewHolder> {

    public static final String SHOP_NAME = "SHOP_NAME";
    public static final String SHOP_ADDRESS = "SHOP_ADDRESS";
    public static final String SHOP_MOBILE_NUMBER = "SHOP_MOBILE_NUMBER";
    public static final String SHOP_EMAIL = "SHOP_EMAIL";
    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "LONGITUDE";
    Context context;
    ArrayList<MobilePrice> mobilePrices;

    public PriceAdapter(Context context, ArrayList<MobilePrice> mobilePrices)
    {
        this.context = context;
        this.mobilePrices = mobilePrices;
    }

    public static class PriceViewHolder extends RecyclerView.ViewHolder{

        public final TextView priceText;
        public final TextView shopNameText;
        public final CardView priceCard;

        public PriceViewHolder(View view)
        {
            super(view);
            priceCard = (CardView) view.findViewById(R.id.price_card);
            priceText = (TextView) view.findViewById(R.id.price_text);
            shopNameText = (TextView) view.findViewById(R.id.shop_name);
        }
    }

    @Override
    public PriceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(this.context).inflate(R.layout.price_card, parent, false);

        return new PriceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PriceViewHolder holder, int position)
    {
        holder.priceText.setText(String.format("%s BDT", mobilePrices.get(position).getPrice()));
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final Shop[] newShop = new Shop[1];
        Call<Shop> call = apiInterface.getshop(Integer.parseInt(mobilePrices.get(position).getShopId()));
        call.enqueue(new Callback<Shop>() {
            @Override
            public void onResponse(Call<Shop> call, Response<Shop> response) {
                newShop[0] = response.body();
                holder.shopNameText.setText(newShop[0].getShopName());
            }

            @Override
            public void onFailure(Call<Shop> call, Throwable t) {

            }
        });
        holder.priceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent shopIntent = new Intent(context, ShopActivity.class);
                Bundle sentBundle = new Bundle();
                sentBundle.putString(SHOP_NAME, newShop[0].getShopName());
                sentBundle.putString(SHOP_ADDRESS, newShop[0].getShopAddress());
                sentBundle.putString(SHOP_MOBILE_NUMBER, newShop[0].getShopMobileNumber());
                sentBundle.putString(SHOP_EMAIL, newShop[0].getShopMail());
                sentBundle.putString(LATITUDE, newShop[0].getLatitude());
                sentBundle.putString(LONGITUDE, newShop[0].getLongitude());
                shopIntent.putExtras(sentBundle);
                context.startActivity(shopIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.mobilePrices.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
