package com.treebricks.priceybd.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.treebricks.priceybd.R;
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
        holder.priceText.setText(mobilePrices.get(position).getPrice() + " BDT");
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
                Toast.makeText(view.getContext(), newShop[0].toString(),Toast.LENGTH_LONG).show();
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
