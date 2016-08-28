package com.treebricks.priceybd.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.treebricks.priceybd.R;

/**
 * Created by fahim on 8/26/16.
 */
public class SpecificationFragment extends Fragment
{
    private static final String SPECIFICATION = "SPECIFICATION";

    public SpecificationFragment(){}

    public static SpecificationFragment newInstance(String text)
    {
        SpecificationFragment specificationFragment = new SpecificationFragment();
        Bundle args = new Bundle();
        args.putString(SPECIFICATION, text);
        specificationFragment.setArguments(args);
        return specificationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.specification_fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getArguments().getString(SPECIFICATION));
        return  rootView;
    }
}
