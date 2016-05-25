package com.kimeeo.kAndroidDemos.oldListView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroid.listViews.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.listView.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.listView.BaseListViewAdapter;
import com.kimeeo.kAndroid.listViews.listView.DefaultListViewAdapter;
import com.kimeeo.kAndroid.listViews.listView.IViewProvider;
import com.kimeeo.kAndroid.listViews.viewHelper.ListViewHelper;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 21/05/16.
 */
public class Helper extends BaseFragment implements IViewProvider {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        DataProvider dataManager = createDataProvider();

        View rootView;
        if (dataManager.getRefreshEnabled())
            rootView = inflater.inflate(R.layout._fragment_list_view_with_swipe_refresh_layout, container, false);
        else
            rootView = inflater.inflate(R.layout._fragment_list_view, container, false);

        ListViewHelper helper = new ListViewHelper();
        android.widget.ListView listView = (android.widget.ListView) rootView.findViewById(R.id.listView);
        helper.with(listView);

        if (rootView.findViewById(R.id.swipeRefreshLayout) != null) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
            helper.swipeRefreshLayout(swipeRefreshLayout);
        }

        View emptyView = rootView.findViewById(R.id.emptyView);
        if (emptyView != null)
            helper.emptyView(emptyView);

        BaseListViewAdapter adapter = createListViewAdapter(dataManager);
        helper.adapter(adapter);


        helper.dataManager(dataManager);
        helper.setOnItemClick(new ListViewHelper.OnItemClick() {
            @Override
            public void onItemClick(Object baseObject) {
                Toast.makeText(getActivity(), baseObject.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        try {
            helper.create();
        } catch (Exception e) {
        }

        return rootView;
    }

    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        return linearLayoutManager;
    }


    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_view_item_card_view, viewGroup, false);
    }

    @Override
    public BaseItemHolder getItemHolder(int i, View view) {
        return new BaseItemHolder1(view);
    }

    @Override
    public int getTotalViewTypeCount() {
        return 1;
    }


    @Override
    public int getListItemViewType(int i, Object o) {
        return 1;
    }

    protected BaseListViewAdapter createListViewAdapter(DataProvider dataManager) {
        return new DefaultListViewAdapter(dataManager, this);
    }

    @NonNull
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
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
