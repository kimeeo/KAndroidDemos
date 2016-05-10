package com.kimeeo.kAndroidDemos.greedo;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;

/**
 * Created by bpa001 on 5/8/16.
 */
public class SimpleList500pxStyleView extends GreedoView {

    @Override
    protected double getAspectRatioFor(int index, Object o) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getActivity().getResources(), 1, options);
        return options.outWidth / (double) options.outHeight;
    }



    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public BaseItemHolder getItemHolder(int i, View view) {
        return null;
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return null;
    }
}
