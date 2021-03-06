package com.kimeeo.kAndroidDemos.services.rss;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.recyclerView.verticalViews.ListView;
import com.kimeeo.kAndroidDemos.R;

import org.mcsoxford.rss.RSSItem;

/**
 * Created by BhavinPadhiyar on 02/05/16.
 */
public class RSSRecyclerViewVertical extends ListView{
    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_view_item,viewGroup,false);
    }
    @Override
    public BaseItemHolder getItemHolder(int i, View view){
        return new BaseItemHolder1(view);
    }

    @NonNull
    @Override
    protected DataProvider createDataProvider() {
        return new RSSDataProviderExample();
    }

    public class BaseItemHolder1 extends BaseItemHolder
    {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }
        @Override
        public void updateItemView(Object o, View view, int i) {
            RSSItem data = (RSSItem) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i +". "+data.getTitle());
        }
    }
}
