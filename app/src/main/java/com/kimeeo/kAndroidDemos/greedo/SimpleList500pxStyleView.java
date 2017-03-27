package com.kimeeo.kAndroidDemos.greedo;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by bpa001 on 5/8/16.
 */
public class SimpleList500pxStyleView extends GreedoView {

    @Override
    protected double getAspectRatioFor(int index, Object o) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.bubble_shadow, options);
        return options.outWidth / (double) options.outHeight;
    }



    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_view_item, viewGroup, false);
    }

    @Override
    public BaseItemHolder getItemHolder(int i, View view) {
        return new BaseItemHolder1(view);
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, false);
    }

    public class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            DataBean data = (DataBean) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i + ". " + data.getName());
        }
    }
}
