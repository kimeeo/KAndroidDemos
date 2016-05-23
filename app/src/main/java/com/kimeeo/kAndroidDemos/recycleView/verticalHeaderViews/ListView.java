package com.kimeeo.kAndroidDemos.recycleView.verticalHeaderViews;

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
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class ListView extends com.kimeeo.kAndroid.listViews.recyclerView.verticalHeaderViews.ListView {
    @Override
    public View getNormalItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_view_item, viewGroup, false);
    }

    @Override
    public BaseItemHolder getNormalItemHolder(int i, View view) {
        return new BaseItemHolder1(view);
    }

    @Override
    public View createHeaderView(LayoutInflater inflater, ViewGroup container, Object data) {
        View view = inflater.inflate(R.layout.fragment_header_page_view, container, false);
        return view;
    }


    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    public class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            if (o instanceof DataBean) {
                DataBean data = (DataBean) o;
                TextView title = (TextView) view.findViewById(R.id.title);
                title.setText(i + ". " + data.getName());
            }
        }
    }
}
