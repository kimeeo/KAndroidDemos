package com.kimeeo.kAndroidDemos.recycleView;

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
import com.kimeeo.kAndroid.listViews.recyclerView.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.recyclerView.BaseRecyclerViewAdapter;
import com.kimeeo.kAndroid.listViews.recyclerView.DefaultRecyclerViewAdapter;
import com.kimeeo.kAndroid.listViews.recyclerView.IViewProvider;
import com.kimeeo.kAndroid.listViews.recyclerView.itemDecoration.DefaultDividerItemDecoration;
import com.kimeeo.kAndroid.listViews.viewHelper.RecyclerViewHelper;
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
            rootView = inflater.inflate(R.layout._fragment_recycler_with_swipe_refresh_layout, container, false);
        else
            rootView = inflater.inflate(R.layout._fragment_recycler, container, false);

        RecyclerViewHelper helper = new RecyclerViewHelper();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        helper.with(recyclerView);

        if (rootView.findViewById(R.id.swipeRefreshLayout) != null) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
            helper.swipeRefreshLayout(swipeRefreshLayout);
        }

        View emptyView = rootView.findViewById(R.id.emptyView);
        if (emptyView != null)
            helper.emptyView(emptyView);

        helper.layoutManager(createLayoutManager());
        helper.decoration(getDividerDecoration());


        BaseRecyclerViewAdapter adapter = createListViewAdapter(dataManager);
        helper.adapter(adapter);


        helper.dataManager(dataManager);
        helper.setOnItemClick(new RecyclerViewHelper.OnItemClick() {
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

    protected RecyclerView.ItemDecoration getDividerDecoration() {
        return new DefaultDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
    }

    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        return linearLayoutManager;
    }


    @Override
    public View getItemView(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.sample_list_view_item, viewGroup, false);
    }

    @Override
    public BaseItemHolder getItemHolder(int i, View view) {
        return new BaseItemHolder1(view);
    }


    @Override
    public int getListItemViewType(int i, Object o) {
        return BaseRecyclerViewAdapter.ViewTypes.VIEW_ITEM;
    }

    protected BaseRecyclerViewAdapter createListViewAdapter(DataProvider dataManager) {
        return new DefaultRecyclerViewAdapter(dataManager, this);
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
