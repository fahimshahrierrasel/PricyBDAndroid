package com.treebricks.priceybd.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.adapters.PriceAdapter;
import com.treebricks.priceybd.models.AllPrices;
import com.treebricks.priceybd.models.MobilePrice;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;
import java.util.ArrayList;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahim on 8/29/16.
 */
public class PriceFragment extends Fragment
{
    private static final String MOBILE_ID = "MOBILE_ID";

    public static PriceFragment newInstance(int mobileId)
    {
        PriceFragment priceFragment = new PriceFragment();
        final Bundle args = new Bundle();

        args.putInt(MOBILE_ID, mobileId);
        priceFragment.setArguments(args);
        return priceFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.price_fragment, container, false);

        RecyclerView priceRecycler = (RecyclerView) rootView.findViewById(R.id.price_recycler);

        LinearLayoutManager priceLinearLayoutManager =
                new LinearLayoutManager(PriceFragment.this.getContext(), LinearLayoutManager.VERTICAL, false);


        int mobileId = getArguments().getInt(MOBILE_ID);

        priceRecycler.setLayoutManager(priceLinearLayoutManager);

        new PriceTask(PriceFragment.this.getContext(), mobileId, priceRecycler).execute(priceRecycler);

        return rootView;
    }

    class PriceTask extends AsyncTask<RecyclerView,Void,Void>
    {
        ProgressDialog progress;
        RecyclerView recyclerView;
        ArrayList<MobilePrice> mobilePrices;
        int mobileId;
        Context context;

        public PriceTask(Context context, int mobileId, RecyclerView recyclerView)
        {
            this.context = context;
            this.mobileId = mobileId;
            this.recyclerView = recyclerView;
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(context, "Loading","Please Wait", true);
        }

        @Override
        protected Void doInBackground(final RecyclerView... recyclerViews) {


            recyclerView = recyclerViews[0];

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

            Call<AllPrices> call = apiInterface.getAllPrices(mobileId);
            call.enqueue(new Callback<AllPrices>() {
                @Override
                public void onResponse(Call<AllPrices> call, Response<AllPrices> response) {

                    mobilePrices = (ArrayList<MobilePrice>) response.body().getPrices();

                    PriceAdapter priceAdapter = new PriceAdapter(context, mobilePrices);
                    recyclerView.setAdapter(new ScaleInAnimationAdapter(priceAdapter));
                    progress.cancel();

                }

                @Override
                public void onFailure(Call<AllPrices> call, Throwable t) {

                }
            });
            return null;
        }

    }

}
