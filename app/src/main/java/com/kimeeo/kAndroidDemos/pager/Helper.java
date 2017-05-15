package com.kimeeo.kAndroidDemos.pager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.pager.BaseItemHolder;
import com.kimeeo.kAndroid.listViews.pager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.kAndroid.listViews.pager.viewPager.DefaultViewPagerAdapter;
import com.kimeeo.kAndroid.listViews.viewHelper.ViewPagerHelper;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 21/05/16.
 */
public class Helper extends BaseFragment implements com.kimeeo.kAndroid.listViews.pager.viewPager.IViewProvider {

    ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        DataProvider dataManager = createDataProvider();
        View rootView;
        if (dataManager.getRefreshEnabled())
            rootView = inflater.inflate(R.layout._fragment_page_view_with_swipe_refresh_layout, container, false);
        else
            rootView = inflater.inflate(R.layout._fragment_page_view, container, false);

        ViewPagerHelper viewPagerHelper = new ViewPagerHelper();
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        viewPagerHelper.with(viewPager);
        viewPagerHelper.dataProvider(dataManager);
        viewPagerHelper.adapter(createViewPagerAdapter(dataManager));

        if (rootView.findViewById(R.id.swipeRefreshLayout) != null) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
            viewPagerHelper.swipeRefreshLayout(swipeRefreshLayout);
        }

        View emptyView = rootView.findViewById(R.id.emptyView);
        if (emptyView != null)
            viewPagerHelper.emptyView(emptyView);
        View indicator = rootView.findViewById(R.id.indicator);
        if (indicator != null)
            viewPagerHelper.indicator(indicator);


        try {
            viewPagerHelper.create();
        } catch (Exception e) {
        }

        return rootView;
    }

    protected BaseViewPagerAdapter createViewPagerAdapter(DataProvider dataManager) {
        return new DefaultViewPagerAdapter(dataManager, this);
    }

    @NonNull
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    @Override
    public String getItemTitle(int position, Object o) {
        if (o instanceof DataBean) {
            DataBean data = (DataBean) o;
            return data.getName();

        }
        return "";
    }

    @Override
    public void removeView(View view, int position, BaseItemHolder itemHolder) {

    }

    @Override
    public BaseItemHolder getItemHolder(View view, int i, Object o) {
        return new BaseItemHolder1(view);
    }

    @Override
    public ViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public View getView(int i, Object o) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.sample_list_view_item, null);
        return view;
    }

    public class BaseItemHolder1 extends BaseItemHolder {
        public BaseItemHolder1(View itemView) {
            super(itemView);
        }

        @Override
        public void cleanView(View view, int i) {

        }

        @Override
        public void updateItemView(Object o, View view, int i) {
            DataBean data = (DataBean) o;
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(i + ". " + data.getName());
        }
    }
}
