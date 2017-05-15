package com.kimeeo.kAndroidDemos.pager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroid.dataProvider.DataProvider;
import com.kimeeo.kAndroid.listViews.pager.fragmentPager.BaseFragmentViewPagerAdapter;
import com.kimeeo.kAndroid.listViews.pager.fragmentPager.DefaultViewFragmentPagerAdapter;
import com.kimeeo.kAndroid.listViews.pager.fragmentPager.IFragmentProvider;
import com.kimeeo.kAndroid.listViews.viewHelper.ViewPagerFragmentHelper;
import com.kimeeo.kAndroidDemos.R;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.GridView;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.ListView;
import com.kimeeo.kAndroidDemos.services.DataBean;
import com.kimeeo.kAndroidDemos.services.aADataProvider.AQDataProvider;

/**
 * Created by BhavinPadhiyar on 21/05/16.
 */
public class HelperFragment extends BaseFragment implements IFragmentProvider, BaseFragmentViewPagerAdapter.OnItemCreated {

    ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        DataProvider dataManager = createDataProvider();
        View rootView;
        if (dataManager.getRefreshEnabled())
            rootView = inflater.inflate(R.layout._fragment_page_view_with_swipe_refresh_layout, container, false);
        else
            rootView = inflater.inflate(R.layout._fragment_page_view, container, false);

        ViewPagerFragmentHelper viewPagerHelper = new ViewPagerFragmentHelper();
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        viewPagerHelper.with(viewPager);
        viewPagerHelper.dataProvider(dataManager);
        viewPagerHelper.fragmentAdapter(createViewPagerAdapter(dataManager));

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

    public BaseFragmentViewPagerAdapter createViewPagerAdapter(DataProvider dataManager) {
        FragmentManager fragmentManager = getChildFragmentManager();
        return new DefaultViewFragmentPagerAdapter(fragmentManager, dataManager, viewPager, this, this);
    }

    @NonNull
    protected DataProvider createDataProvider() {
        return new AQDataProvider(getActivity(), true, true);
    }

    @Override
    public Fragment getItemFragment(int i, Object o) {
        Fragment view;
        if (i < 5)
            view = BaseFragment.newInstance(ListView.class);
        else
            view = BaseFragment.newInstance(GridView.class);
        return view;
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
    public void onItemCreated(Fragment fragment) {

    }

    @Override
    public void onDestroyItem(Fragment fragment) {

    }
}
